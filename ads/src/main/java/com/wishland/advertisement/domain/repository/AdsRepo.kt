package com.wishland.advertisement.domain.repository

import com.wishland.advertisement.data.dto.RequestModel
import com.wishland.advertisement.data.dto.ResponseModel
import kotlinx.coroutines.flow.Flow

interface AdsRepo {
    suspend fun getJumpCodeUrl(param: RequestModel): Flow<ResponseModel>
}