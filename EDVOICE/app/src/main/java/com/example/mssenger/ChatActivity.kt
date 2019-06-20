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

        val mensaje:Mensaje?= this.intent.getParcelableExtra<Mensaje>("mensaje")
        Log.i("mensaje", "Mensajee ${mensaje?.autor}")
        llenarDatos(mensaje!!)


        var listachat = arrayListOf<Chat>()



        listachat.add(Chat("Tareas: Realizar 10 sumas y 10 restas","Pruebas: Próximo Martes 25/06/2019 "))
        listachat.add(Chat("Reunión: Viernes 28/06/2019 ","Recordatorio: Mañana deportiva - Último sábado del mes de julio"))
        listachat.add(Chat("Clausura: Viernes 29 de Julio","Autrización: Salida al museo del agua próximo jueves"))
        listachat.add(Chat("Este easdasdasdasdasd","este easdasdasdasdasdasdasdasd"))
        listachat.add(Chat("Este easdasdasdasdasd","este easdasdasdasdasdasdasdasd"))
        listachat.add(Chat("Este easdasdasdasdasd","este easdasdasdasdasdasdasdasd"))
        listachat.add(Chat("Este easdasdasdasdasd","este easdasdasdasdasdasdasdasd"))
        listachat.add(Chat("Este easdasdasdasdasd","este easdasdasdasdasdasdasdasd"))
        listachat.add(Chat("Este easdasdasdasdasd","este easdasdasdasdasdasdasdasd"))


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


    fun llenarDatos(mensaje:Mensaje){


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
        txt_mensaje.text = "Active 1h ago"
        txt_nombre_usuario_chat.text = mensaje.autor




        }

    }



