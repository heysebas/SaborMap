package com.hey.sabormap.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.hey.sabormap.adapter.PlaceAdapter
import com.hey.sabormap.adapter.PopularPlaceAdapter
import com.hey.sabormap.databinding.ActivityMainBinding
import com.hey.sabormap.db.Places
import com.hey.sabormap.modelo.Place
import com.hey.sabormap.modelo.StatePlace


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var listFolkPlace: ArrayList<Place>
    var textSearch: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listFolkPlace = ArrayList()
        var textSearch: String = "ACEPTADO"


        if (textSearch.isNotEmpty()) {
            // Asumiendo que 'Places.listarPorEstado' devuelve una lista
            listFolkPlace = Places.listarPorEstado(StatePlace.ACEPTADO)

            // Si la lista tiene más de 10 elementos, recortamos la lista para quedarnos solo con los primeros 10
            if (listFolkPlace.size > 10) {
                listFolkPlace = ArrayList(listFolkPlace.take(10))

            }
        }

        val adapter = PopularPlaceAdapter(listFolkPlace)
        binding.listFolkPlace.adapter = adapter
        binding.listFolkPlace.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.listFolkPlace2.adapter = adapter
        binding.listFolkPlace2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.listFolkPlace3.adapter = adapter
        binding.listFolkPlace3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)




        binding.textSearch.setOnEditorActionListener { textView, i, keyEvent ->
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                val text = binding.textSearch.text.toString()

                if (text.isNotEmpty()) {
                    val intent = Intent(baseContext, SearchResultActivity::class.java)
                    intent.putExtra("textSearch", text)
                    startActivity(intent)
                }
            }
            true
        }


    }


    fun goLogin(v: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivities(arrayOf(intent))
//        val intent = Intent(this, CreateSiteActivity::class.java)
//        startActivities(arrayOf(intent))
    }

    fun goCreateSite(v: View) {
        val intent = Intent(this, CreateSiteActivity::class.java)
        startActivities(arrayOf(intent))
    }
}