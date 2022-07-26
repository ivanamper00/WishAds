package com.wishland.advertisement.ui

import android.content.pm.PackageManager
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.wishland.advertisement.utils.RetrofitHelper
import com.wishland.advertisement.utils.UiState
import com.wishland.advertisement.utils.isNetworkConnected

abstract class AdsActivity(private val test: Boolean = false): AppCompatActivity() {

    private lateinit var adsViewModel: AdsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appInfo = applicationContext.packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
        RetrofitHelper.baseUrl = appInfo.metaData.getString("appDomain", "https://s2024.com/api/" )

        adsViewModel = ViewModelProvider(this)[AdsViewModel::class.java]

        adsViewModel.urlResponse.observe(this){ state ->
            when(state){
                is UiState.Success -> {
                    if(state.data.code == "0"){
                        Log.d("JumpCode", state.data.data?.jumpAddress ?: "")
                        if(state.data.data?.jump == true)  onAdsLinkLoaded(state.data.data.jumpAddress ?:"")
                        else onAdsFallback()
                    }else onAdsError(state.data.msg)
                }
                is UiState.Error -> onAdsError(state.exception.localizedMessage ?: "")
            }
        }

        if(isNetworkConnected()) adsViewModel.getJumpUrl(
            if(test) "123456" else packageName
        )
        else toNoInternetActivity()
    }

    abstract fun onAdsLinkLoaded(adsLink: String)

    abstract fun onAdsFallback()

    private fun onAdsError(msg: String) {
        Log.d("Error", msg)
        onAdsFallback()
    }

    private fun toNoInternetActivity() {
        startActivity(NoInternetActivity.createIntent(this))
        finish()
    }
}