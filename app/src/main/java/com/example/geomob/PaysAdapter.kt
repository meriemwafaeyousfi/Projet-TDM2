package com.example.geomob

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.geomob.R
import kotlinx.android.synthetic.main.example_line.view.*

class PaysAdapter (val context : Context, private var listePays: List<Pays>): RecyclerView.Adapter <PaysAdapter.ExampleViewHolder>() {

    var mListener: OnItemClickListener? = null

    interface OnItemClickListener : AdapterView.OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    inner class ExampleViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.img_drapeau
        val textView : TextView = itemView.nom_pays
        var currentPays:   Pays ? = null
        var currentPos : Int =0
        var db = Room.databaseBuilder(context, AppDB::class.java, "NoteDB").build()
        init {
            itemView.setOnClickListener(object : View.OnClickListener {
                val intent = Intent(context, PaysActivity()::class.java)
                override fun onClick(v : View?) {
                    intent.putExtra("paysNom",currentPays!!.nom)
                    intent.putExtra("paysDes",currentPays!!.description)
                    intent.putExtra("paysDrap",currentPays!!.drapeau)
                    intent.putExtra("paysPop",currentPays!!.population)
                    intent.putExtra("paysSur",currentPays!!.surface)
                    intent.putExtra("listHist",currentPays!!.listHis)
                    intent.putExtra("listRess",currentPays!!.listRess)
                    intent.putExtra("listPer",currentPays!!.listPer)
                    intent.putExtra("slide",currentPays!!.slide)
                    intent.putExtra("hymne",currentPays!!.hymne)
                    intent.putExtra("videos",currentPays!!.videos)
                    context.startActivity(intent)


                }
            })
        }
        fun setData(pays :Pays?, pos : Int){
           /* itemView.title.text= note!!.title
            itemView.date.text=note!!.date
            itemView.setBackgroundColor(note!!.color)*/
            this.currentPays= pays
            this.currentPos = pos
            itemView.nom_pays.text=currentPays!!.nom
            itemView.img_drapeau.setImageResource(currentPays!!.drapeau)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.example_line,
            parent, false)



        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentitem = listePays[position]
        holder.setData(currentitem,position)
       /* holder.imageView.setImageResource(currentitem.drapeau)
        holder.textView.text = currentitem.nom
*/
    }

    override fun getItemCount() = listePays.size

}

