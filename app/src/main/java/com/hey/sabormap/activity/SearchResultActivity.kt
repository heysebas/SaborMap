package com.hey.sabormap.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.hey.sabormap.adapter.PlaceAdapter
import com.hey.sabormap.databinding.ActivitySearchResultBinding
import com.hey.sabormap.db.Places
import com.hey.sabormap.modelo.Place

class SearchResultActivity : AppCompatActivity() {

    lateinit var binding: ActivitySearchResultBinding
    var textSearch: String = ""
    lateinit var listPlace: ArrayList<Place>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textSearch = intent.extras!!.getString("textSearch", "")
        listPlace = ArrayList()

        if (textSearch.isNotEmpty()) {
            listPlace = Places.buscarNombre(textSearch)
        }
        val adapter = PlaceAdapter(listPlace)
        binding.listPlace.adapter = adapter
        binding.listPlace.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}