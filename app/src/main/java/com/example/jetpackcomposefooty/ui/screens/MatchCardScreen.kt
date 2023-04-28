package com.example.jetpackcomposefooty.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposefooty.R
import com.example.jetpackcomposefooty.domain.model.MATCHSTATUS
import com.example.jetpackcomposefooty.domain.model.Match
import com.example.jetpackcomposefooty.ui.theme.DarkGreen
import com.example.jetpackcomposefooty.ui.theme.JetpackComposeFootballTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MatchCardScreen(match: Match) {
    Card(
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .width(400.dp)
            .height(180.dp)
            .padding(10.dp),
        elevation = 0.dp
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.width(20.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
                        contentDescription = ""
                    )
                }

                Text(
                    text = match.leagueName,
                    modifier = Modifier.alignByBaseline(),
                    style = MaterialTheme.typography.h5
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
                val homeScore = match.homeTeam90MinGoals
                val awayScore = match.awayTeam90MinGoals

                Chip(
                    onClick = { /*TODO*/ },
                    colors = ChipDefaults.chipColors(
                        contentColor = Color.White,
                        backgroundColor = DarkGreen
                    ),
                    modifier = Modifier
                        .alignByBaseline()
//                        .padding(20.dp)
                ) {
                    Text(matchStatus(match))
                }

                Text(
                    text = match.homeTeamName,
                    style = MaterialTheme.typography.h6
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.width(20.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
                        contentDescription = ""
                    )
                }
                Text(
                    text = "$homeScore:$awayScore",
                    style = MaterialTheme.typography.h5
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.width(20.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
                        contentDescription = ""
                    )
                }
                Text(
                    text = match.awayTeamName,
                    style = MaterialTheme.typography.h6
                )
            }
        }
    }
}

fun matchStatus(match: Match): String {
    return when (match.status) {
        MATCHSTATUS.IN_PROGRESS -> "${match.elapsed}"
        MATCHSTATUS.HALF_TIME -> "half time"
        MATCHSTATUS.NOT_STARTED -> "not started"
        MATCHSTATUS.FINISHED -> "finished"
        MATCHSTATUS.CANCELLED -> "cancelled"
        MATCHSTATUS.POSTPONED -> "postponed"
        else -> "suspended"
    }
}

@Preview()
@Composable
fun MenuPreview(){
    JetpackComposeFootballTheme(darkTheme = true) {
        MatchCardScreen(
            dummyMatch
        )
    }
}
