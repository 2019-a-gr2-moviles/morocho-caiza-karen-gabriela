package com.example.kgmc.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actualizar.*
import kotlinx.android.synthetic.main.activity_actualizar.txtFechaCreacion
import kotlinx.android.synthetic.main.activity_actualizar.txtLiga
import kotlinx.android.synthetic.main.activity_actualizar.txtNombre
import kotlinx.android.synthetic.main.activity_actualizar.txtNumCopInter

class ActualizarActivity : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar)
        usuario = intent.getStringExtra("usuario").toString()
        val equipoRecibida = intent.getParcelableExtra<EquipoFutbol>("Equipo")
        txtNombre.setText(equipoRecibida.nombre.toString())
        txtLiga.setText(equipoRecibida.liga.toString())
        txtFechaCreacion.setText(equipoRecibida.fechaCreacion.toString())
        txtNumCopInter.setText(equipoRecibida.numeroCopasInternacionales.toString())
        Log.i("campeon","campeon: ${equipoRecibida.campeonActual.toString()}")
        if(equipoRecibida.campeonActual.toString().equals("0")){
            rdActualizarCam.setChecked(false)
        }
        if(equipoRecibida.campeonActual.toString().equals("1")){
            Log.i("campeon if","campeon: ${equipoRecibida.campeonActual.toString()}")
            rdActualizarCam.setChecked(true)
        }

        padreId = equipoRecibida.id!!;
        btnActualizar.setOnClickListener { actualizarEquipo() }
        btnEliminar.setOnClickListener { eliminarEquipo() }
        btnCrearJugador.setOnClickListener { crearJugador() }
        btnGestionarJugador.setOnClickListener { gestionarJugador() }
        btnMenuRetorno.setOnClickListener { retorno() }
    }

    fun actualizarEquipo(){
        var cam:Byte
        if(rdActualizarCam.isChecked){
            cam=1
        }else{
            cam=0
        }
        val actualizarEquipo = EquipoFutbol(
            id = padreId,
            nombre = txtNombre.text.toString(),
            liga = txtLiga.text.toString(),
            fechaCreacion = txtFechaCreacion.text.toString(),
            numeroCopasInternacionales = txtNumCopInter.text.toString().toInt(),
            campeonActual = cam
        )
        EquipoFutbol_BD.actualizarEquipo(actualizarEquipo)
        Toast.makeText(this, getString(R.string.msgActualizar)+" "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ConsultarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }

    fun eliminarEquipo(){
        EquipoFutbol_BD.eliminarEquipo(padreId);
        Toast.makeText(this, getString(R.string.msgEliminar)+" "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ConsultarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }

    fun crearJugador(){
        val cam:Byte
        if(rdActualizarCam.isChecked){
            cam=1
        }else{
            cam=0
        }
        val equipoRespaldo = EquipoFutbol(
            id = padreId,
            nombre = txtNombre.text.toString(),
            liga = txtLiga.text.toString(),
            fechaCreacion = txtFechaCreacion.text.toString(),
            numeroCopasInternacionales = txtNumCopInter.text.toString().toInt(),
            campeonActual = cam
        )
        val retorno = Intent(this, IngresarJugadorActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("padreId", padreId)
        retorno.putExtra("EquipoRespaldo", equipoRespaldo)
        startActivity(retorno)
    }

    fun gestionarJugador(){
        val cam:Byte
        if(rdActualizarCam.isChecked){
            cam=1
        }else{
            cam=0
        }
        val equipoRespaldo = EquipoFutbol(
            id = padreId,
            nombre = txtNombre.text.toString(),
            liga = txtLiga.text.toString(),
            fechaCreacion = txtFechaCreacion.text.toString(),
            numeroCopasInternacionales = txtNumCopInter.text.toString().toInt(),
            campeonActual = cam
        )
        val retorno = Intent(this, ConsultarJugadorActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("padreId", padreId)
        retorno.putExtra("EquipoRespaldo", equipoRespaldo)
        startActivity(retorno)
    }

    fun retorno(){
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }
    override fun onBackPressed() {

        val intentMenu = Intent(this, ConsultarActivity::class.java)
        intentMenu.putExtra("usuario", usuario)
        startActivity(intentMenu)
    }
}