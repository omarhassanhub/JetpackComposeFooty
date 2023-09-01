package com.example.jetpackcomposefooty.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposefooty.domain.model.Fixtures
import com.example.jetpackcomposefooty.domain.model.Match
import com.example.jetpackcomposefooty.domain.model.Transfers
import com.example.jetpackcomposefooty.network.MainRepository
import com.example.jetpackcomposefooty.utils.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransfersMainViewModel
@Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    val response: MutableState<ApiResult<Transfers>> = mutableStateOf(ApiResult.Empty)

    init {
        getData()
    }

    private fun getData() =
        viewModelScope.launch {
            mainRepository.getTransfersData().onStart {
                response.value = ApiResult.Loading
            }.catch {
                response.value = ApiResult.Error(it.message)
            }.collect {
                response.value = ApiResult.Success(it)
            }
        }
}

