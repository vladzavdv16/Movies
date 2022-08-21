package com.zavodov.movies.data.repositories

import com.zavodov.movies.data.api.ApiService
import javax.inject.Inject

/**
 * Created by Zavodov on 21.08.2022
 */
class MoviesRepository @Inject constructor(
	private val apiService: ApiService
) {

	suspend fun getAllMovies() = apiService.getAllMovies()

}