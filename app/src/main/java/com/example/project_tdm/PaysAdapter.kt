package com.example.project_tdm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_line.view.*

class PaysAdapter (private var listePays: List<Pays>): RecyclerView.Adapter <PaysAdapter.ExampleViewHolder>() {

    var mListener: OnItemClickListener? = null

    interface OnItemClickListener : AdapterView.OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    class ExampleViewHolder (itemView: View, listener : OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.img_drapeau
        val textView : TextView = itemView.nom_pays
        init {
            itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v : View?) {
                    if (listener != null) {
                        var position = getAdapterPosition()
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position)
                        }
                    }
                }
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_line,
            parent, false)

        return ExampleViewHolder(itemView, mListener!!)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentitem = listePays[position]

        holder.imageView.setImageResource(currentitem.drapeau)
        holder.textView.text = currentitem.nom

    }

    override fun getItemCount() = listePays.size

}

