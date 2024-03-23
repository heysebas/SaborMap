package com.hey.sabormap.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.hey.sabormap.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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