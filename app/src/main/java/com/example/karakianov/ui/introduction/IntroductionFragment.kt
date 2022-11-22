package com.example.karakianov.ui.introduction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.karakianov.MainActivity
import com.example.karakianov.R
import kotlinx.android.synthetic.main.fragment_description.view.*
import kotlinx.android.synthetic.main.fragment_introduction.*
import kotlinx.android.synthetic.main.fragment_introvideo.*

// TODO: Rename parameter arguments, choose names that match
class IntroductionFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_introduction, container, false)
        val videoImage = view.findViewById<ImageView>(R.id.video_introimage)
        videoImage.setImageResource(R.drawable.wintecintro)

        view.playBtn.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_fragment_introduction_to_introVideoFragment)
        }

//        val content = view.findViewById<TextView>(R.id.introduction)
//        content.text = "234456677899055"

        val myactivity = activity as MainActivity
        myactivity.directionRight()

        return view
    }
}