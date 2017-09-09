package com.paes.josias.android_kotlin_layouts_views03

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeText(v:View){
        if(cbBlock.isChecked){
            Toast.makeText(this, R.string.str06, Toast.LENGTH_LONG).show();
        }else{
            tvText.setText(etText.text.toString());
            etText.setText("");
        }
    }

    fun clearText(v:View){
        tvText.setText("");
        etText.setText("");
    }

}
