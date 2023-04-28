package com.example.jetpackcomposefooty.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposefooty.R
import com.example.jetpackcomposefooty.ui.theme.JetpackComposeFootballTheme

@Composable
fun MyCardList() {
    val cardData = remember { generateCards() }

    LazyVerticalGrid(
        columns = object : GridCells {
            override fun Density.calculateCrossAxisCellSizes(
                availableSize: Int,
                spacing: Int
            ): List<Int> {
                val firstColumn = (availableSize - spacing) * 2 / 4
                val secondColumn = availableSize - spacing - firstColumn
                return listOf(firstColumn, secondColumn)
            }
        },
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(24.dp)
    ) {
        cardData.forEachIndexed { index, card ->
//            if (index == 0) {
//                item(span = { GridItemSpan(maxLineSpan) }) {
//                    MyCard(
//                        title = card.first,
//                        subtitle = card.second
//                    )
//                }
//            } else {
                item(span = { GridItemSpan(1) }) {
                    FollowingCardList(
                        image = card.image,
                        team = card.team,
                        nextGame = card.nextGame,
                        time = card.time
                    )
                }
            //}
        }
    }
}

@Composable
fun FollowingCardList(
    image: String,
    team: String,
    nextGame: String,
    time: String
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .height(120.dp)
            .width(140.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(
                    start = 4.dp,
                    top = 10.dp,
                    bottom = 16.dp
                )
        ) {
            Text(
                text = image,
                color = Color.White,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
            Text(
                text = team,
                color = Color.White,
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center
            )
            Text(
                text = nextGame,
                color = Color.White,
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center
            )
            Text(
                text = time,
                color = Color.White,
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FollowingCardPreview() {
    JetpackComposeFootballTheme() {
        FollowingCardList(
            image = "image",
            team = "my title",
            nextGame = "my subtitle",
            time = "time"
        )
    }
}

private fun generateCards(): List<FollowData> {
    return List(8) { index ->
        val cardNumber = index + 1
        FollowData(
            image = "Image $cardNumber",
            team = "team $cardNumber",
            nextGame = "nextGame $cardNumber",
            time = "time $cardNumber"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FollowingCardListPreview() {
    JetpackComposeFootballTheme() {
        MyCardList()
    }
}

data class FollowData(
    val image: String,
    val team: String,
    val nextGame: String,
    val time: String
)