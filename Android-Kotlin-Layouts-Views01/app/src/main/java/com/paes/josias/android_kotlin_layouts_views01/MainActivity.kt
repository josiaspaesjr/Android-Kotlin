package com.paes.josias.android_kotlin_layouts_views01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeText(v:View){
        tvText.setText(R.string.str01);
    }

    fun clearText(v:View){
        tvText.setText("");
    }
}
