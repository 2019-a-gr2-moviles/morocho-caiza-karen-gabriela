package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ciclo_vida.*

class CicloVidaActivity : AppCompatActivity() {
    var contador = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo_vida)

       Log.i("ciclo-vida", "onCreate")
        btn_contador.setOnClickListener {
            aumentarContador()
        }
    }

    fun aumentarContador(){
        contador++
        txv_contador.text = contador.toString()
    }
    override fun onStart(){
        super.onStart()
    }
    override fun onResume(){
        super.onResume()
    }
    override fun onPause(){
        super.onPause()
    }
    override fun onStop(){
        super.onStop()
    }
    override fun onRestart(){
        super.onRestart()
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.i("ciclo-vida", "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle?) { //despues del Stop
        Log.i("ciclo-vida", "onSaveInstanceState" )
        outState?.run{
            putInt("contadorGuardado", contador)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("ciclo-vida", "onRestoreInstanceState" )
        val contadorRecuperado = savedInstanceState?.getInt("contadorGuardado")

        if(contadorRecuperado!=null){

            this.contador = contadorRecuperado
            txv_contador.text = this.contador.toString()
        }
    }
}
