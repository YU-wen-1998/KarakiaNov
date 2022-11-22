package com.example.karakianov.ui.karakia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.karakianov.MainActivity
import com.example.karakianov.R
import kotlinx.android.synthetic.main.fragment_description.*
import kotlinx.android.synthetic.main.fragment_description.view.*

class DescriptionFragment :Fragment (){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_description, container, false)
        val id = arguments?.getInt("id")
        val name = arguments?.getString("prayName").toString()
        val description = arguments?.getString("prayDesc").toString()
        val imageURL = arguments?.getInt("imageUrl")
        val forEnglish = arguments?.getString("forEnglish").toString()
        val forMaori = arguments?.getString("forMaori").toString()

        (activity as AppCompatActivity).supportActionBar?.title = name

        val videoImage = view.findViewById<ImageView>(R.id.video_image)
        if (imageURL != null){
            videoImage.setImageResource(imageURL)
        };

        val content = view.findViewById<TextView>(R.id.description)
        content.text = description

        view.playBtn.setOnClickListener(){
            val bundle = bundleOf(
                "id" to id,
                "prayName" to name,
                "prayDesc" to description,
                "forEnglish" to forEnglish,
                "forMaori" to forMaori)
            Navigation.findNavController(view).navigate(R.id.action_descriptionFragment_to_videoFragment, bundle)
        }
        val myactivity = activity as MainActivity
        myactivity.directionLeft()

        return view
    }
}