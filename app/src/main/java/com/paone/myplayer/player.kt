package com.paone.myplayer

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class player : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player2)

//        val cover_player = findViewById<ImageView>(R.id.cover_player)

        val pause_btn = findViewById<ImageButton>(R.id.pause_player)
        val mediaPlayer = MediaPlayer.create(this@player,resources.getIdentifier(intent.getStringExtra("title")?.decapitalize(),"raw",packageName))
        mediaPlayer.start()

        pause_btn.setOnClickListener{
            mediaPlayer.stop()
            startActivity(Intent(this@player,PlayerActivity::class.java))
        }
        mediaPlayer.setOnCompletionListener {
            startActivity(Intent(this@player,PlayerActivity::class.java))
        }
    }
}