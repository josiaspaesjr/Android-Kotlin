package com.paes.josias.android_kotlin_layouts_sharedpref

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val key = "TEXT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun saveSP(v:View){

        var pref = PreferenceManager.getDefaultSharedPreferences(this)
        var editor = pref.edit()

        //save infos
        editor.putString(key, etText.text.toString())
        editor.commit()

        Toast.makeText(this, "SAVE OK", Toast.LENGTH_SHORT).show()

    }

    fun getSP(v:View){

        var pref = PreferenceManager.getDefaultSharedPreferences(this)
        var value = pref.getString(key, "NOTHING!!!")

        Toast.makeText(this, value, Toast.LENGTH_SHORT).show()

    }


}
