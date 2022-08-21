package com.zavodov.movies.di

import com.zavodov.movies.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Zavodov on 21.08.2022
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

	@Provides
	fun baseUrl() = "https://api.tvmaze.com/"

	@Provides
	@Singleton
	fun provideRetrofit(baseUrl: String): ApiService =
		Retrofit.Builder()
			.baseUrl(baseUrl)
			.client(okHttpClient)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(ApiService::class.java)

	private fun okHttpInterceptor(): HttpLoggingInterceptor {
		val httpLoggingInterceptor = HttpLoggingInterceptor()
		httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
		return httpLoggingInterceptor
	}

	private val okHttpClient = OkHttpClient.Builder()
		.addInterceptor(okHttpInterceptor()).build()

}