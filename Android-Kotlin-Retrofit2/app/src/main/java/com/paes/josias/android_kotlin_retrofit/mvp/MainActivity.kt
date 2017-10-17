package com.paes.josias.android_kotlin_retrofit.mvp

import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.paes.josias.android_kotlin_retrofit.R
import com.paes.josias.android_kotlin_retrofit.models.AsyncCallback
import com.paes.josias.android_kotlin_retrofit.models.Post
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val progress:ProgressDialog by lazy { ProgressDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendRequestGet(v:View){
        if(etIdCommet.text.toString().isNotEmpty()){
            showProgressDialog()
            var conn = ConnectionService()
            conn.requestPostGet(
                    etIdCommet.text.toString().toInt(),
                    this,
                    object : AsyncCallback() {
                        override fun onSuccess(result:String){
                            showResult(result)
                            hideProgressDialog()
                        }

                        override fun onFailure(result: String) {
                            showResult(result)
                            hideProgressDialog()
                        }
                    })
        }else{
            Toast.makeText(this@MainActivity, "EditText is Empty", Toast.LENGTH_SHORT).show()
        }
    }


    fun sendRequestPost(v:View){
        showProgressDialog()
        val post = Post(1,0, "My Post", "My Post Body")

        var conn = ConnectionService()
        conn.sendNewPost(post, this,
                object : AsyncCallback() {
                    override fun onSuccess(result:String){
                        showResult(result)
                        hideProgressDialog()
                    }

                    override fun onFailure(result: String) {
                        showResult(result)
                        hideProgressDialog()
                    }
                })
    }

    fun showResult(msg: String) {
        etIdCommet.setText("")
        tvResult.setText(msg)
    }

    fun getMyContext(): Context {
        return applicationContext
    }

    fun showProgressDialog() {
        progress.setCancelable(false)
        progress.setMessage("Loading ...")
        progress.show()
    }

    fun hideProgressDialog() {
        progress.dismiss()
    }
}
