package com.hey.sabormap.activity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.hey.sabormap.R
import com.hey.sabormap.databinding.ActivityCreateSiteBinding
import com.hey.sabormap.db.Categorys
import com.hey.sabormap.db.Citys
import com.hey.sabormap.db.Places
import com.hey.sabormap.modelo.Category
import com.hey.sabormap.modelo.City
import com.hey.sabormap.modelo.Place
import com.hey.sabormap.modelo.StatePlace

class CreateSiteActivity : AppCompatActivity() {
    lateinit var binding:ActivityCreateSiteBinding
    var posCity:Int = -1
    var posCategori:Int = -1
    lateinit var citys:ArrayList<City>
    lateinit var categorys:ArrayList<Category>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityCreateSiteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        citys = Citys.listar()
        categorys = Categorys.listar()

        cargarCiudades()
        cargarCategorias()

        binding.btnRegisterSite.setOnClickListener { crearNuevoLugar() }

    }

    fun cargarCiudades(){
        var lista = citys.map { c -> c.name }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.citySite.adapter = adapter

        binding.citySite.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                posCity = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) { }
        }
    }

    fun cargarCategorias(){
        var lista = categorys.map {c -> c.name}
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.categorySite.adapter = adapter

        binding.categorySite.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                posCategori = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) { }
        }
    }


    fun crearNuevoLugar(){

        val nombre = binding.nameSite.text.toString()
        val descripcion = binding.descriptionSite.text.toString()
        val telefono = binding.phoneSite.text.toString()
        val direccion = binding.direccionLugar.text.toString()
        val idCiudad = citys[posCity].id
        val idCategoria = categorys[posCategori].id

        if( nombre.isEmpty() ){
            binding.nameSiteLayout.error = getString(R.string.msg_error)
        }else{
            binding.nameSiteLayout.error = null
        }

        if( descripcion.isEmpty() ){
            binding.descriptionSiteLayout.error = getString(R.string.msg_error)
        }else{
            binding.descriptionSiteLayout.error = null
        }

        if( direccion.isEmpty() ){
            binding.direccionLayout.error = getString(R.string.msg_error)
        }else{
            binding.direccionLayout.error = null
        }

        if( telefono.isEmpty() ){
            binding.phoneLayout.error = getString(R.string.msg_error)
        }else{
            binding.phoneLayout.error = null
        }

        if(nombre.isNotEmpty() && descripcion.isNotEmpty() && telefono.isNotEmpty() && direccion.isNotEmpty() && idCiudad != -1 && idCategoria != -1)  {

            val nuevoLugar = Place(7, nombre, descripcion, 1, StatePlace.SIN_REVISAR, idCategoria, direccion, 0f, 0f, idCiudad)

            val telefonos: ArrayList<String> = ArrayList()
            telefonos.add(telefono)

            nuevoLugar.phone = telefonos

            Places.crear(nuevoLugar)

        }

    }
}