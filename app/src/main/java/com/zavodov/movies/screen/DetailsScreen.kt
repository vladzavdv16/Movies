package com.zavodov.movies.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.zavodov.movies.MainViewModel
import com.zavodov.movies.utils.HtmlText

/**
 * Created by Zavodov on 21.08.2022
 */
@Composable
fun DetailsScreen(viewModel: MainViewModel, itemId: String) {
	val currentItem = viewModel.allMovies.observeAsState(listOf())
		.value.firstOrNull{
			it.id == itemId.toInt()
		}

	Surface(
		modifier = Modifier
			.fillMaxSize()
			.padding(vertical = 24.dp, horizontal = 8.dp)
	) {
		LazyColumn(
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			item {
				Image(
					painter = rememberImagePainter(currentItem?.image?.original),
					contentDescription = null,
					modifier = Modifier.size(512.dp)
				)
				Text(
					text = currentItem?.name ?: "",
					fontSize = 32.sp
				)
				Row(
					modifier = Modifier.padding(8.dp)
				) {
					Text(
						text = "Rating: ",
						fontSize = 18.sp,
						fontWeight = FontWeight.Bold
					)
					Text(
						text = currentItem?.rating?.average.toString(),
						fontSize = 18.sp
					)
				}
				Row(
					modifier = Modifier.padding(8.dp)
				) {
					Text(
						text = "Genre: ",
						fontSize = 18.sp,
						fontWeight = FontWeight.Bold
					)
					currentItem?.genres?.take(2)?.forEach {
						Text(text = " $it ", fontSize = 18.sp)
					}
				}
				HtmlText(
					html = currentItem?.summary ?: "",
					modifier = Modifier.padding(top = 8.dp)
				)
			}
		}
	}

}