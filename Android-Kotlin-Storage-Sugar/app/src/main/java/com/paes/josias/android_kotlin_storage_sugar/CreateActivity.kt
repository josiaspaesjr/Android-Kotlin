package com.paes.josias.android_kotlin_storage_sugar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.paes.josias.android_kotlin_storage_sugar.orm.Books
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
    }

    fun saveBook(v:View){
        if( etTitle.text.toString().isNotEmpty()
            &&  etAuthor.text.toString().isNotEmpty()){
            var b:Books = Books()
            b.title = etTitle.text.toString()
            b.author = etAuthor.text.toString()
            b.save();
            Toast.makeText(this@CreateActivity,
                    R.string.str02, Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this@CreateActivity,
                    R.string.str01, Toast.LENGTH_LONG).show()
        }
    }
}

