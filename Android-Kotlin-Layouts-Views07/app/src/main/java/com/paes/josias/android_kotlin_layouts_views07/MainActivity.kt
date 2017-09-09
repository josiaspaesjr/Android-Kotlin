package com.paes.josias.android_kotlin_layouts_views07

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Remember to add an internet access permission
        wbView.setWebViewClient(MyWebViewClient())
        wbView.settings.loadsImagesAutomatically = true
        wbView.settings.javaScriptEnabled = true
        wbView.settings.setSupportZoom(true)

    }

    fun openUrl(v:View){
        wbView.loadUrl(etURL.text.toString())
    }

    class MyWebViewClient : WebViewClient(){
        //LOLLIPOP OR MORE
        //override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        //  view.loadUrl(request.url)
        //  return super.shouldOverrideUrlLoading(view, request)
        //}
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            if (view != null) {
                view.loadUrl(url)
            }
            return super.shouldOverrideUrlLoading(view, url)
        }
    }

}
