package com.example.kgmc.examen

class Jugador_BD {
    companion object {
        val Jugador_Lista:ArrayList<Jugador> = ArrayList();
        var serial:Int= 1;

        fun agregarJugador(jugador: Jugador):ArrayList<Jugador>{
            jugador.id = serial
            serial++
            Jugador_Lista.add(jugador)
            return Jugador_Lista
        }

        fun mostrarJugador(padreId:Int): List<Jugador> {
            val lstFiltradaJugador = Jugador_Lista.filter { it.equipoFutbolId ==  padreId}
            return lstFiltradaJugador
        }

        fun eliminarJugador(id:Int){
            Jugador_Lista.removeAll{ it.id == id }
        }

        fun actualizarJugador(jugador: Jugador){
            val indice = Jugador_Lista.indexOfFirst { it.id == jugador.id }
            Jugador_Lista[indice] = jugador
        }

    }

}