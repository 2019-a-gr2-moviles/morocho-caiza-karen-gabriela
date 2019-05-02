import java.util.*

fun main(args: Array<String>) {

        /*
        * Comentario
        * */

        // Variables

        // QUE ES MUTAR?? CAMBIAR???
        // Mutables
        var nombre = "Adrian"
        nombre = "Vicente"
        // Inmutables
        val nombreI = "Adrian"
        // nombreI = "Vicente"

        // Tipos de Datos

        // val apellido = "Eguez"

        val apellido = "Eguez"
        val edad: Int = 29
        val sueldo: Double = 1.21
        val casado: Boolean = false
        val profesor: Boolean = true
        val hijos = null

        // Duck Typing
        // Si parace un pato
        // Si camina como pato
        // Si suena como pato
        // Si vuela como pato
        // PATO

        // Condicionales

        if (apellido == "Eguez" || nombre == "Adrian") {
                println("Verdadero")
        } else {
                println("Falso")
        }

        val tieneNombreYApellido = if (apellido != null && nombre != null) "ok" else "no"
        println(tieneNombreYApellido)
        estaJalado(1.0)
        estaJalado(8.0)
        estaJalado(0.0)
        estaJalado(7.0)
        estaJalado(10.0)
        holaMundo("Adrian")
        holaMundoAvanzado(2)
        val total = sumarDosNumeros(1, 3)
        println(total)

        val arregloCumpleanos: Array<Int> = arrayOf(1, 2, 3, 4)

        var arregloTodo: Array<Any> = arrayOf(1, "asd", 10.2, true)

        arregloCumpleanos[0] = 5
        arregloCumpleanos.set(0, 5)

        arregloTodo = arrayOf(5, 2, 3, 4)

        // val notas: ArrayList<Int> = arrayListOf<Int>(1, 2, 3, 4, 5, 6)

        val notas = arrayListOf(1, 2, 3, 4, 5, 6)


        // FOR EACH -> Itera el arreglo
        notas.forEachIndexed { indice, nota ->
                println("Indice: $indice")
                println("Nota: $nota")
        }


        // MAP -> itera y modifica el arreglo
        // Impares +1  Pares +2
        val notasDos = notas.map { nota ->
                val modulo = nota % 2
                val esPar = 0
                /*  */
                when (modulo) {
                        esPar -> {
                                nota + 1
                        }
                        else -> {
                                nota + 2
                        }
                }


        }

        notasDos.forEach {
                println("Notas 2: $it")
        }


        val respuestaFilter = notas
                .filter {
                        // Filtra el arreglo
                        it in 3..4
                        // it > 2 && it < 5
                }
                .map {
                        // Mutar o Cambiar el arreglo
                        it * 2
                }

        respuestaFilter.forEach { println(it) }

        val novias = arrayListOf(1, 2, 2, 3, 4, 5)

        val respuestaNovia: Boolean = novias.any {
                it == 7
        }

        println(respuestaNovia) // true
        println(respuestaNovia) // false

        val tazos = arrayListOf(1,2,3,4,5,6,7)

        val respuestaTazos = tazos.all {
                it > 1
        }

        println(respuestaTazos) // falso

        val totalTazos = tazos.reduce { valorAcumulado, tazo ->
                valorAcumulado + tazo
        }
        println(totalTazos)


        // val fecha = Date()
        // fecha.time = 11231231
        // fecha.year = 2000
        // fecha = Date(1989,6,10)

        // sumerDosNumeros(numUno:1, numDos:3)
        // IMPORTANTE: numUno: y numDos:
        // los pone el editor
        // de texto.
}

fun holaMundo(mensaje: String): Unit {
        println("Mensaje: $mensaje.")
}

fun holaMundoAvanzado(mensaje: Any): Unit {
        println("Mensaje: $mensaje.")
}

fun sumarDosNumeros(numUno: Int, numDos: Int): Int {
        return numUno + numDos
}


fun estaJalado(nota: Double): Double {
        when (nota) {
                7.0 -> {
                        println("Pasaste con las justas")
                }
                10.0 -> {
                        println("Genial :D Felicitaciones!")
                }
                0.0 -> {
                        println("Dios mio que vago!")
                }
                else -> {
                        println("Tu nota es: $nota")
                        // println("Tu nota es: ${nota}")
                }
        }
        return nota
}

