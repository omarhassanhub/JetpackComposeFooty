package com.example.jetpackcomposefooty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
import com.example.jetpackcomposefooty.domain.model.Match
import com.example.jetpackcomposefooty.ui.screens.BottomNavItem
import com.example.jetpackcomposefooty.ui.screens.FollowingScreen
import com.example.jetpackcomposefooty.ui.screens.LeaguesScreen
import com.example.jetpackcomposefooty.ui.screens.MatchesScreen
import com.example.jetpackcomposefooty.ui.screens.NewsScreen
import com.example.jetpackcomposefooty.ui.screens.SettingsScreen
import com.example.jetpackcomposefooty.ui.screens.TopBar
import com.example.jetpackcomposefooty.ui.theme.JetpackComposeFootballTheme
import com.example.jetpackcomposefooty.utils.ApiState
import com.example.jetpackcomposefooty.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeFootballTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }

                val mainViewModel = hiltViewModel<MainViewModel>()
                GETData(mainViewModel)
            }
        }
    }
}

@Composable
private fun HomeScreenView(vm: Match) {
    val navigationController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigation(navigationController = navigationController) },
    ) { contentPadding ->
        NavigationGraph(navigationController = navigationController, contentPadding, vm)
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
        backgroundColor = colorResource(id = R.color.teal_200),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navigationController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title, fontSize = 9.sp) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
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
fun NavigationGraph(
    navigationController: NavHostController,
    contentPadding: PaddingValues,
    vm: Match
) {

    NavHost(navigationController, startDestination = BottomNavItem.Matches.route) {


        composable(BottomNavItem.Matches.route) {
            MatchesScreen(vm)
        }
        composable(BottomNavItem.News.route) {
            NewsScreen()
        }
        composable(BottomNavItem.Leagues.route) {
            LeaguesScreen()
        }
        composable(BottomNavItem.Following.route) {
            FollowingScreen()
        }
        composable(BottomNavItem.Settings.route) {
            SettingsScreen()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeFootballTheme {
        Greeting("Android")
    }
}

@Composable
fun GETData(mainViewModel: MainViewModel) {
    when (val result = mainViewModel.response.value) {
        is ApiState.Success -> {
//            LazyColumn {
//                items(result.data) { response ->
//                    EachRow(post = response)
//                }
//            }
            HomeScreenView(result.data)
        }

        is ApiState.Failure -> {
            Text(text = "${result.msg}")
        }

        ApiState.Loading -> {
            CircularProgressIndicator()
        }

        ApiState.Empty -> {

        }
    }
}