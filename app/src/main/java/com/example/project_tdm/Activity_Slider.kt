package com.example.project_tdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.activity__slider.*

class Activity_Slider : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__slider)
        var imageList : Array<Int> = arrayOf(R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.anya)
        var adapter: PagerAdapter = SlideAdapter(applicationContext, imageList)
        pager.adapter = adapter
    }
}
