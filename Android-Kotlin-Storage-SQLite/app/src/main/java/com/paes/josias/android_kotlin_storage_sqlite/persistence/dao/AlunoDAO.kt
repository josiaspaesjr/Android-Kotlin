package com.paes.josias.android_kotlin_storage_sqlite.persistence.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.paes.josias.android_kotlin_storage_sqlite.models.Aluno
import com.paes.josias.android_kotlin_storage_sqlite.persistence.DBConfig

/**
 * Created by Josias on 21/09/2017.
 */
class AlunoDAO (var context:Context) {

    var config:DBConfig = DBConfig(context,
            DBConfig.NOME_DB, null, DBConfig.DB_VER)

    var sliteWrite:SQLiteDatabase = config.writableDatabase;
    var sliteRead:SQLiteDatabase = config.readableDatabase;

    fun insertData(aluno:Aluno): Boolean{
        var cv:ContentValues = ContentValues()
        cv.put(DBConfig.COL_ALUNOS_NOME, aluno.nome)

        var result = sliteWrite.insert(DBConfig.TABELA_NOME, null, cv)

        return result > 0
    }

    fun readAll(): ArrayList<Aluno>{

        var alunos:ArrayList<Aluno> = ArrayList<Aluno>()

        var c: Cursor = sliteRead.rawQuery("SELECT * FROM "
                + DBConfig.TABELA_NOME, null)

        while (c.moveToNext()){
            var aluno:Aluno = Aluno(
                    c.getInt(0),
                    c.getString(1)
            )

            alunos.add(aluno)
        }

        return alunos
    }

    fun closeConn(){
        sliteWrite.close();
        sliteRead.close();
        config.close();
    }
}