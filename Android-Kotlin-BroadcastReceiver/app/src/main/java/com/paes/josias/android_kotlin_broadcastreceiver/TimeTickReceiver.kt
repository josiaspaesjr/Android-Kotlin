package com.paes.josias.android_kotlin_broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class TimeTickReceiver(var callback:MyCallBack) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        callback.getResult("01 minuto se passou")
    }
}
