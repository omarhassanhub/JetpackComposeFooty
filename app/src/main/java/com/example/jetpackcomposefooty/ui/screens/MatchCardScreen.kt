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
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposefooty.R
import com.example.jetpackcomposefooty.domain.model.Match

@Composable
fun MatchCardScreen(todoList: Match) {
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
                    text = todoList.data[20].code!!,
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
//                val homeScore = todoList.first().data.first().season_name
//                val awayScore = todoList.first().data.first().season_name
//
//                Chip(
//                    onClick = { /*TODO*/ },
//                    colors = ChipDefaults.chipColors(
//                        contentColor = Color.White,
//                        backgroundColor = DarkGreen
//                    ),
//                    modifier = Modifier
//                        .alignByBaseline()
////                        .padding(20.dp)
//                ) {
////                    Text(matchStatus(todoList))
//                }
//
                Text(
                    text = todoList.data[30].code!!,
                    style = MaterialTheme.typography.h6
                )
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                        modifier = Modifier.width(20.dp),
//                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
//                        contentDescription = ""
//                    )
//                }
                Text(
                    text = todoList.data[32].code!!,
                    style = MaterialTheme.typography.h5
                )
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                        modifier = Modifier.width(20.dp),
//                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
//                        contentDescription = ""
//                    )
//                }
//                Text(
//                    text = todoList.first().data.first().season_name,
//                    style = MaterialTheme.typography.h6
//                )
            }
        }
    }
}

//fun matchStatus(todoList: List<Match>): String {
//    return when (todoList.first().data) {
//        MATCHSTATUS.IN_PROGRESS -> "${todoList.first().data.first().season_name}"
//        MATCHSTATUS.HALF_TIME -> "half time"
//        MATCHSTATUS.NOT_STARTED -> "not started"
//        MATCHSTATUS.FINISHED -> "finished"
//        MATCHSTATUS.CANCELLED -> "cancelled"
//        MATCHSTATUS.POSTPONED -> "postponed"
//        else -> "suspended"
//    }
//}

//@Preview()
//@Composable
//fun MenuPreview(){
//    JetpackComposeFootballTheme(darkTheme = true) {
//        MatchCardScreen(
//            dummyMatch,
//            vm.todoList
//        )
//    }
//}
