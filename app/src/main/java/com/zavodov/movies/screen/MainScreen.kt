package com.zavodov.movies.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.zavodov.movies.MainViewModel
import com.zavodov.movies.data.model.Movies
import com.zavodov.movies.navigation.Screens
import com.zavodov.movies.utils.Constants
import okhttp3.internal.immutableListOf

/**
 * Created by Zavodov on 21.08.2022
 */
@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel){
	val allMovies = viewModel.allMovies.observeAsState(immutableListOf()).value
	Surface(
		modifier = Modifier.fillMaxSize()
	) {
		LazyColumn(
			modifier = Modifier.padding(10.dp)
		){
			items(allMovies) {
				MovieItem(item = it, navController = navController)
			}
		}
	}
}

@Composable
fun MovieItem(item: Movies, navController: NavHostController) {
	Card(
		elevation = 4.dp,
		modifier = Modifier
			.padding(top = 8.dp)
			.clickable {
				navController.navigate(Screens.Details.route + "/${item.id}")
			}
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(vertical = 16.dp)
		) {
			Image(
				painter = rememberImagePainter(item.image.medium),
				contentDescription = null,
				modifier = Modifier.size(120.dp)
			)
			Column {
				Text(
					text = item.name,
					fontSize = 24.sp,
					fontWeight = FontWeight.Bold)
				Row {
					Text(
						text = "Rating: ",
						fontWeight = FontWeight.Bold)
					Text(
						text = item.rating.average.toString())
				}
				Row {
					Text(
						text = "Genre: ",
						fontWeight = FontWeight.Bold)
					item.genres.take(2).forEach { Text(text = " $it ") }
				}
				Row {
					Text(
						text = "Premiered: ",
						fontWeight = FontWeight.Bold)
					Text(
						text = item.premiered)
				}
			}

		}

	}
}