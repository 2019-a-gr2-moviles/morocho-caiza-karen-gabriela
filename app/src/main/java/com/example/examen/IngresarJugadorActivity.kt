package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_jugador.*
import kotlinx.android.synthetic.main.activity_main.*

class IngresarJugadorActivity : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = "";
    var equipoRespaldo : EquipoFutbol? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_jugador)
        usuario = intent.getStringExtra("usuario").toString()
        equipoRespaldo = intent.getParcelableExtra<EquipoFutbol>("EquipoRespaldo")
        padreId = intent.getIntExtra("padreId", -1)
        btnGuardar.setOnClickListener { guardarJugador() }
    }

    fun guardarJugador(){
        val jugador = Jugador(
            id = null,
            numeroCamiseta = txtnumeroCamiseta.text.toString().toInt(),
            nombreCamiseta = txtNombreCamiseta.text.toString(),
            nombreCompletoJugador = txtNombreJugador.text.toString(),
            poderEspecialDos = txtpoderEspecialDos.text.toString(),
            fechaIngresoEquipo = txtfechaIngresoEquipo.text.toString(),
            goles = txtGoles.text.toString().toInt(),
            equipoFutbolId = padreId
        )
        Jugador_BD.agregarJugador(jugador)
        Toast.makeText(this, getString(R.string.msg)+" "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ConsultarJugadorActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("padreId", padreId)
        retorno.putExtra("EquipoRespaldo", equipoRespaldo)
        startActivity(retorno)
    }
    override fun onBackPressed() {

        val intentMenu = Intent(this, ActualizarActivity::class.java)
        intentMenu.putExtra("usuario", usuario)

        intentMenu.putExtra("Equipo", equipoRespaldo)

        startActivity(intentMenu)
    }
}