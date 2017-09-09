package com.paes.josias.android_kotlin_intents

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.view.View
import com.paes.josias.android_kotlin_intents.util.SessionController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun share(v:View){
        var intentShare:Intent = Intent(Intent.ACTION_SEND);
        intentShare.setType("text/plain")
        intentShare.putExtra(Intent.EXTRA_TEXT, "Hey!!!")
        startActivity(intentShare)
    }

    fun openEmail(v:View){
        var intentEmail:Intent = Intent(Intent.ACTION_SENDTO,
                Uri.fromParts("mailto", "abc@abc.com", null))
        intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Email subject")
        intentEmail.putExtra(Intent.EXTRA_TEXT, "Email body")
        startActivity(Intent.createChooser(intentEmail, "Send email ..."))
    }

    fun openDial(v:View){
        startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:232323")))
    }

    fun openActionView01(v:View){
        var i = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.globo.com"))
        startActivity(i)
    }

    fun openSecondActivity(v:View){

        SessionController.value01 = "passing values using singleton pattern"

        var i = Intent(this@MainActivity, SecondActivity::class.java)
        i.putExtra("mykey", "passing values using intent")
        startActivity(i)
    }

    fun openCall(v:View){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(this@MainActivity,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        0);

            }else{
                callNumber()
            }
        }else{
            callNumber()
        }

    }
    fun callNumber(){
        startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:9834")))
    }
}

