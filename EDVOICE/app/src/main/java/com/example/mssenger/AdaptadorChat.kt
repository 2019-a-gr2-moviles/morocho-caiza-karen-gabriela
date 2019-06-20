package com.example.mssenger

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout

import android.widget.TextView

class AdaptadorChat(private val listaChat:List<Chat>,
                    private val contexto:ChatActivity,
                    private val recyclerview: RecyclerView
): RecyclerView.Adapter<AdaptadorChat.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var text_a:TextView
        var text_b:TextView
        init{
            text_a = view.findViewById(R.id.text_a_chat) as TextView
            text_b = view.findViewById(R.id.text_b_chat) as TextView

            val layout = view.findViewById(R.id.layout_chat) as LinearLayout



        }

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorChat.MyViewHolder {

        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_chat,
                p0,
                false
            )

        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
       return listaChat.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorChat.MyViewHolder, position: Int) {
        val chat = listaChat[position]
        myViewHolder.text_a.text = chat.text_a
        myViewHolder.text_b.text = chat.text_b
        

    }
}






