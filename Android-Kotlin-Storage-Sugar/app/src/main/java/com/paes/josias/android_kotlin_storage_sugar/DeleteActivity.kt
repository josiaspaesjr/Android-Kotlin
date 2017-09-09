package com.paes.josias.android_kotlin_storage_sugar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.orm.SugarRecord
import com.paes.josias.android_kotlin_storage_sugar.orm.Books
import kotlinx.android.synthetic.main.activity_delete.*

class DeleteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)
    }

    fun delete(v: View){

        if(etTitle.text.toString().isNotEmpty()){
            val books:List<Books> = SugarRecord.find(
                    Books::class.java, "title = ?", etTitle.text.toString())

            for(book in books){
                book.delete()
            }
            Toast.makeText(this@DeleteActivity,
                    R.string.str03, Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this@DeleteActivity,
                    R.string.str01, Toast.LENGTH_LONG).show()
        }
    }
}

