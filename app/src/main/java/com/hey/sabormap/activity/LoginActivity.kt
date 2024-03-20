package com.hey.sabormap.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hey.sabormap.R
import com.hey.sabormap.databinding.ActivityLoginBinding
import com.hey.sabormap.db.Users
import com.hey.sabormap.modelo.User
import java.lang.Exception

class LoginActivity : AppCompatActivity() {

    lateinit var  binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStarLogin.setOnClickListener{login()}

    }

    fun login(){
        val email = binding.emailUser.text.toString()
        val password = binding.passwordUser.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()){

            try {
                val user = Users.login(email, password)
                Toast.makeText(this, "Sus datos son correctos", Toast.LENGTH_LONG).show()
            }catch (e:Exception){
                Toast.makeText(this, "Sus datos  son incorrectos", Toast.LENGTH_LONG).show()
            }


        }else{
            Toast.makeText(this, "El campo esta vacio", Toast.LENGTH_LONG).show()
        }
    }
}