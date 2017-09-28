package com.paes.josias.android_kotlin_storage_sqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.paes.josias.android_kotlin_storage_sqlite.persistence.dao.AlunoDAO
import kotlinx.android.synthetic.main.activity_delete_sqlite.*
import kotlinx.android.synthetic.main.activity_update_sqlite.*

class DeleteSQLiteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_sqlite)
    }

    fun deleteStudent(v: View){
        var dao: AlunoDAO = AlunoDAO(this@DeleteSQLiteActivity);

        var id = etDelId.text.toString()
        if(!id.equals("")){
            dao.deleteStudent(id.toInt())
            Toast.makeText(this@DeleteSQLiteActivity, "OK", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this@DeleteSQLiteActivity, "The field id is empty", Toast.LENGTH_SHORT).show()
        }
    }
}
