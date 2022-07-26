package com.wishland.advertisement.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wishland.advertisement.data.dto.RequestModel
import com.wishland.advertisement.data.dto.ResponseModel
import com.wishland.advertisement.data.repository.AdsRepoImp
import com.wishland.advertisement.domain.repository.AdsRepo
import com.wishland.advertisement.utils.UiState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AdsViewModel: ViewModel() {

    private val repo: AdsRepo = AdsRepoImp()

    private val _urlResponse = MutableLiveData<UiState<ResponseModel>>()
    val urlResponse : LiveData<UiState<ResponseModel>>
        get() = _urlResponse

    fun getJumpUrl(packageName: String){
        val param = RequestModel(
            packageName
        )
        viewModelScope.launch {
            repo.getJumpCodeUrl(param)
                .catch { err -> _urlResponse.value = UiState.Error(err) }
                .collectLatest {
                    _urlResponse.value = UiState.Success(it)
                }
        }
    }
}