package com.paes.josias.android_kotlin_layouts_views08

import android.app.DialogFragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.paes.josias.android_kotlin_layouts_views08.pickers.DatePicker
import com.paes.josias.android_kotlin_layouts_views08.pickers.TimerPicker

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showTimerPicker(v:View){
        var newDialog: DialogFragment = TimerPicker()
        newDialog.show(fragmentManager, "timePicker")
    }
    fun showDatePicker(v:View){
        var newDialog: DialogFragment = DatePicker()
        newDialog.show(fragmentManager, "DatePicker")
    }
}

