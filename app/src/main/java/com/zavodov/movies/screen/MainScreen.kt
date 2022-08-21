package com.zavodov.movies.screen

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.zavodov.movies.MainViewModel
import com.zavodov.movies.data.model.Movies

/**
 * Created by Zavodov on 21.08.2022
 */
@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel){
	val allMovies = viewModel.allMovies.observeAsState(listOf()).value
	allMovies.forEach {
		Log.d("Zavodov", " MainScreen: ${it.id} ${it.name} ")
	}
	Surface(
		modifier = Modifier.fillMaxSize()
	) {
		LazyColumn{
			items(allMovies) {
				MovieItem(item = it)
			}
		}
	}
}

@Composable
fun MovieItem(item: Movies) {
	Row(
		modifier = Modifier.fillMaxSize()
	) {
		Text(text = item.id.toString())
		Text(text = item.name)
	}
}