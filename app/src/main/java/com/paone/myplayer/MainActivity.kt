package com.paone.myplayer

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nextActivity()

    }
    fun nextActivity() {
        Handler().postDelayed(Runnable {
            val mainIntent = Intent(this@MainActivity, PlayerActivity::class.java)
            this@MainActivity.startActivity(mainIntent)
            finish()
        }, 5000)
    }
}