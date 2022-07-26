package com.wishland.advertisement.data.data_source

import com.wishland.advertisement.data.dto.RequestModel
import com.wishland.advertisement.data.dto.ResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

interface AdsService {

    @POST("app_conf")
    suspend fun getJumpCode(@Body param: RequestModel): ResponseModel

}