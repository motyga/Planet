package com.example.android.planet

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        var web = web

        web.webViewClient = WebViewClient()
        web.loadUrl(intent.getStringExtra(Intent.ACTION_VIEW))
    }
}
