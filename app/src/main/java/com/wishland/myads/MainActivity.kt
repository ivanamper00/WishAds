package com.wishland.myads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wishland.advertisement.ui.AdsActivity
import com.wishland.advertisement.ui.WebViewActivity

class MainActivity : AdsActivity(test = true) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onAdsLinkLoaded(adsLink: String) {
        startActivity(WebViewActivity.createIntent(this, adsLink))
        finish()
    }

    override fun onAdsFallback() {
        startActivity(WebViewActivity.createIntent(this, "youtube.com"))
        finish()
    }
}