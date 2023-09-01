package com.example.jetpackcomposefooty.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.jetpackcomposefooty.R
import com.example.jetpackcomposefooty.domain.model.Match
import com.example.jetpackcomposefooty.domain.model.Transfers

@Composable
fun MatchesScreen(vm: Match) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
//            .wrapContentSize(Alignment.Center)
    ){
//        Text(
//            text = "Matches",
//            fontWeight = FontWeight.Bold,
//            color = Color.White,
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            textAlign = TextAlign.Center,
//            fontSize = 20.sp
//        )

        DateCarousel()
        MatchCardScreen(vm)
        MatchCardScreen(vm)
        MatchCardScreen(vm)

    }
}

@Composable
fun NewsScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
//            .wrapContentSize(Alignment.Center)
    ){
        LargeCard(
            name = "Haaland for Vinicius at Realmadrid? Not for Ancelotti",
            time = "1 hr ago",
            painter = painterResource(id = R.drawable.ic_launcher_background),
            icon = painterResource(id = R.drawable.ic_launcher_background)
        )
        SmallCard(
            name = "Haaland for Vinicius at Realmadrid? Not for Ancelotti",
            cost = "1 hr ago",
            painter = painterResource(id = R.drawable.ic_launcher_background),
            icon = painterResource(id = R.drawable.ic_launcher_background)
        )
    }
}

@Composable
fun LeaguesScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_200))
            .wrapContentSize(Alignment.Center)
    ){
        Navigation()
    }
}

@Composable
fun FollowingScreen(data: Transfers) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_200))
            .wrapContentSize(Alignment.Center)
    ){
        MyCardList(data)
    }
}

@Composable
fun SettingsScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_200))
            .wrapContentSize(Alignment.Center)
    ){
        Settings()
    }
}



//@Preview
//@Composable
//fun MatchCardPreview(){
//    JetpackComposeFootballTheme(darkTheme = true) {
//        MatchesScreen(vm)
//    }
//}