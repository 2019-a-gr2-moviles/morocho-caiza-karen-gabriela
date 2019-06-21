package com.example.mssenger

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listaMensajes = arrayListOf<Mensajeria>()

        listaMensajes.add(Mensajeria("Alicia Jaramillo","8:30 am",1))
        listaMensajes.add(Mensajeria("Ana Salazar","8:30 am",2))
        listaMensajes.add(Mensajeria("Elvira Muñoz","8:30 am",9))
        listaMensajes.add(Mensajeria("Ivonne Caiza","8:30 am",4))
        listaMensajes.add(Mensajeria("Geraldine Zavala","8:31 am",5))
        listaMensajes.add(Mensajeria("Luz Álvarez","9:30 am",6))
        listaMensajes.add(Mensajeria("Margarita Torres","8:30 am",7))
        listaMensajes.add(Mensajeria("Richard Bustamante","10:30 am",8))
        listaMensajes.add(Mensajeria("Enrique Pérez","8:30 am",3))
        listaMensajes.add(Mensajeria("Susana Molina","10:30 am",10))
        listaMensajes.add(Mensajeria("Teresa Pinos","10:30 am",11))

        iniciarRecylerView(listaMensajes,this,recycler_view_mensajes)



    }



    fun iniciarRecylerView(
        lista: List<Mensajeria>,
        actividad: MainActivity,
        recycler_view: RecyclerView
    ) {
        val adaptadorMensaje = AdaptadorMensaje(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorMensaje
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorMensaje.notifyDataSetChanged()
    }


    fun irAChatAcivity(mensaje: Mensajeria){
        val intentExplicito = Intent(
            this,
            ChatActivity::class.java
        )


        intentExplicito.putExtra("mensaje",mensaje)
        startActivity(intentExplicito)


    }


}
