package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recicler_view.*
import java.util.ArrayList

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)


        val lista = arrayListOf<Persona>()
        //var recycler_view = rv_personas
        //val actividad = this

        lista.add(Persona( "Karen", "1724449887"))
        lista.add(Persona( "Camila", "1710652171"))
        lista.add(Persona( "Fabricio", "0258496321"))

        //val adaptadorPersona = AdaptadorPersona(lista,actividad,recycler_view)

        //rv_personas.adapter = adaptadorPersona
        //rv_personas.itemAnimator = DefaultItemAnimator()
       // rv_personas.layoutManager = LinearLayoutManager(this)

        //adaptadorPersona.notifyDataSetChanged()

        iniciarRecylerView(lista, this, rv_personas)

    }

    fun iniciarRecylerView(
        lista: List<Persona>,
        actividad: ReciclerViewActivity,
        recycler_view: RecyclerView
    ) {
        val adaptadorPersona = AdaptadorPersona(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorPersona //nuevo adaptador para la nueva lista
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorPersona.notifyDataSetChanged()}

    fun cambiarNombreTextView(texto:String){
        txt_titulo_rv.text = texto
    }
}
