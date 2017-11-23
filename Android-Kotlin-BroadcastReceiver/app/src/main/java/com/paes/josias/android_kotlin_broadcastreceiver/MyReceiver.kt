package com.paes.josias.android_kotlin_broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver() : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i("BRTESTE", "EXECUTOU O MEU BR")
    }
}
