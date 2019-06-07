package com.example.examen

class EquipoFutbol_BD{
    companion object {
        val Equipo_Lista:ArrayList<EquipoFutbol> = ArrayList();
        var serial:Int= 1;
        var nombreUsuario:String = "";

        fun guardarUsuario(nombre:String){
            nombreUsuario = nombre;
        }

        fun agregarEquipo(equipo: EquipoFutbol):ArrayList<EquipoFutbol>{
            equipo.id = serial
            serial++
            Equipo_Lista.add(equipo)
            return Equipo_Lista
        }

        fun mostrarEquipo(): List<EquipoFutbol> {
            return Equipo_Lista
        }

        fun eliminarEquipo(id:Int){
            Equipo_Lista.removeAll{ it.id == id }
        }

        fun actualizarEquipo(equipo: EquipoFutbol){
            val indice = Equipo_Lista.indexOfFirst { it.id == equipo.id }
            Equipo_Lista[indice] = equipo
        }

    }

}