package com.hey.sabormap.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hey.sabormap.R
import com.hey.sabormap.databinding.ActivityRegisterBinding
import com.hey.sabormap.db.Users
import com.hey.sabormap.modelo.User

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRegister.setOnClickListener { registerUser() }
    }

    fun registerUser() {
        val name = binding.nameUser.text.toString()
        val lastName = binding.lastNameUser.text.toString()
        val nickname = binding.nicknameUser.text.toString()
        val email = binding.emailUser.text.toString()
        val password = binding.passwordUser.text.toString()
        val passwordSeco = binding.passwordSecoUser.text.toString()

        if (name.isEmpty()) {
            binding.nameLayout.error = getString(R.string.msg_error)
        } else {
            binding.nameLayout.error = null
        }

        if (lastName.isEmpty()) {
            binding.lastNameLayout.error = getString(R.string.msg_error)
        } else {
            binding.lastNameLayout.error = null
        }

        if (nickname.isEmpty()) {
            binding.nicknameLayout.error = getString(R.string.msg_error)
        } else {
            if (nickname.length > 1){
                if (nickname.length < 16){
                    binding.nicknameLayout.error = null
                }else{
                    binding.nicknameLayout.error = "El nombre de usuarios es muy largo"
                    Toast.makeText(this, "El nombre de usuarios es muy largo", Toast.LENGTH_LONG).show()
                }
            }else{
                binding.nicknameLayout.error = "El nombre de usuarios es muy corto"
                Toast.makeText(this, "El nombre de usuarios es muy corto", Toast.LENGTH_LONG).show()
            }





        }

        if (email.isEmpty()) {
            binding.emailLayout.error = getString(R.string.msg_error)
        } else {
            binding.emailLayout.error = null
        }

        if (password.isEmpty()) {
            binding.passwordLayout.error = getString(R.string.msg_error)
        } else {
            if (password.length > 7){
                if (password.length < 16){
                    binding.passwordLayout.error = null
                }else{
                    binding.passwordLayout.error = "La contraseña es muy larga, debe ser menor de 16 caracteres"
                    Toast.makeText(this, "La contraseña es muy larga, debe ser menor de 16 caracteres", Toast.LENGTH_LONG).show()
                }
            }else{
                binding.passwordLayout.error = "La contraseña es muy corto debe ser mayor de 7 caracteres"
                Toast.makeText(this, "La contraseña es muy corto", Toast.LENGTH_LONG).show()
            }
        }

        if (passwordSeco.isEmpty()) {
            binding.passwordSecoLayout.error = getString(R.string.msg_error)
        } else {
            binding.passwordSecoLayout.error = null
        }

        if (name.isNotEmpty() && lastName.isNotEmpty() && nickname.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && passwordSeco.isNotEmpty()) {
            if (password == passwordSeco){
                val user = User(4,name,lastName,email,nickname,password)
                Users.agregar(user)
                Toast.makeText(this, "El usuario fue Registrado", Toast.LENGTH_LONG).show()
            }else{
                binding.passwordSecoLayout.error = "La Contraseña no son iguales"
                Toast.makeText(this, "La Contraseña no son iguales", Toast.LENGTH_LONG).show()
            }

        }


    }


}