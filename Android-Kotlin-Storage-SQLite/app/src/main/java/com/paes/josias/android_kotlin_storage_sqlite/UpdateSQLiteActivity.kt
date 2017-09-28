package com.paes.josias.android_kotlin_storage_sqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.paes.josias.android_kotlin_storage_sqlite.persistence.dao.AlunoDAO
import kotlinx.android.synthetic.main.activity_update_sqlite.*

class UpdateSQLiteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_sqlite)
    }

    fun updateStudent(v: View){
        var dao: AlunoDAO = AlunoDAO(this@UpdateSQLiteActivity);

        var id = etUpdId.text.toString()
        var name = etUpdName.text.toString()

        if(!id.equals("") && !name.equals("")){
            var result = dao.updateStudent(id.toInt(),name)
            Toast.makeText(this@UpdateSQLiteActivity, "OK", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this@UpdateSQLiteActivity, "Some field is empty", Toast.LENGTH_SHORT).show()
        }
    }

}
