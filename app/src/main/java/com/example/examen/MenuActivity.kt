package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.examen.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    var usuario :String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        usuario = intent.getStringExtra("usuario").toString()
        btnEquipo.setOnClickListener {gestionarEquipo() }
        btnCrearEquipo.setOnClickListener{ crearEquipo()}
    }

    fun gestionarEquipo(){
        val intentGestionarEquipo = Intent(this, ConsultarActivity::class.java)
        intentGestionarEquipo.putExtra("usuario", usuario)
        startActivity(intentGestionarEquipo)
    }

    fun crearEquipo(){
        val intentCrearEquipo = Intent(this, IngresarActivity::class.java)
        intentCrearEquipo.putExtra("usuario", usuario)
        startActivity(intentCrearEquipo)
    }
    override fun onBackPressed() {
        val intentMenu = Intent(this, MainActivity::class.java)

        startActivity(intentMenu)
    }

}