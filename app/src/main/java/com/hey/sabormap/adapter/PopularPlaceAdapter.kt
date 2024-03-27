package com.hey.sabormap.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.hey.sabormap.R
import com.hey.sabormap.activity.DetalleLugarActivity
import com.hey.sabormap.db.Categorys
import com.hey.sabormap.modelo.Place

class PopularPlaceAdapter(var list:ArrayList<Place>): RecyclerView.Adapter<PopularPlaceAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularPlaceAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_place_main, parent, false)
        return  ViewHolder(v)
    }

    override fun onBindViewHolder(holder: PopularPlaceAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(var itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener{

        val name:TextView = itemView.findViewById(R.id.name_place)
        val img:ImageView = itemView.findViewById(R.id.img_place)
        val ico:ImageView = itemView.findViewById(R.id.icon_place)
        val category:TextView = itemView.findViewById(R.id.category_place)
        var codePlace: Int=0

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(place: Place){
            name.text = place.name
            codePlace = place.id
            ico.setImageResource(Categorys.ontener(place.idCategory)!!.icon)
            category.text = Categorys.ontener(place.idCategory)!!.name

        }

        override fun onClick(v: View?) {
            val intent = Intent( name.context, DetalleLugarActivity::class.java)
            intent.putExtra("code", codePlace)
            name.context.startActivity(intent)
        }
    }

}