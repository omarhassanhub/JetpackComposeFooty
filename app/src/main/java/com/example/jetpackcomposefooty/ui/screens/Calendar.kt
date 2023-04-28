package com.example.jetpackcomposefooty.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposefooty.ui.theme.JetpackComposeFootballTheme

@Composable
fun DateCarousel() {
    val items = (0..10).map { "Day $it" }
    BoxWithConstraints {
        LazyRow {
            itemsIndexed(items) { index, item ->
                Layout(
                    content = {
                        // Here's the content of each list item.
                        Box(
                            Modifier
                                .size(50.dp)
                                .padding(8.dp)
                                .background(Color.Black)
                        ) {
                            Text(text = item, Modifier.align(Alignment.Center), color = Color.Gray, fontSize = 10.sp)
                        }
                    },
                    measurePolicy = { measurables, constraints ->
                        val placeable = measurables.first().measure(constraints)
                        val maxWidthInPx = maxWidth.roundToPx()
                        val itemWidth = placeable.width
                        val startSpace =
                            if (index == 0) (maxWidthInPx - itemWidth) / 2 else 0
                        val endSpace =
                            if (index == items.lastIndex) (maxWidthInPx - itemWidth) / 2 else 0
                        val width = startSpace + placeable.width + endSpace
                        layout(width, placeable.height) {
                            val x = if (index == 0) startSpace else 0
                            placeable.place(x, 0)
                        }
                    }
                )
            }
        }
    }
}


@Preview()
@Composable
fun DateCarouselPreview(){
    JetpackComposeFootballTheme(darkTheme = true) {
        DateCarousel()
    }
}

// Source: //https://stackoverflow.com/questions/71838922/jetpack-compose-make-the-first-element-in-a-lazyrow-be-aligned-to-the-center-o