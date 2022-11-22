package com.example.karakianov.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.karakianov.R
import com.example.karakianov.data.KarakiaData
import kotlinx.android.synthetic.main.each_item.view.*

class KarakiaAdapter(val karakiList: ArrayList<KarakiaData>):
    RecyclerView.Adapter<KarakiaAdapter.KarakiaViewHolder>() {

    inner class KarakiaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.imageview
        val textView1: TextView = itemView.textview
        val textView2: TextView = itemView.description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KarakiaViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return KarakiaViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: KarakiaViewHolder, position: Int) {
        val currentItem = karakiList[position]
        holder.imageView.setImageResource(currentItem.imageUrl)
        holder.textView1.text = currentItem.name
        holder.textView2.text = currentItem.description
        holder.itemView.setOnClickListener ( object : View.OnClickListener {
            override fun onClick(v: View?) {
                val bundle = bundleOf(
                    "id" to currentItem.id,
                    "imageUrl" to currentItem.imageUrl,
                    "prayName" to currentItem.name,
                    "prayDesc" to currentItem.description,
                    "forEnglish" to currentItem.forEnglish,
                    "forMaori" to currentItem.forMaori)
                Navigation.findNavController(holder.itemView)
                    .navigate(R.id.action_homeFragment_to_descriptionFragment, bundle)
            }

        })
    }
    override fun getItemCount(): Int {
        return karakiList.size
    }

}