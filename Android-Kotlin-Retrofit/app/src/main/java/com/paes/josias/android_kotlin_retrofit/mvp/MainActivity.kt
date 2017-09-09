package com.paes.josias.android_kotlin_retrofit.mvp

import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.paes.josias.android_kotlin_retrofit.R
import com.paes.josias.android_kotlin_retrofit.models.Post
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.MainView {

    val mPresenter:MainPresenter by lazy { MainPresenter(this) }
    val progress:ProgressDialog by lazy { ProgressDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun sendRequestGet(v:View){
        if(etIdCommet.text.toString().isNotEmpty()){
            showProgressDialog()
            mPresenter.sendRequestGet(etIdCommet.text.toString().toInt());
        }else{
            Toast.makeText(this@MainActivity, "EditText is Empty", Toast.LENGTH_SHORT).show()
        }

    }
    override fun sendRequestPost(v:View){
        showProgressDialog()
        val post = Post(1,0, "My Post", "My Post Body")
        mPresenter.sendRequestPost(post);
    }

    override fun showResult(msg: String) {
        etIdCommet.setText("")
        tvResult.setText(msg)
    }

    override fun getMyContext(): Context {
        return applicationContext
    }

    override fun showProgressDialog() {
        progress.setCancelable(false)
        progress.setMessage("Loading ...")
        progress.show()
    }

    override fun hideProgressDialog() {
        progress.dismiss()
    }
}
