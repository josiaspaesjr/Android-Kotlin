package com.paes.josias.android_kotlin_retrofit.mvp

import android.content.Context
import android.view.View
import com.paes.josias.android_kotlin_retrofit.models.Post

/**
 * Created by Josias on 30/08/2017.
 */
interface MainContract {

    interface MainView{
        fun sendRequestGet(v:View)
        fun sendRequestPost(v:View)
        fun showResult(msg:String)
        fun getMyContext():Context
        fun showProgressDialog()
        fun hideProgressDialog()
    }

    interface MainModel{
        fun requestPostGet(postId:Int, mainPresenter: MainPresenter, context:Context)
        fun sendNewPost(post:Post, mainPresenter: MainPresenter, context:Context)
    }

}