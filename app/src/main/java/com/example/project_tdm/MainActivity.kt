package com.example.project_tdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var listePays : MutableList<Pays>
    var posi : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listePays = generateDummyList1(5) as MutableList<Pays>
        recycler_view.adapter = PaysAdapter(listePays)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
        var bnt = btn

        bnt.setOnClickListener(object:View.OnClickListener {
            override fun onClick(v: View) {
                Toast.makeText(this@MainActivity, "clicked", Toast.LENGTH_SHORT).show()
                open_Activity_Slider()
            }
        })

        (recycler_view.adapter as PaysAdapter).setOnItemClickListener(object : PaysAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity, "clicked", Toast.LENGTH_SHORT).show()
            }

            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }
        })
    }

    private fun generateDummyList1(size: Int): List<Pays> {

        val list = ArrayList<Pays>()


        for (i in 0 until size) {
            val item = Pays("Pays"+i, R.drawable.ic_android)
            list += item
            //backUp_Jsaon(i)
        }

        return list
    }

    fun open_Activity_Slider(){
        val intent = Intent(this, Activity_Slider::class.java )
        startActivity(intent)
    }
}
