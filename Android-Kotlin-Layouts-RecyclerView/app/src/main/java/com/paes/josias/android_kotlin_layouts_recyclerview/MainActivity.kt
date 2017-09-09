package com.paes.josias.android_kotlin_layouts_recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.paes.josias.android_kotlin_layouts_recyclerview.models.Evento
import kotlinx.android.synthetic.main.activity_main.*
import tech.ludy.proludymobilemvp.presenters.main.adapters.MyAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvEventos.setHasFixedSize(true)
        rvEventos.layoutManager = LinearLayoutManager(this)

        val eventos:ArrayList<Evento> = ArrayList<Evento>()
        for(i in 0..100){
            eventos.add(Evento("Event ${i}",
                    "Event ${i} about XYZ${i}",
                    "Location: ${i}", "Hour: ${i}"))
        }

        val mAdapter: RecyclerView.Adapter<*> = MyAdapter(this@MainActivity, eventos){
            Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_SHORT).show()
        }
        rvEventos.adapter = mAdapter

    }
}

