package com.zavodov.movies.screen

import android.graphics.Color
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.font.FontWeight.Companion.Black
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.zavodov.movies.navigation.Screens
import com.zavodov.movies.utils.Constants
import kotlinx.coroutines.delay

/**
 * Created by Zavodov on 21.08.2022
 */
@Composable
fun SplashScreen(navHostController: NavHostController){
	var startAnimate by remember {
		mutableStateOf(false)
	}
	val alphaAnimate = animateFloatAsState(
		targetValue = if (startAnimate) 1f else 0f,
		animationSpec = tween(durationMillis = 3000))
	LaunchedEffect(key1 = true) {
		startAnimate = true
		delay(4000)
		navHostController.navigate(Screens.Main.route)
	}
	Splash(alphaAnimate.value)
}

@Composable
fun Splash(alpha: Float){
	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		Icon(
			modifier = Modifier.size(120.dp).alpha(alpha),
			imageVector = Icons.Default.PlayArrow,
			contentDescription = "",
			tint = androidx.compose.ui.graphics.Color.Black
		)
	}
}

@Preview(showBackground = true)
@Composable
fun previewSplash(){
}