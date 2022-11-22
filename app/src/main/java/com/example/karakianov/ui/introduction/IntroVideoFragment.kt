package com.example.karakianov.ui.introduction

import android.content.Context
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.karakianov.MainActivity
import com.example.karakianov.R
import com.example.karakianov.data.KarakiaData
import kotlinx.android.synthetic.main.fragment_description.view.*
import kotlinx.android.synthetic.main.fragment_video.view.*

class IntroVideoFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_introvideo, container, false)
        val videoLink = R.raw.introduction
        val video =  view.findViewById<VideoView>(R.id.video_introview)
        val uri = "android.resource://" + activity?.packageName + "/" + videoLink;
        video.setVideoURI(Uri.parse(uri))
        val mediaController = MediaController(this.context)
        video.setMediaController(mediaController)
        video.start()
        val myactivity = activity as MainActivity
        myactivity.directionLeft()
        return view
    }
}