package com.paes.josias.android_kotlin_mvp.mvp

/**
 * Created by Josias on 22/08/2017.
 */
interface MainContract {

    interface MyView{
        fun setResult(result:String)
    }

    interface MyModel{
        fun calc(op: String = "+", num1:Int = 0, num2:Int = 0):Float
    }

}