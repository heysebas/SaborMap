package com.hey.sabormap.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hey.sabormap.R
import com.hey.sabormap.databinding.ActivityDetalleLugarBinding
import com.hey.sabormap.db.Categorys
import com.hey.sabormap.db.Places

class DetalleLugarActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetalleLugarBinding
    var codePlace: Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalleLugarBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_detalle_lugar)

        codePlace = intent.extras!!.getInt("code")

        val place = Places.obtener(codePlace)

        Toast.makeText(this, "${place.toString()}", Toast.LENGTH_LONG).show()

        if(place != null){
            binding.namePlace.text = place!!.name
            binding.categorySite.text = Categorys.ontener(place!!.idCategory)!!.name
            "binding.categorySite.text = Categorys.ontener(place!!.idCategory)!!.icon"
//            binding.descripcionLugar.text = lugar!!.descripcion
//            binding.telefonoLugar.text = lugar!!.telefonos.toString()
//            binding.direccionLugar.text = lugar!!.direccion
//            binding.iconoCategoria.text = Categorias.obtener(lugar!!.idCategoria)!!.icono
        }


    }
}