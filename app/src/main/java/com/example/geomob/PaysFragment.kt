package com.example.geomob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class PaysFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.activity_pays_fragment, container, false)

        // var a = args?.getString("titre","title")
        if (arguments != null){
          /*  var livre:Model = arguments?.getSerializable("livre") as Model
            var txt: TextView = view.findViewById(R.id.title2)
            var dis: TextView = view.findViewById(R.id.discription2)
            var img: ImageView = view.findViewById(R.id.image2)
            txt.text="Le titre de livre : " + livre.title
            dis.text="La discription de livre : \n" + livre.description
            img.setImageResource(livre.img)
            //txt.text=title
*/
        }
        return view
    }


}
