package com.example.jetpackcomposefooty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposefooty.ui.screens.BottomNavItem
import com.example.jetpackcomposefooty.ui.screens.FollowingScreen
import com.example.jetpackcomposefooty.ui.screens.LeaguesScreen
import com.example.jetpackcomposefooty.ui.screens.MatchesScreen
import com.example.jetpackcomposefooty.ui.screens.NewsScreen
import com.example.jetpackcomposefooty.ui.screens.SettingsScreen
import com.example.jetpackcomposefooty.ui.screens.TopBar
import com.example.jetpackcomposefooty.ui.theme.JetpackComposeFootballTheme
import com.example.jetpackcomposefooty.utils.ApiResult
import com.example.jetpackcomposefooty.viewmodel.FixturesMainViewModel
import com.example.jetpackcomposefooty.viewmodel.TransfersMainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeFootballTheme(darkTheme = true) {
                HomeScreenView()
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun HomeScreenView() {
    val navigationController = rememberNavController()
    val route = currentRoute(navController = navigationController)
    Scaffold(
        topBar = { TopBar(route) },
        bottomBar = { BottomNavigation(navigationController = navigationController) },
    )
//    { contentPadding ->
//        NavigationGraph(navigationController = navigationController, contentPadding)
//    }

    { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationGraph(navigationController = navigationController, innerPadding)
        }
    }
}

@Composable
fun BottomNavigation(navigationController: NavController) {
    val items = listOf(
        BottomNavItem.Matches,
        BottomNavItem.News,
        BottomNavItem.Leagues,
        BottomNavItem.Following,
        BottomNavItem.Settings
    )

    BottomNavigation(
        backgroundColor = Color.Black,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navigationController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title, fontSize = 9.sp) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navigationController.navigate(item.route) {
                        navigationController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )

        }
    }

}

@Composable
@ExperimentalMaterialApi
fun NavigationGraph(
    navigationController: NavHostController,
    contentPadding: PaddingValues,
) {
    NavHost(navigationController, startDestination = BottomNavItem.Matches.route) {

        composable(BottomNavItem.Matches.route) {
            val viewModel = hiltViewModel<FixturesMainViewModel>()
            val refreshing by viewModel.isRefreshing.collectAsState()
            val pullRefreshState = rememberPullRefreshState(refreshing, { viewModel.getData() })

            when (val result = viewModel.response.value) {
                is ApiResult.Success -> {
                    MatchesScreen(result.data.data, refreshing, pullRefreshState)
                }

                is ApiResult.Error -> {
                    Text(text = "${result.message}")
                }

                ApiResult.Loading -> {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        CircularProgressIndicator()
                    }
                }

                ApiResult.Empty -> {

                }
            }

        }
        composable(BottomNavItem.News.route) {
            NewsScreen()
        }
        composable(BottomNavItem.Leagues.route) {
            LeaguesScreen()
        }
        composable(BottomNavItem.Following.route) {
            val viewModel = hiltViewModel<TransfersMainViewModel>()
            when (val result = viewModel.response.value) {
                is ApiResult.Success -> {
                    FollowingScreen(result.data)
                }

                is ApiResult.Error -> {
                    Text(text = "${result.message}")
                }

                ApiResult.Loading -> {
                    CircularProgressIndicator()
                }

                ApiResult.Empty -> {

                }
            }
        }
        composable(BottomNavItem.Settings.route) {
            SettingsScreen()
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeFootballTheme {
        HomeScreenView()
    }
}
