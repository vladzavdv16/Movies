package com.zavodov.movies.data.api

import com.zavodov.movies.data.model.Movies
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Zavodov on 21.08.2022
 */
interface ApiService {

	@GET("/shows/")
	suspend fun getAllMovies(): Response<List<Movies>>
}