package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEntrar.setOnClickListener { ingresarUsuario() }
    }

    fun ingresarUsuario(){
        EquipoFutbol_BD.guardarUsuario(txtNombre.text.toString())
        val intentMenu = Intent(this, MenuActivity::class.java)
        intentMenu.putExtra("usuario", txtNombre.text.toString())
        startActivity(intentMenu)
    }
    override fun onBackPressed() {

        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

}