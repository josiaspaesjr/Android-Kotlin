package com.paes.josias.android_kotlin_mvp.mvp

/**
 * Created by Josias on 22/08/2017.
 */
class MainModel: MainContract.MyModel {
    override fun calc(op: String, num1:Int, num2:Int):Float {
        when(op){
            "+" -> return (num1 + num2).toFloat()
            "-" -> return (num1 - num2).toFloat()
            "*" -> return (num1 * num2).toFloat()
            else -> return (num1 / num2).toFloat()
        }

    }
}