package com.paone.myplayer

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class RAdapter(var context:Context,var data:ArrayList<Song>):
    RecyclerView.Adapter<RAdapter.ViewHolder>() {
    init{
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.song,parent,false)
        return  ViewHolder((layout))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cover.setImageResource(data[position].cover!!)
        holder.title.text = data[position].title
        holder.card.setOnClickListener {

//            val alert = Dialog(context)
//            alert.setContentView(R.layout.player)
//            alert.window?.setType(WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG)
//            val cover_player = alert.findViewById<ImageView>(R.id.cover_player)
//            val pause_btn = alert.findViewById<ImageButton>(R.id.pause_player)

//            cover_player.setImageResource(data[position].cover!!)
//            alert.show()

//            pause_btn.setOnClickListener {
//                alert.dismiss()
//            }
            var myIntent = Intent(context,player::class.java)
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            myIntent.putExtra("title",data[position].title.toString())
            startActivity(context,myIntent,null)

        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        var title:TextView
        var cover:ImageView
        var card:CardView
        init {
            title = itemView.findViewById(R.id.title_song)
            cover = itemView.findViewById(R.id.cover_art)
            card = itemView.findViewById(R.id.song_card)
        }
    }
}