package com.paes.josias.android_kotlin_storage_sqlite.models

/**
 * Created by Josias on 21/09/2017.
 */
data class Student(var id:Int, var nome:String) {
    override fun toString(): String {
        return "Id ${id}: ${nome}"
    }
}