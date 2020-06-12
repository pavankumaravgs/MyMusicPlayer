package com.paone.myplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val songs = ArrayList<Song>()


        songs.add(Song(R.mipmap.cover_art,"Satte"))
        songs.add(Song(R.mipmap.cover_art2,"Jeevitham"))
        songs.add(Song(R.mipmap.cover_art3,"Thangamey"))
        songs.add(Song(R.mipmap.cover_art4,"Jeevitham"))
        songs.add(Song(R.mipmap.cover_art5,"Veedokkade"))
        songs.add(Song(R.mipmap.cover_art,"Venky_whistle"))
        songs.add(Song(R.mipmap.cover_art2,"Vip"))
        songs.add(Song(R.mipmap.cover_art3,"Ye_vipuga"))
        songs.add(Song(R.mipmap.cover_art4,"Satte"))
        songs.add(Song(R.mipmap.cover_art5,"Vip"))


        val recycler = findViewById<RecyclerView>(R.id.recycler_song)
        val adapter = RAdapter(applicationContext,songs)

        recycler.layoutManager =GridLayoutManager(applicationContext,3)
        recycler.adapter = adapter

    }
    var exit = false
    override fun onBackPressed(){
        if(exit){
            finish()
        }
        else{
            Toast.makeText(this, "Press Back again to Exit.",
                Toast.LENGTH_SHORT).show()
            exit=true
            Handler().postDelayed(Runnable {
                kotlin.run { exit=false }
            }, 3000)
        }
    }
}