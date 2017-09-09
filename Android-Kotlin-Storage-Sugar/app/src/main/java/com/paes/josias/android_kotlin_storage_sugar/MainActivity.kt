package com.paes.josias.android_kotlin_storage_sugar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openCreate(v:View){
        startActivity(Intent(this@MainActivity, CreateActivity::class.java))
    }
    fun openRead(v:View){
        startActivity(Intent(this@MainActivity, ReadActivity::class.java))
    }
    fun openCarefulRead(v:View){
        startActivity(Intent(this@MainActivity, CarefulReadActivity::class.java))
    }
    fun openUpdate(v:View){
        startActivity(Intent(this@MainActivity, UpdateActivity::class.java))
    }
    fun openDelete(v:View){
        startActivity(Intent(this@MainActivity, DeleteActivity::class.java))
    }
}
