package com.paes.josias.android_kotlin_storage_sqlite.persistence.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.paes.josias.android_kotlin_storage_sqlite.models.Student
import com.paes.josias.android_kotlin_storage_sqlite.persistence.DBConfig

/**
 * Created by Josias on 21/09/2017.
 */
class AlunoDAO (var context:Context) {

    var config:DBConfig = DBConfig(context,
            DBConfig.NOME_DB, null, DBConfig.DB_VER)

    var sliteWrite:SQLiteDatabase = config.writableDatabase;
    var sliteRead:SQLiteDatabase = config.readableDatabase;

    fun insertData(student: Student): Boolean{
        var cv:ContentValues = ContentValues()
        cv.put(DBConfig.COL_ALUNOS_NOME, student.nome)

        var result = sliteWrite.insert(DBConfig.TABELA_NOME, null, cv)

        return result > 0
    }

    fun readAll(): ArrayList<Student>{

        var students:ArrayList<Student> = ArrayList<Student>()

        var c: Cursor = sliteRead.rawQuery("SELECT * FROM "
                + DBConfig.TABELA_NOME, null)

        while (c.moveToNext()){
            var student: Student = Student(
                    c.getInt(0),
                    c.getString(1)
            )

            students.add(student)
        }

        return students
    }

    fun searchByName(name:String): ArrayList<Student>{

        var students:ArrayList<Student> = ArrayList<Student>()

        var c: Cursor =
            sliteRead.rawQuery( " SELECT * FROM " + DBConfig.TABELA_NOME +
                                " WHERE " + DBConfig.COL_ALUNOS_NOME + " LIKE '%" + name + "%'"
                                , null)

        while (c.moveToNext()){
            var student: Student = Student(
                    c.getInt(0),
                    c.getString(1)
            )

            students.add(student)
        }

        return students
    }

    fun updateStudent(id:Int, newName:String){
        sliteWrite.execSQL( " UPDATE " + DBConfig.TABELA_NOME +
                " SET " + DBConfig.COL_ALUNOS_NOME + " = '" + newName + "' " +
                " WHERE " + DBConfig.COL_ALUNOS_ID + " = " + id
        )
    }

    fun deleteStudent(id:Int){
        sliteWrite.execSQL( " DELETE FROM " + DBConfig.TABELA_NOME +
                " WHERE " + DBConfig.COL_ALUNOS_ID + " = " + id
        )
    }

    fun closeConn(){
        sliteWrite.close();
        sliteRead.close();
        config.close();
    }
}