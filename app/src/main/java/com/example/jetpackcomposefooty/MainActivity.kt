package com.example.jetpackcomposefooty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposefooty.ui.screens.*
import com.example.jetpackcomposefooty.ui.theme.JetpackComposeFootballTheme

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
                HomeScreenView()
            }
        }
    }
}

@Composable
private fun HomeScreenView() {
    val navigationController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigation(navigationController = navigationController) },
    ) { contentPadding ->
        NavigationGraph(navigationController = navigationController, contentPadding)
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
fun NavigationGraph(navigationController: NavHostController, contentPadding: PaddingValues) {
    NavHost(navigationController, startDestination = BottomNavItem.Matches.route) {
        composable(BottomNavItem.Matches.route) {
            MatchesScreen()
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