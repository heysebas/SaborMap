package com.hey.sabormap.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hey.sabormap.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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