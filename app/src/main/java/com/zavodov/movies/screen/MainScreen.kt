package com.zavodov.movies.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by Zavodov on 21.08.2022
 */
@Composable
fun MainScreen(){
	Surface(
		modifier = Modifier.fillMaxSize()
	) {
		Text(text = "Test")
	}
}