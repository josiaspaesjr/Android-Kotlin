package com.paes.josias.android_kotlin_intents

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.paes.josias.android_kotlin_intents.util.SessionController

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        showValuesFromIntent(intent)
        showValuesFromSingletonPartner()
    }

    fun showValuesFromIntent(intent: Intent){
        intent.extras?.let {
            var str:String = it.getString("mykey")
            Toast.makeText(this@SecondActivity, str, Toast.LENGTH_LONG).show()
        }
    }

    fun showValuesFromSingletonPartner(){
        Toast.makeText(this@SecondActivity, SessionController.value01, Toast.LENGTH_LONG).show()
    }
}
