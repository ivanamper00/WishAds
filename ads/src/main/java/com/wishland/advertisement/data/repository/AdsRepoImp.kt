package com.wishland.advertisement.data.repository

import com.wishland.advertisement.data.data_source.AdsService
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import com.wishland.advertisement.data.dto.RequestModel
import com.wishland.advertisement.data.dto.ResponseModel
import com.wishland.advertisement.domain.repository.AdsRepo
import com.wishland.advertisement.utils.RetrofitHelper

class AdsRepoImp: AdsRepo {

    private val service: AdsService = RetrofitHelper.service()

    override suspend fun getJumpCodeUrl(param: RequestModel): Flow<ResponseModel> = callbackFlow {
        trySend(service.getJumpCode(param))
        awaitClose()
    }

}