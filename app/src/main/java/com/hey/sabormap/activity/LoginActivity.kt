package com.hey.sabormap.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hey.sabormap.R
import com.hey.sabormap.databinding.ActivityLoginBinding
import com.hey.sabormap.db.People
import com.hey.sabormap.db.Users
import com.hey.sabormap.modelo.Moderator
import com.hey.sabormap.modelo.Person
import com.hey.sabormap.modelo.User
import java.lang.Exception

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()

        val sp = getSharedPreferences("sesion", Context.MODE_PRIVATE)

        val email = sp.getString("email_user", "")
        val tipo = sp.getString("tipo_user", "")

        if (email!!.isNotEmpty() && tipo!!.isNotEmpty()){

            when(tipo){
                "user" -> startActivity(Intent(this, MainActivity::class.java))
            }

        }else{
            binding = ActivityLoginBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.btnStarLogin.setOnClickListener { login() }
            binding.btnSingUpLogin.setOnClickListener { goRegister() }
        }




    }

    fun goRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivities(arrayOf(intent))
    }

    fun login() {
        val email = binding.emailUser.text.toString()
        val password = binding.passwordUser.text.toString()

        if (email.isEmpty()) {
            binding.emailLayout.error = getString(R.string.msg_error)
        } else {
            binding.emailLayout.error = null
        }

        if (password.isEmpty()) {
            binding.passwordLayout.error = getString(R.string.msg_error)
        } else {
            binding.passwordLayout.error = null
        }




        if (email.isNotEmpty() && password.isNotEmpty()) {

            try {
                val user = People.login(email, password)

                if (user != null) {

                    val tipo = if (user is User) "user" else if(user is Moderator) "moderator" else "null"

                    val sharedPreferences = this.getSharedPreferences("sesion", Context.MODE_PRIVATE).edit()
                    sharedPreferences.putString("email_user", user.email)
                    sharedPreferences.putString("tipo_user", tipo)

                    sharedPreferences.commit()

                    when (user) {
                        is User -> startActivity(Intent(this, MainActivity::class.java))
//                        is Moder -> startActivity(Intent(this, MainActivity::class.java))
                    }
                } else {
                    Toast.makeText(this, "Sus datos  son incorrectos", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Sus datos  son incorrectos", Toast.LENGTH_LONG).show()
            }


        }
    }
}