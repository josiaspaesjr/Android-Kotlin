package com.paes.josias.android_kotlin_broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var br = ConnReceiver()
    lateinit var brTick: TimeTickReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerReceiver(br,
                IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"))

        brTick = TimeTickReceiver(object : MyCallBack() {
            override fun getResult(result: String) {
                Toast.makeText(this@MainActivity, result, Toast.LENGTH_LONG).show()
            }
        })

        registerReceiver(brTick, IntentFilter(Intent.ACTION_TIME_TICK))

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(br)
        unregisterReceiver(brTick)
    }

    fun openSecondScreen(v:View){
        startActivity(Intent(this, MyBRActivity::class.java))
    }
}
