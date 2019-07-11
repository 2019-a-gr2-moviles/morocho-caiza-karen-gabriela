package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recicler_view.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)

        val lista = arrayListOf<Persona>()
        // val recycler_view = rv_personas
        // val actividad = this

        lista.add(Persona("Karen", "171819134"))
        lista.add(Persona("Gabriela", "0192839495"))
        lista.add(Persona("Estefanía", "2003938182"))

        iniciarRecylerView(lista, this, rv_personas)

    }

    fun iniciarRecylerView(
        lista: List<Persona>,
        actividad: ReciclerViewActivity,
        recycler_view: androidx.recyclerview.widget.RecyclerView
    ) {
        val adaptadorPersona = AdaptadorPersona(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorPersona
        recycler_view.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator() as RecyclerView.ItemAnimator?
        recycler_view.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)

        adaptadorPersona.notifyDataSetChanged()
    }

    fun cambiarNombreTextView(texto: String) {
        txv_titulo_rv.text = texto
    }
}
