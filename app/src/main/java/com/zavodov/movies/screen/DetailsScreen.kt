package com.zavodov.movies.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.zavodov.movies.MainViewModel

/**
 * Created by Zavodov on 21.08.2022
 */
@Composable
fun DetailsScreen(navController: NavHostController, viewModel: MainViewModel, itemId: String) {
	Text(text = "itemId: $itemId")

}