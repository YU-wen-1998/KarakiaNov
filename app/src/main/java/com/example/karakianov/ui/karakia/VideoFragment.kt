package com.example.karakianov.ui.karakia

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.karakianov.MainActivity
import com.example.karakianov.R
import com.example.karakianov.data.KarakiaData
import kotlinx.android.synthetic.main.fragment_video.*
import kotlinx.android.synthetic.main.fragment_video.view.*

class VideoFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_video, container, false)
        val id = arguments?.getInt("id")
        val name = arguments?.getString("prayName").toString()
//        val description = arguments?.getString("prayDesc").toString()
//        val imageURL = arguments?.getInt("imageURL")
        val forEnglish = arguments?.getString("forEnglish").toString()
        val forMaori = arguments?.getString("forMaori").toString()
        //Fragment name change
        (activity as AppCompatActivity).supportActionBar?.title = name

        val videoLink = if (id == 1) {
            R.raw.opening1
        }else if (id == 2){
            R.raw.opening2
        } else if (id == 3){
            R.raw.blessingforfood
        }else if (id == 4){
            R.raw.closing1
        } else {
            R.raw.closing2
        }

        val video =  view.findViewById<VideoView>(R.id.video_view)
        val uri = "android.resource://" + activity?.packageName + "/" + videoLink;
        video.setVideoURI(Uri.parse(uri))
        val mediaController = MediaController(this.context)
        video.setMediaController(mediaController)
        video.start()
        val karakiStringList = ArrayList<KarakiaData>()
        karakiStringList.add(
            KarakiaData(
                1,
                name,
                "",
                0,
                forEnglish,
                forMaori,
                videoLink
            )
        )
        val content = view.findViewById<TextView>(R.id.videoLyrics)
        content.text = forMaori

        view.englishBtn.setOnClickListener(){
            content.text = forEnglish
        }
        view.maoriBtn.setOnClickListener(){
            content.text = forMaori
        }

        val myactivity = activity as MainActivity
        myactivity.directionLeft()

        return view
    }
}