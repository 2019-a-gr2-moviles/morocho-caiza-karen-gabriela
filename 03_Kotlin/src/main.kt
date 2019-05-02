import java.util.*

fun main(args:  Array<String>){







    println("Hello, worldeeeee")

/*
*
* comentario
* */

    //variables

    //Que es mutar ??

    var nombre = "Michael Morales"
    nombre = "Juan"

    val nombreI = "Lucho"
    //nombreI = "Luis"







    val apellido:String = "Morales"
    val edad: Int =22
    val sueldo =400
    val casado = false
    val profesor = true
    val hijos = null


    val tiene = if(apellido!=null && nombre!=null ) "ok" else "no"

    println(tiene)



    estaJalado(1.0)
    estaJalado(10.0)
    estaJalado(0.0)
    estaJalado(7.0)

    holaMundo("Michael hola")
    holaMundoAvanzado(34)

    val suma = sumarDosNumeros(1,2)
    println(suma)







    val arregloCumpleaños :Array<Int> = arrayOf(1,2,3,4,5,6)

    arregloCumpleaños.set(0,5)


    val notas = arrayListOf(1,2,3,4,5,6)

    //val fecha = Date()


    //el foreach Itera el Arreglo
    notas.forEachIndexed{ indice, nota->
        println("Indice: $indice")
        println("nota: $nota")


    }


    //Map itera y modifica el arreglo


    val notasDos = notas.map{ nota->


        when(nota % 2 ){
            0 -> {
                nota+ 1
            }
            else ->{

                nota + 2
            }

        }
    }

    println("$notasDos")


    val respuestaFilter = notas.filter{

        it in 3..6


    }.map{

        it * 4


    }
    respuestaFilter.forEach{println(it)}



    val novias = arrayListOf(1,2,3,4,5,6)


    val respuestaNovias = novias.any{

        it==3
    }
    val tazos = arrayListOf(1,2,3,4,5,6,7)

    val respuestaTazos =  tazos.all{
        it > 1


    }

    println(respuestaTazos)


    val valorTazos = tazos.reduce{  valorAcumulado, tazo  ->

        valorAcumulado + tazo


    }

    println(valorTazos)

}




fun estaJalado(nota:Double){

    when(nota){

        7.0 ->{
            println("Pasaste con las Justas")


        }
        10.0 ->{
            println("fELICITACIONES PASASTE")


        }
        0.0 ->{
            println("Ya te jalaste mijo: !!! ")


        }
        else -> {

            println("Tu nota es : $nota " )


        }


    }


}

fun holaMundo(mensaje: String):Unit{

    println("mensaje: $mensaje.")


}
fun holaMundoAvanzado(mensaje: Any):Unit{
    println("mensaje: $mensaje.")
}

fun sumarDosNumeros(numUno: Int, numDos: Int):Int{
    return numUno + numDos

}






class Usuario(val cedula:String){

    public var nombre:String = ""
    public var apellido:String = ""


    // constructor(apellido:String):this(cedula){

    // this.apellido = apellido;

//}


}

class Numero(var numero:Int){

    constructor(numeroString:String):this(numeroString.toInt()){

        println("Const")

    }
    init{
        print("init")
    }

}






//SI SE ELIMINA EL PUBLIC NO PASA NADA POR QUE KITLIN ES PUBLICO POR DEFECTO

class UsuarioKt(public var nombre:String,
                public var apellido:String,
                private var id:Int,
                protected var id2: Int


) {
    public fun hola():String{
        return this.apellido

    }
    private fun hola2(){

    }
    protected fun hola3(){



    }
    companion object {
        val gravedad = 10.9

        fun correr(){
            println("I am Running en $gravedad")

        }
    }
}



class BaseDeDatos{
    companion object {

        val usuarios = arrayListOf(1,2,3)
        fun agregarUsuario(usuario:Int){

            this.usuarios.add(usuario)

        }
        fun eliminarUsuario(usuario:Int){


        }



    }



}










fun aa(){
    UsuarioKt.gravedad
    UsuarioKt.correr()


}


class A (){
    //A.correr()      -->

    //A.nombre    -->

}


fun a(){
    // var adrian = UsuarioKt("a","b")
    //adrian.nombre = "asdasd"

}



abstract class Numeros(var numeroUno:Int,
                       var numeroDos:Int){


}

class Sunma(numeroUnos:Int,numeroDoss:Int):Numeros(numeroUnos,numeroDoss)
{




}


fun presley(requerido:Int,
            opcional:Int=1,
            nulo:UsuarioKt?//Que aveces va a ser nulo
)
{
    if(nulo!=null){

        nulo.nombre

    }

    val nombre:String? = nulo?.nombre.toString()

}


fun sdc(){
    presley(requerido = 1,nulo = null) //Named pARAMETERS
    //  presley(1,1,1)
    presley(1,1,null)





}