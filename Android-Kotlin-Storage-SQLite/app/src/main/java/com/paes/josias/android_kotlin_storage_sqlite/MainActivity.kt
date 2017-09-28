package com.paes.josias.android_kotlin_storage_sqlite

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openInserScreen(v: View){
        startActivity(Intent(this@MainActivity, InsertSQLiteActivity::class.java))
    }

    fun openSearchScreen(v: View){
        startActivity(Intent(this@MainActivity, SearchSQLiteActivity::class.java))
    }

    fun openUpdateScreen(v: View){
        startActivity(Intent(this@MainActivity, UpdateSQLiteActivity::class.java))
    }

    fun openDeleteScreen(v: View){
        startActivity(Intent(this@MainActivity, DeleteSQLiteActivity::class.java))
    }

}
