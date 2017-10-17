package com.paes.josias.android_kotlin_gson

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import com.paes.josias.android_kotlin_gson.models.Aluno
import com.paes.josias.android_kotlin_gson.models.Turma
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var strGen:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createJSON(v: View){

        val turma = Turma()

        for (x in 0..10){
            val aluno = Aluno("Aluno ${x}","j@j.com")
            turma.alunos.add(aluno)
        }

        var gson = Gson()
        strGen = gson.toJson(turma)

        tvResult.text = strGen
    }

    fun readJSON(v: View){

        var gson = Gson()
        var turma = gson.fromJson(strGen, Turma::class.java)

        var alunosStr = StringBuffer()
        turma.alunos.forEach {
            alunosStr.append("Nome: ${it.nome} Email:${it.email} \n")
        }

        tvResult.text = alunosStr.toString()

    }
}

