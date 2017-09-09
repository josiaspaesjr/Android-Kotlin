package com.paes.josias.android_kotlin_storage_sugar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.orm.SugarRecord
import com.paes.josias.android_kotlin_storage_sugar.orm.Books
import kotlinx.android.synthetic.main.activity_careful_read.*

class CarefulReadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_careful_read)
    }

    fun search(v: View){

        if(etTitle.text.toString().isNotEmpty()){

            val books:List<Books> = SugarRecord.findWithQuery(
                    Books::class.java,
                    "SELECT * FROM Books WHERE title LIKE '%${etTitle.text.toString()}%'");

            val records:StringBuffer = StringBuffer()

            for(book in books){
                records.append("${book.title} - ${book.author}\n-------------\n")
            }

            tvRecords.text = records
        }else{
            Toast.makeText(this@CarefulReadActivity,
                    R.string.str01, Toast.LENGTH_LONG).show()
        }
    }
}

