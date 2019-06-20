package com.example.mssenger

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_principal.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listaMensajes = arrayListOf<Mensaje>()

        listaMensajes.add(Mensaje("Alicia Jaramillo","8:30 am",1))
        listaMensajes.add(Mensaje("Ana Salazar","8:30 am",2))
        listaMensajes.add(Mensaje("Elvira Muñoz","8:30 am",9))
        listaMensajes.add(Mensaje("Ivonne Caiza","8:30 am",4))
        listaMensajes.add(Mensaje("Geraldine Zavala","8:31 am",5))
        listaMensajes.add(Mensaje("Luz Álvarez","9:30 am",6))
        listaMensajes.add(Mensaje("Margarita Torres","8:30 am",7))
        listaMensajes.add(Mensaje("Richard Bustamante","10:30 am",8))
        listaMensajes.add(Mensaje("Enrique Pérez","8:30 am",3))
        listaMensajes.add(Mensaje("Susana Molina","10:30 am",10))
        listaMensajes.add(Mensaje("Teresa Pinos","10:30 am",11))

        iniciarRecylerView(listaMensajes,this,recycler_view_mensajes)

    btn_ingresar.setOnClickListener {
        irAMainActivity()
    }
    }

    fun iniciarRecylerView(
        lista: List<Mensaje>,
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


    fun irAChatAcivity(mensaje: Mensaje){
        val intentExplicito = Intent(
            this,
            ChatActivity::class.java
        )


        intentExplicito.putExtra("mensaje",mensaje)
        startActivity(intentExplicito)


    }

    fun irAMainActivity(){
        val intentExplicito = Intent(
            this, MainActivity::class.java
        )
        startActivity(intentExplicito)
    }

}
