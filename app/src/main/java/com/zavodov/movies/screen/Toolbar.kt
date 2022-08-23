package com.zavodov.movies.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Zavodov on 23.08.2022
 */
@Composable
fun ToolbarMainScreen(){
	Row(
		modifier = Modifier.size(60.dp),
		horizontalArrangement = Arrangement.Start
	){
		Text(
			text = "Главная",
			fontSize = 24.sp,
			color = Color.Black,
			maxLines = 1)
	}
}