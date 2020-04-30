package com.grayhatdevelopers.thecoronamap.ui.fragments.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.grayhatdevelopers.thecoronamap.R
import kotlinx.android.synthetic.main.fragment_web_view.*

class WebViewFragment : Fragment() {

    val args: WebViewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_web_view, container, false)

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val link = args.link
        webview.webViewClient =
            WebViewClientHelper()
        webview.settings.javaScriptEnabled = true
        webview.loadUrl(link)
    }
}