package com.example.jetpackcomposefooty.network

import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.ui.platform.LocalContext
import com.example.jetpackcomposefooty.R
import com.example.jetpackcomposefooty.domain.model.Match
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository
@Inject
constructor(private val apiService: ApiService, context: Context){
    private val appInfo = context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
    private val apiName = appInfo.metaData.getString("API_NAME")!!
    private val apiKey = appInfo.metaData.getString("API_TOKEN")!!

    fun getData(): Flow<Match> = flow {
        emit(apiService.getData(apiName, apiKey, "list"))
    }.flowOn(Dispatchers.IO)
}