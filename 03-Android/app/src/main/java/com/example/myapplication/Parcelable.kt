package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        val karen: Usuario? = this.intent
            .getParcelableExtra("usuario")

        val cachetes: Mascotas? = this.intent
            .getParcelableExtra<Mascotas>("mascotas")

        Log.i("parcelable","Nombre: ${karen?.nombre}")
        Log.i("parcelable","Edad: ${karen?.edad}")
        Log.i("parcelable","Fecha Nacimiento: ${karen?.fechaNacimiento.toString()}")
        Log.i("parcelable","Sueldo: ${karen?.sueldo}")

        Log.i("parcelable","Nombre Mascota: ${cachetes?.nombre}")
        Log.i("parcelable","Nombre Dueño: ${cachetes?.duenio?.nombre}")
    }
    fun regresarAMenu(){
        val intentExplicito = Intent(
            this,
            MainActivity::class.java
        )
    }
}
