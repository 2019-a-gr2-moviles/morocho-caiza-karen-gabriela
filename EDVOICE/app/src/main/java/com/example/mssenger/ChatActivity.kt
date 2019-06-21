package com.example.mssenger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val mensaje:Mensajeria?= this.intent.getParcelableExtra<Mensajeria>("mensaje")
        Log.i("mensaje", "Mensajee ${mensaje?.autor}")
        llenarDatos(mensaje!!)


        var listachat = arrayListOf<Chat>()



        listachat.add(Chat("Tarea 1: Realizar 10 sumas entre centenas","Pruebas: Próximo Martes 25/06/2019 "))
        listachat.add(Chat("Tarea 2: Escribir 10 restas para resolver en clase ","Recordatorio: Mañana deportiva - Último sábado del mes de julio"))
        listachat.add(Chat("Tarea 3: Resolver 10 restas entre decenas","Autrización: Salida al museo del agua próximo jueves"))
        listachat.add(Chat("Tarea 4: Página 10 del libro","Tarea 5: Resolver 10 restas entre decenas"))
        listachat.add(Chat("Tarea 6: Consultar que es la multiplicación","Tarea 7: Resolver 5 Multiplicaciones"))
        listachat.add(Chat("Tarea 8: Repasar las tablas","Tarea 3: Página 12 del libro"))





        iniciarRecylerView(listachat,this,rv_chats)



    }
    fun iniciarRecylerView(
        lista: List<Chat>,
        actividad: ChatActivity,
        recycler_view: RecyclerView
    ) {
        val adaptadorchat = AdaptadorChat(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorchat
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorchat.notifyDataSetChanged()
    }


    fun llenarDatos(mensaje:Mensajeria){


        when(mensaje.id_usuario){
            1 -> { img_profile_image.setImageResource(R.drawable.foto_alicia) }
            2 -> { img_profile_image.setImageResource(R.drawable.foto_ana) }
            3 -> { img_profile_image.setImageResource(R.drawable.foto_elvira) }
            4 -> { img_profile_image.setImageResource(R.drawable.foto_enrique) }
            5 -> { img_profile_image.setImageResource(R.drawable.foto_geraldine) }
            6 -> { img_profile_image.setImageResource(R.drawable.foto_luz) }
            7 -> { img_profile_image.setImageResource(R.drawable.foto_margarita) }
            8 -> { img_profile_image.setImageResource(R.drawable.foto_richard) }
            9 -> { img_profile_image.setImageResource(R.drawable.foto_sara) }
            10 -> { img_profile_image.setImageResource(R.drawable.foto_susana) }
            else ->{img_profile_image.setImageResource(R.drawable.foto_teresa)}
            }
        txt_mensaje.text = "MATEMATICA 2B"
        txt_nombre_usuario_chat.text = mensaje.autor


        }

    }



