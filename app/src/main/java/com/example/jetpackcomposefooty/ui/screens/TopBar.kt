package com.example.jetpackcomposefooty.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposefooty.ui.theme.JetpackComposeFootballTheme

@Preview
@Composable
fun TopBar(route: String?) {
    val contextForToast = LocalContext.current.applicationContext

    JetpackComposeFootballTheme(darkTheme = true) {
        TopAppBar(
            title = {
                Text(text = "Champagne football")
            },
            actions = {
                if(route != "matches") showSearchIcon(contextForToast)
            }
        )
    }
}

@Composable
private fun showSearchIcon(contextForToast: Context?) {
    TopAppBarActionButton(
        imageVector = Icons.Outlined.Search,
        description = "Search"
    ) {
        Toast.makeText(contextForToast, "Search Click", Toast.LENGTH_SHORT)
            .show()
    }
}

@Composable
fun TopAppBarActionButton(
    imageVector: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = imageVector, contentDescription = description)
    }
}