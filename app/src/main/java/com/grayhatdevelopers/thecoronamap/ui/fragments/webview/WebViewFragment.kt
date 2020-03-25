package com.grayhatdevelopers.thecoronamap.ui.fragments.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.grayhatdevelopers.thecoronamap.R
import kotlinx.android.synthetic.main.fragment_web_view.*

class WebViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_web_view, container, false)

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        webview.webViewClient =
            WebViewClientHelper(
                activity!!
            )
        webview.settings.javaScriptEnabled = true
        webview.loadUrl("https://www.thecoronamap.com/")
    }
}