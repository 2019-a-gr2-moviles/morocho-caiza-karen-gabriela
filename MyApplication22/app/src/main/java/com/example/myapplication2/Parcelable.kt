package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        val karen:Usuario? = this.intent.getParcelableExtra<Usuario>("usuario")
        Log.i("parcelable", "Nombre ${karen?.nombre}")
        Log.i("parcelable", "Nombre ${karen?.edad}")
        Log.i("parcelable", "Nombre ${karen?.fechaNacimiento.toString()}")
        Log.i("parcelable", "Nombre ${karen?.sueldo}")
    }

    fun regresarMenu(){
        val intentExplicito = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intentExplicito)
    }
}
