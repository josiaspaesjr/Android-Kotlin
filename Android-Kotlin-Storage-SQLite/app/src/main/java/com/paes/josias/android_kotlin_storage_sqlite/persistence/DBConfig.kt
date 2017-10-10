package com.paes.josias.android_kotlin_storage_sqlite.persistence

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by Josias on 14/09/2017.
 */
class DBConfig (var context: Context,
                var name:String,
                var cursor:SQLiteDatabase.CursorFactory?,
                var version:Int) : SQLiteOpenHelper(context,name, cursor, version) {

    companion object {
        val DB_VER = 1
        val NOME_DB = "AlunoBD"
        val TABELA_NOME = "Alunos"
        val COL_ALUNOS_ID = "Id"
        val COL_ALUNOS_NOME = "Nome"
    }

    private val CREATE_TABLE_ALUNOS =
                    " CREATE TABLE " + TABELA_NOME + " ( " +
                    COL_ALUNOS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    COL_ALUNOS_NOME + " TEXT )";

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_ALUNOS)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //UPDATE IF WHAT YOU APP NEEDS
        db.execSQL("DROP TABLE IF EXIST " + TABELA_NOME + ";");
        onCreate(db);
    }
}


