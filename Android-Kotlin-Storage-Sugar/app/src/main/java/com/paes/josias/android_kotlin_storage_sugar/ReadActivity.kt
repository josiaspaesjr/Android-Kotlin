package com.paes.josias.android_kotlin_storage_sugar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.orm.SugarRecord
import com.paes.josias.android_kotlin_storage_sugar.orm.Books
import kotlinx.android.synthetic.main.activity_read.*

class ReadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)

        val books:List<Books> = SugarRecord.listAll(Books::class.java)
        val records:StringBuffer = StringBuffer()

        for(book in books){
            records.append("${book.title} - ${book.author}\n-------------\n")
        }

        tvRecords.text = records
    }
}




