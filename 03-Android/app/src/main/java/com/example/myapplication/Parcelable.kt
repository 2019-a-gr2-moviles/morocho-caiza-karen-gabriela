package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        val karen: Usuario? = this.intent
            .getParcelableExtra<Usuario>("usuario")


        val cachetes: Mascota? = this.intent
            .getParcelableExtra<Mascota>("mascota")
        Log.i("parcelable","Nombre ${karen?.nombre}")
        Log.i("parcelable","Nombre ${karen?.edad}")
        Log.i("parcelable","Nombre ${karen?.fechaNacimiento.toString()}")
        Log.i("parcelable","Nombre ${karen?.sueldo}")

        Log.i("parcelable","Nombre ${cachetes?.nombre}")
        Log.i("parcelable","Nombre ${cachetes?.duenio?.nombre}")

    }

    fun regresarAMenu(){
        val intentExplicito = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intentExplicito)
    }

}
