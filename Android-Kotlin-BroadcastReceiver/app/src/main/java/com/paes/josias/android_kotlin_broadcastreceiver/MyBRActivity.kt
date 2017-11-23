package com.paes.josias.android_kotlin_broadcastreceiver

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MyBRActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_br)

        var intent = Intent()
        intent.action = "com.josias.MYRECEIVER"
        sendBroadcast(intent)

    }
}
