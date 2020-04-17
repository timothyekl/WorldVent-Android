package com.timekl.worldvent.ui.worldwent

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.timekl.worldvent.R
import com.timekl.worldvent.ui.shared.GenericWebView
import com.timekl.worldvent.ui.shared.KeyEventsFragment
import kotlinx.android.synthetic.main.fragment_webview.*

class WorldVentFragment : Fragment(), KeyEventsFragment {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_webview, container, false)
        val webView: GenericWebView = root.findViewById(R.id.webView)

        val url = "file:///android_asset/www/worldvent/index.html"

        webView.loadUrl(url)

        return root
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return false
    }
}