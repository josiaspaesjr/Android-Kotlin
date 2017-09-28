package com.paes.josias.android_kotlin_storage_sqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.paes.josias.android_kotlin_storage_sqlite.models.Student
import com.paes.josias.android_kotlin_storage_sqlite.persistence.dao.AlunoDAO
import kotlinx.android.synthetic.main.activity_insert_sqlite.*

class InsertSQLiteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_sqlite)
    }

    fun saveStudent(v:View){

        var dao:AlunoDAO = AlunoDAO(this@InsertSQLiteActivity);

        var stdName = etName.text.toString()

        var std: Student = Student(0, stdName)

        if(dao.insertData(std)){
            Toast.makeText(this@InsertSQLiteActivity, "ALL RIGHT!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this@InsertSQLiteActivity, "OPSSS!", Toast.LENGTH_LONG).show();
        }
    }
}
