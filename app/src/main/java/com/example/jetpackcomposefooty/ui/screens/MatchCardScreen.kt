package com.example.jetpackcomposefooty.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposefooty.domain.model.FixturesData
import com.example.jetpackcomposefooty.domain.model.exampleFixtures
import com.example.jetpackcomposefooty.ui.theme.JetpackComposeFootballTheme
import com.example.jetpackcomposefooty.utils.LoadImageFromUrl

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MatchCardScreen(data: FixturesData) {
    Card(
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .height(150.dp)
            .padding(10.dp),
        elevation = 0.dp
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                LoadImageFromUrl(
                    url = data.league.country_flag,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(16.dp)
                )

                Text(
                    text = data.league.name,
                    modifier = Modifier.align(alignment = CenterVertically),
                    style = MaterialTheme.typography.subtitle1
                )
            }

            Divider(color = Color.Gray, thickness = 0.5.dp)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data.teams.home.name,
                    style = MaterialTheme.typography.subtitle1
                )
                LoadImageFromUrl(
                    url = data.teams.home.img,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(16.dp)
                )

                Chip(
                    onClick = { /*TODO*/ },
                    colors = ChipDefaults.chipColors(
                        contentColor = Color.White,
                        backgroundColor = Color.DarkGray
                    ),
                    modifier = Modifier.align(alignment = CenterVertically)
                ) {
                    Text(
                        text = data.time.time,
                        style = MaterialTheme.typography.subtitle1
                    )
                }

                LoadImageFromUrl(
                    url = data.teams.home.img,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(16.dp)
                )

                Text(
                    text = data.teams.away.name,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}


@Preview()
@Composable
fun MatchCardScreenPreview() {
    JetpackComposeFootballTheme(darkTheme = true) {
        MatchCardScreen(
            exampleFixtures
        )
    }
}
