package com.paes.josias.android_kotlin_broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log

class ConnReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        var cm:ConnectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        var netInfo = cm.activeNetworkInfo

        if(netInfo != null && netInfo.isConnectedOrConnecting){
            Log.i("BRTESTE","CONECTADO!!!")
        }else{
            Log.i("BRTESTE","DESCONECTADO!!!")
        }

    }
}
