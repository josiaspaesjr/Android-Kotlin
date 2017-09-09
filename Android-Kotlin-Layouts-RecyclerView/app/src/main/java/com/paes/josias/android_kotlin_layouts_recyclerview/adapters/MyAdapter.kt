package tech.ludy.proludymobilemvp.presenters.main.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.paes.josias.android_kotlin_layouts_recyclerview.R
import com.paes.josias.android_kotlin_layouts_recyclerview.models.Evento
import kotlinx.android.synthetic.main.itemlist_eventos.view.*

import java.util.ArrayList

/**
 * Created by nti on 24/08/2016.
 */
class MyAdapter constructor(val context: Context, private val eventos: ArrayList<Evento>?,
                            val clickListener:(Evento)->Unit) :
        RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.itemlist_eventos, parent, false)
        val vh = ViewHolder(v)
        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        eventos?.let{
            var evento = eventos[position]
            holder.itemView.tvNome.text = evento.nome
            holder.itemView.tvDesc.text = evento.desc
            holder.itemView.tvLocal.text = evento.local
            holder.itemView.tvHorario.text = evento.horario
            holder.itemView.setOnClickListener { clickListener(eventos[position]) }
        }
    }

    override fun getItemCount(): Int {
        if (eventos != null) {
            return eventos.size
        }else
            return 0
    }
}

