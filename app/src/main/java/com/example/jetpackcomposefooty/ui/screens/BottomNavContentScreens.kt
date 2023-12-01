package com.example.jetpackcomposefooty.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.jetpackcomposefooty.R
import com.example.jetpackcomposefooty.domain.model.FixturesData
import com.example.jetpackcomposefooty.domain.model.Transfers

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MatchesScreen(
    data: List<FixturesData>,
    refreshing: Boolean,
    pullRefreshState: PullRefreshState
) {

//        Text(
//            text = "Matches",
//            fontWeight = FontWeight.Bold,
//            color = Color.White,
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            textAlign = TextAlign.Center,
//            fontSize = 20.sp
//        )

    DateCarousel()

    Box(
        Modifier
            .pullRefresh(pullRefreshState)
//            .verticalScroll(rememberScrollState())
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.black))
        ) {
            items(data) { aboutPackage ->
                MatchCardScreen(aboutPackage)
            }
        }

        PullRefreshIndicator(refreshing, pullRefreshState, Modifier.align(Alignment.TopCenter))
    }
}

@Composable
fun NewsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
//            .wrapContentSize(Alignment.Center)
    ) {
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
fun LeaguesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_200))
            .wrapContentSize(Alignment.Center)
    ) {
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
    ) {
        MyCardList(data)
    }
}

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_200))
            .wrapContentSize(Alignment.Center)
    ) {
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