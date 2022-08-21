package com.zavodov.movies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zavodov.movies.screen.DetailsScreen
import com.zavodov.movies.screen.MainScreen
import com.zavodov.movies.screen.SplashScreen
import com.zavodov.movies.utils.Constants

/**
 * Created by Zavodov on 21.08.2022
 */

sealed class Screens(val route: String){
	object Splash: Screens(Constants.Screens.SPLASH_SCREEN)
	object Main: Screens(Constants.Screens.MAIN_SCREEN)
	object Details: Screens(Constants.Screens.DETAILS_SCREEN)
}

@Composable
fun setupNavHost(navController: NavHostController){
	NavHost(navController = navController,
		startDestination = Screens.Splash.route
	) {
		composable(Screens.Splash.route){
			SplashScreen(navController)
		}
		composable(Screens.Main.route){
			MainScreen()
		}
		composable(Screens.Details.route){
			DetailsScreen()
		}
	}
}