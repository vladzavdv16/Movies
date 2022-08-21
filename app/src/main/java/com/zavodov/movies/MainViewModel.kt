package com.zavodov.movies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zavodov.movies.data.model.Movies
import com.zavodov.movies.data.repositories.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Zavodov on 21.08.2022
 */
@HiltViewModel
class MainViewModel @Inject constructor(
	private val repository: MoviesRepository
): ViewModel() {

	val allMovies = MutableLiveData<List<Movies>>()

	fun getAllMovies() {
		viewModelScope.launch {
			repository.getAllMovies().let {
				if (it.isSuccessful){
					allMovies.postValue(it.body())
				} else {
					Log.d("Zavodov", "MainViewModel getAllMovies: ${it.errorBody()}")
				}
			}
		}
	}
}