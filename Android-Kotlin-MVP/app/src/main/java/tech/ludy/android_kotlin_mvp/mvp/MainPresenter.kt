package com.paes.josias.android_kotlin_mvp.mvp

/**
 * Created by Josias on 22/08/2017.
 */
class MainPresenter(val myView: MainContract.MyView) {

    val myModel:MainContract.MyModel by lazy { MainModel() }

    fun calc(op: String, num1:Int, num2:Int) {
        var result = myModel.calc(op, num1, num2)
        myView.setResult(result.toString())
    }

}