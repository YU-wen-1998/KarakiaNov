package com.example.karakianov.ui.wintecmaria
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.karakianov.R


class MaoriCultureFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_maoriculture, container, false)
        val videoView = view.findViewById<VideoView>(R.id.video_view)
        val videoPath = "android.resource://" + activity?.packageName + "/" + R.raw.maoriculture
        val uri = Uri.parse(videoPath)
        videoView.setVideoURI(uri)
        videoView.start()

        val mediaController = MediaController(this.context)
        videoView.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)
        return view
    }

}