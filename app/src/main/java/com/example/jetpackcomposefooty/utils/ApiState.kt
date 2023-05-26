package com.example.jetpackcomposefooty.utils

import com.example.jetpackcomposefooty.domain.model.Match

sealed class ApiState {
    class Success(val data: Match) : ApiState()
    class Failure(val msg: Throwable) : ApiState()
    object Loading:ApiState()
    object Empty: ApiState()
}