package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_parcelable.setOnClickListener {
            irAParcelable()
        }
        btn_adapter.setOnClickListener {
            irAListView()
        }

        btn_recycler_view.setOnClickListener {
            irArecyclerView()
        }
    }

    fun irAParcelable(){
        val intentExplicito = Intent(
            this,
            Parcelable::class.java
        )
        val karen = Usuario("Karen",
            23,
            Date(),
            100.50)
        intentExplicito.putExtra("usuario",karen)
        startActivity(intentExplicito)

        val cachetes = Mascotas("Cachetes", karen)
        intentExplicito.putExtra("mascotas",cachetes)
        startActivity(intentExplicito)
    }


    fun irArecyclerView(){
        val intentExplicito = Intent(
                this,
                ReciclerViewActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun irAListView(){
        val intentExplicito = Intent(
            this,
            ListViewActivity::class.java
        )
        startActivity(intentExplicito)
    }


}
