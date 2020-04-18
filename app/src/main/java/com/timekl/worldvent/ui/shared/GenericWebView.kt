package com.timekl.worldvent.ui.shared

import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView
import android.webkit.WebViewClient


class GenericWebView(context: Context?, attrs: AttributeSet?) : WebView(context, attrs) {

    init {
        settings.apply {
            javaScriptCanOpenWindowsAutomatically = true
            loadWithOverviewMode = true
            useWideViewPort = true
            defaultTextEncodingName = "utf-8"
            allowFileAccess = true
            allowFileAccessFromFileURLs = true
            allowUniversalAccessFromFileURLs = true
        }

        setBackgroundColor(0x000523)
        setPadding(0,0,0,0)
        isFocusable = true

        webViewClient = CustomWebClient()
    }

}

private class CustomWebClient : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        return false
    }

}

