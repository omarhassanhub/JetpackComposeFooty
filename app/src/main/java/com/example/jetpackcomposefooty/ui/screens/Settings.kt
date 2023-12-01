package com.example.jetpackcomposefooty.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposefooty.R
import com.example.jetpackcomposefooty.ui.theme.JetpackComposeFootballTheme

@Composable
fun ListRow(model: SettingsModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(color = Color.Black)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}
data class SettingsModel(val name:String, val image : Int)
private val fruitsList = mutableListOf<SettingsModel>()

@Composable
fun Settings(){

    fruitsList.add(SettingsModel("Theme", R.drawable.baseline_sensor_window_24))
    fruitsList.add(SettingsModel("About us", R.drawable.baseline_sensor_window_24))
    fruitsList.add(SettingsModel("Follow us", R.drawable.baseline_sensor_window_24))
    fruitsList.add(SettingsModel("Notifications", R.drawable.baseline_sensor_window_24))

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        items(fruitsList) { model ->
            ListRow(model = model)
        }
    }
}

@Preview()
@Composable
fun SettingsPreview(){
    JetpackComposeFootballTheme(darkTheme = true) {
        Settings()
    }
}

