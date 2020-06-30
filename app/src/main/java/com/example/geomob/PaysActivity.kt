package com.example.geomob

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.util.Log
import android.view.View
import android.widget.*
import androidx.room.Room
import androidx.viewpager.widget.PagerAdapter
import com.example.project_tdm.SlideAdapter
import kotlinx.android.synthetic.main.activity_pays.*

class PaysActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pays)
        var button:Button = this.findViewById(R.id.btnHist)
        var listHi:ListView = this.findViewById(R.id.listHist)
        var button1:Button = findViewById(R.id.btnRess)
        var listRe:ListView = findViewById(R.id.listRess)
        var button2:Button = findViewById(R.id.btnPer)
        var listPe:ListView = findViewById(R.id.listPer)
        var button3:Button = findViewById(R.id.btnPlay)
        var video:VideoView = findViewById(R.id.videoView)
        var button4:Button = findViewById(R.id.btnVid)
        var player: MediaPlayer? = null
        val slide : ArrayList<Int> = intent.getIntegerArrayListExtra("slide")
        var imageList : Array<Int> = arrayOf(slide.get(0),slide.get(1),slide.get(2),slide.get(3))
        var adapter2: PagerAdapter = SlideAdapter(applicationContext, imageList)
        pager.adapter = adapter2

      //  var listview: ListView = findViewById<ListView>(R.id.listHist)
     //   var listview2: ListView = findViewById<ListView>(R.id.listRess)
        var list:MutableList<String> = mutableListOf<String>()

        val nom = intent.getStringExtra("paysNom") as String
        val des = intent.getStringExtra("paysDes") as String
        val drap = intent.getIntExtra("paysDrap", 0)
        val hymne = intent.getIntExtra("hymne", 0)
        val pop :String= intent.getStringExtra("paysPop")as String
        val sur :String = intent.getStringExtra("paysSur")as String
        val lisDate : ArrayList<String> = intent.getStringArrayListExtra("listHist")
        val lisRes : ArrayList<String> = intent.getStringArrayListExtra("listRess")
        val lisPer : ArrayList<String> = intent.getStringArrayListExtra("listPer")
        val videos : ArrayList<Int> = intent.getIntegerArrayListExtra("videos")

        var name: TextView = findViewById(R.id.name)
        var description: TextView = findViewById(R.id.description)
        var population: TextView = findViewById(R.id.population)
        var surface: TextView = findViewById(R.id.surface)
        var drapeau : ImageView =findViewById(R.id.drapeau)

        name.text=nom
        description.text =des
        population.text=pop.toString()
        surface.text=sur.toString()
        drapeau.setImageResource(drap)
/******************************************enyme***********************/
        button3.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                if(player == null){
                    player = MediaPlayer.create(this@PaysActivity , hymne)
                    player?.start()
                }
                else{
                    player!!.release()
                    player = null
                }

            }

        })

        /***************************video*************************/
        val filePlace = "android.resource://" + packageName + "/raw/"+ videos.get(0)
        val videoView = findViewById<View>(R.id.videoView) as VideoView
        videoView.setVideoURI(Uri.parse(filePlace))
        videoView.setMediaController(MediaController(this))
        videoView.start()
        /**************************wikipedia***************************/

   button.setOnClickListener(object : View.OnClickListener {
            var visible : Boolean = false
            override fun onClick(v: View?) {
                if(listHi.visibility===View.GONE){
               listHi.setVisibility(View.VISIBLE)
            }else{
           listHi.setVisibility(View.GONE)
       }
            }

        })
        button1.setOnClickListener(object : View.OnClickListener {
            var visible : Boolean = false
            override fun onClick(v: View?) {
                if(listRe.visibility===View.GONE){
                    listRe.setVisibility(View.VISIBLE)
                }else{
                    listRe.setVisibility(View.GONE)
                }
            }

        })
        button2.setOnClickListener(object : View.OnClickListener {
            var visible : Boolean = false
            override fun onClick(v: View?) {
                if(listPe.visibility===View.GONE){
                    listPe.setVisibility(View.VISIBLE)
                }else{
                    listPe.setVisibility(View.GONE)
                }
            }

        })
        button4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if(video.visibility===View.GONE){
                    video.setVisibility(View.VISIBLE)
                }else{
                    video.setVisibility(View.GONE)
                }
            }

        })
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,lisDate)
        listHi.setScrollContainer(false);
        listHi.adapter = adapter
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,lisRes)
        listRe.adapter = adapter
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,lisPer)
        listPe.adapter = adapter

    }
}
