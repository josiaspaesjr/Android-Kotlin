package com.paes.josias.android_kotlin_layouts_views04

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeText(v:View){
        if(rbBlock.isChecked){
            Toast.makeText(this, R.string.str06, Toast.LENGTH_LONG).show();
        }else if(rbFree.isChecked){
            tvText.setText(etText.text.toString());
            etText.setText("");
        }else{
            Toast.makeText(this, R.string.str09, Toast.LENGTH_LONG).show();
        }
    }

    fun rbClick(v:View){
        if(rbBlock.isChecked){
            Toast.makeText(this, R.string.str06, Toast.LENGTH_LONG).show();
        }else if(rbFree.isChecked){
            Toast.makeText(this, R.string.str08, Toast.LENGTH_LONG).show();
        }
    }

    fun clearText(v:View){
        tvText.setText("");
        etText.setText("");
    }

}
