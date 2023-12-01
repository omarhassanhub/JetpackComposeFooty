package com.example.jetpackcomposefooty.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposefooty.domain.model.Fixtures
import com.example.jetpackcomposefooty.domain.model.Match
import com.example.jetpackcomposefooty.domain.model.exampleFixtures
import com.example.jetpackcomposefooty.network.MainRepository
import com.example.jetpackcomposefooty.utils.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixturesMainViewModel
@Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    val response: MutableState<ApiResult<Fixtures>> = mutableStateOf(ApiResult.Empty)
    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    init {
        getData()
    }

    fun getData() {
//
        if(response.value is ApiResult.Success && !isRefreshing.value){
            Log.i("@logs", "already fetched data")
            return
        }

        viewModelScope.launch {
            mainRepository.getFixturesData().onStart {
                response.value = ApiResult.Loading
            }.catch {
                response.value = ApiResult.Error(it.message)
            }.collect {
                Log.i("@logs", "fetch data")
                response.value = ApiResult.Success(it)
            }
        }
    }
}

