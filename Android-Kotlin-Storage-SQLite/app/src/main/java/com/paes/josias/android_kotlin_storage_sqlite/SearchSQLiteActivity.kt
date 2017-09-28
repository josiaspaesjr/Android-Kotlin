package com.paes.josias.android_kotlin_storage_sqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.paes.josias.android_kotlin_storage_sqlite.models.Student
import com.paes.josias.android_kotlin_storage_sqlite.persistence.dao.AlunoDAO
import kotlinx.android.synthetic.main.activity_insert_sqlite.*
import kotlinx.android.synthetic.main.activity_search_sqlite.*
import java.lang.StringBuilder

class SearchSQLiteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_sqlite)
    }

    fun readAll(v: View){

        var dao: AlunoDAO = AlunoDAO(this@SearchSQLiteActivity);

        var students:ArrayList<Student> = dao.readAll()

        var strStudents:StringBuilder = StringBuilder()

        students.forEach {
            strStudents.append(it.toString() + "\n")
            //Toast.makeText(this@SearchSQLiteActivity, it.toString(), Toast.LENGTH_LONG).show();
        }

        tvResult.text = strStudents.toString()
    }

    fun searchByName(v: View){

        var dao: AlunoDAO = AlunoDAO(this@SearchSQLiteActivity);

        var name = etSName.text.toString()

        if(!name.equals("")){
            var students:ArrayList<Student> = dao.searchByName(name)

            var strStudents:StringBuilder = StringBuilder()

            students.forEach {
                strStudents.append(it.toString() + "\n")
                //Toast.makeText(this@SearchSQLiteActivity, it.toString(), Toast.LENGTH_LONG).show();
            }

            tvResult.text = strStudents.toString()
        }else{
            Toast.makeText(this@SearchSQLiteActivity, "Do you need tip a name!", Toast.LENGTH_LONG).show();
        }


    }

}
