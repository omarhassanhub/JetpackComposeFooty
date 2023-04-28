package com.example.jetpackcomposefooty.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposefooty.R
import com.example.jetpackcomposefooty.ui.theme.JetpackComposeFootballTheme

@Composable
fun SmallCard(
    name:String,
    cost:String,
    painter: Painter,
    icon: Painter
){
    Row(
        modifier = Modifier
            .padding(12.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colors.surface)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(start = 20.dp)
                .clip(RoundedCornerShape(8.dp))
                .size(72.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(1f),
                painter = painter, contentDescription = "",
            )
        }
        Column {
            Text(
                text = name,
                color = Color.White,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = cost,
                color = Color.White,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(start = 20.dp)
            )
        }
    }
}

@Composable
fun LargeCard(
    name:String,
    time:String,
    painter: Painter,
    icon: Painter
){
    Row(
        modifier = Modifier
            .padding(12.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colors.surface)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column {
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .size(400.dp)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(1f),
                    painter = painter, contentDescription = "",
                )
            }
            Text(
                text = name,
                color = Color.White,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = time,
                color = Color.White,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(start = 20.dp)
            )
        }
    }
}

@Preview
@Composable
fun NewsSmallCardPreview(){
    JetpackComposeFootballTheme( darkTheme = true) {
        SmallCard(
            name = "Haaland for Vinicius at Realmadrid? Not for Ancelotti",
            cost = "1 hr ago",
            painter = painterResource(id = R.drawable.ic_launcher_background),
            icon = painterResource(id = R.drawable.ic_launcher_background)
        )
    }
}

@Preview
@Composable
fun NewsLargeCardPreview(){
    JetpackComposeFootballTheme( darkTheme = true) {
        LargeCard(
            name = "Haaland for Vinicius at Realmadrid? Not for Ancelotti",
            time = "1 hr ago",
            painter = painterResource(id = R.drawable.ic_launcher_background),
            icon = painterResource(id = R.drawable.ic_launcher_background)
        )
    }
}