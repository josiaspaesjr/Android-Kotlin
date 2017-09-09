package com.paes.josias.android_kotlin_retrofit.mvp

import com.paes.josias.android_kotlin_retrofit.models.Post

/**
 * Created by Josias on 30/08/2017.
 */
class MainPresenter (val mainView:MainContract.MainView) {

    var mainModel:MainContract.MainModel

    init{
        mainModel = MainModel()
    }

    fun sendRequestGet(postId:Int){
        mainModel.requestPostGet(postId, this@MainPresenter, mainView.getMyContext())
    }

    fun sendRequestPost(post:Post){
        mainModel.sendNewPost(post, this@MainPresenter, mainView.getMyContext())
    }

    fun result(msg:String){
        mainView.hideProgressDialog()
        mainView.showResult(msg)
    }
}