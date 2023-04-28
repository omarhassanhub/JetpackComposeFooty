package com.example.jetpackcomposefooty.utils

import java.text.SimpleDateFormat
import java.util.*

fun getMatchDayAndMonth(date: String): String? {
    val parser = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val formatter = SimpleDateFormat("d MMM", Locale.ENGLISH)
    return date.let { it -> parser.parse(it)?.let { formatter.format(it)  } }
}

fun getMatchTime(date: String): String? {
    val parser = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val formatter = SimpleDateFormat("hh:mm a", Locale.ENGLISH)
    return date.let { it -> parser.parse(it)?.let { formatter.format(it)  } }
}