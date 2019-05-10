
import modelo.Computador
import modelo.User
import java.io.File
import java.lang.Exception
import javax.swing.JOptionPane

var computador =Computador()
val list = arrayListOf<Computador>()

fun main(args: Array<String>) {
    while(true)
        if(validar(login())){
            home()
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro usuario", "ERROR", JOptionPane.ERROR_MESSAGE)
        }
}

fun login(): User {
    val user = User()
    user.Nombre = JOptionPane.showInputDialog("Ingrese nombre de usuario")
    user.Clave = JOptionPane.showInputDialog("Ingrese su clave")
    return user
}

fun validar(user: User):Boolean{
    val path = "./src/users.txt"
    val arreglo_users = ArrayList<String>()
    File(path).forEachLine { linea ->
        arreglo_users.add(linea)
    }
    var split_usuarios = listOf<String>()

    arreglo_users.forEach { leida ->
        split_usuarios = leida.split(",")
        if (split_usuarios[0]==user.Nombre && split_usuarios[1] == user.Clave) {
            return true
        }
    }
    return false
}

fun home() {
    while (true)
        try {
            var op: Int = JOptionPane.showInputDialog(
                null, "Seleccione una opcion" +
                        "\n1. Mostrar Catalogo" +
                        "\n2. Editar Catalogo" +
                        "\n3. Salir", "BIENVENIDOS A SU CATÁlOGO: PC STORE", 1
            ).toInt()

            when (op) {
                1 -> {
                }
                2 -> {editarCatálogo()

                }
                3 -> {
                    System.exit(0)
                }
            }
        } catch (e: Exception) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una opcion")
        }
}

fun editarCatálogo() {
    while (true)
        try {
            var op: Int = JOptionPane.showInputDialog(
                null, "Seleccione una opcion" +
                        "\n1. Añadir nuevo computador" +
                        "\n2. Modificar caracteristicas del  Computador" +
                        "\n3. Buscar computador" +
                        "\n4. Eliminar computador" +
                        "\n5. Regresar al menú principal", "BIENVENIDOS A SU CATÁlOGO: PC STORE", 1
            ).toInt()

            when (op) {
                1 -> { list.add(ingresarComputador())
                    home()
                }
                2 -> {actualizarComputador()
                    home()

                }
                3 -> {buscarComputador()
                    home()
                }
                4 -> {eliminarComputador()
                    home()
                }
                5 -> {
                    home()
                }
            }
        } catch (e: Exception) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una opcion")
        }
}


fun ingresarComputador():Computador{
    var pc = Computador()
    val codigo = JOptionPane.showInputDialog("Código del computador")
    pc.codigoComputador=codigo.toInt()

    val marca = JOptionPane.showInputDialog("Marca del computador")
    pc.marcaComputador=marca.toString()

    val tipo = JOptionPane.showInputDialog("Tipo del computador")
    pc.tipoComputador=tipo.toString()

    val procesador = JOptionPane.showInputDialog("Procesador del computador")
    pc.procesadorComputador=procesador.toString()

    val precio = JOptionPane.showInputDialog("Precio del computador")
    pc.precioComputador=precio.toDouble()
    JOptionPane.showMessageDialog(null, "Computador ingresado con éxito")

    return pc
}

fun actualizarComputador(){
    val marca = JOptionPane.showInputDialog("Marca del computador a modificar")
    var pc = Computador()
    if(list.none{it.marcaComputador==marca}){
        JOptionPane.showMessageDialog(null, "No existe")
    } else {
        var index = getIndex(marca)
        if(index<0) {
            JOptionPane.showMessageDialog(null, "Error de busqueda")
        }else{
            buscarComputador(index)
            pc = ingresarComputador()
            JOptionPane.showMessageDialog(null, "Computador actualizado con éxito")

            list[index] = pc
        }
    }

}

fun getIndex(marca: String): Int{
    for (item: Computador in list) {
        if (item.marcaComputador == marca) {
            return list.indexOf(item)
        }
    }
    return -1
}


fun buscarComputador(){
    var pc: String = ""
    for (item: Computador in list) {
        pc += "Código del computador: " + item.codigoComputador + "\n" +
                "Marca del computador " + item.marcaComputador + "\n" +
                "Tipo de computador " + item.tipoComputador + "\n" +
                "Procesador del computador " + item.procesadorComputador + "\n" +
                "Precio del computador " + item.precioComputador + "\n"
    }
    JOptionPane.showMessageDialog(null, pc)
}

fun buscarComputador(index: Int){
    var pc = Computador()
    pc = list[index]
    JOptionPane.showMessageDialog(null, "Código del computador: " + pc.codigoComputador + "\n" +
            "Marca del computador " + pc.marcaComputador + "\n" +
            "Tipo de computador " + pc.tipoComputador + "\n" +
            "Procesador del computador " + pc.procesadorComputador + "\n" +
            "Precio del computador " + pc.precioComputador + "\n")

}

fun eliminarComputador(){
    var codigopc: Int
    val pc = JOptionPane.showInputDialog("Ingrese el código del computador a ser eliminado")
    codigopc = pc.toInt()

    for (i in list.indices) {
        if (list[i].codigoComputador.equals(codigopc)) {
            list.removeAt(i)


        }
        JOptionPane.showMessageDialog(null, "Computador eliminado")
    }


}
