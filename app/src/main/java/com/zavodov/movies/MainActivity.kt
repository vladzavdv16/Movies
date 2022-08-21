package com.zavodov.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.zavodov.movies.navigation.SetupNavHost
import com.zavodov.movies.ui.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MoviesTheme {
				val navController = rememberNavController()
				val viewModel = hiltViewModel<MainViewModel>()
				SetupNavHost(navController = navController, viewModel = viewModel)
			}
		}
	}
}