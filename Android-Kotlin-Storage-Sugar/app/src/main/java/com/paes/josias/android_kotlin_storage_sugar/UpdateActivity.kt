package com.paes.josias.android_kotlin_storage_sugar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.orm.SugarRecord
import com.paes.josias.android_kotlin_storage_sugar.orm.Books
import kotlinx.android.synthetic.main.activity_update.*

class UpdateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
    }

    fun update(v:View){

        if( etTitle.text.toString().isNotEmpty()
            && etNewTitle.text.toString().isNotEmpty()){
            val books:List<Books> = SugarRecord.find(Books::class.java,
                    "title = ?", etTitle.text.toString())

            for(book in books){
                book.title = etNewTitle.text.toString()
                book.save()
            }
            Toast.makeText(this@UpdateActivity,
                    R.string.str02, Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this@UpdateActivity,
                    R.string.str01, Toast.LENGTH_LONG).show()
        }
    }
}

