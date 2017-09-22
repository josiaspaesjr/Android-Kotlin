package com.paes.josias.android_kotlin_layouts_views09

import android.app.ProgressDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun dialog01(v:View){
        var dialog:AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
        dialog.setTitle(R.string.dialogs)
        dialog.setMessage(R.string.dialogs_example)
        dialog.show();
    }

    fun dialog02(v:View){
        var dialog:AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
        dialog.setTitle(R.string.dialogs)
        dialog.setMessage(R.string.dialogs_example)
        dialog.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(applicationContext, "You clicked on POSITIVE Button", Toast.LENGTH_SHORT).show()
        })
        dialog.show();
    }
    fun dialog03(v:View){
        var dialog:AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
        dialog.setTitle(R.string.dialogs)
        dialog.setMessage(R.string.dialogs_example)
        dialog.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(applicationContext, "You clicked on POSITIVE Button", Toast.LENGTH_SHORT).show()
        })
        dialog.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(applicationContext, "You clicked on NEGATIVE Button", Toast.LENGTH_SHORT).show()
        })
        dialog.show();
    }

    fun dialog04(v:View){
        var dialog:AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
        dialog.setTitle(R.string.dialogs)
        dialog.setMessage(R.string.dialogs_example)
        dialog.setCancelable(false)
        dialog.show();
    }

    fun dialog05(v:View){
        var dialog:ProgressDialog = ProgressDialog(this@MainActivity)
        dialog.setTitle(R.string.dialogs)
        dialog.setMessage(getString(R.string.dialogs_example))
        dialog.show();
    }
}
