package listasListaDoble;

public class main {
    public static void main(String[] args) {
        ListaDoble<Integer> lista = new ListaDoble<>();

        //Agregar inicio
        lista.agregarInicio(10);
        lista.agregarInicio(20);
        System.out.println("Tamaño después de agregar al inicio: " + lista.size());
        lista.imprimirLista(); // 20 <-> 10

        //Agregar final
        lista.agregarFinal(40);
        System.out.println("Tamaño después de agregar al final: " + lista.size());
        lista.imprimirLista(); // 20 <-> 10 <-> 40

        //Agregar por posicion dado un indice
        lista.agregarEnPosicion(2, 50);
        System.out.println("Tamaño después de agregar por posición: " + lista.size());
        lista.imprimirLista(); // 20 <-> 10 <-> 50 <-> 40

        //Obtenener valor de un nodo dado el indice
        System.out.println(lista.obtenerValorNodo(0)); // 20
        System.out.println(lista.obtenerValorNodo(1)); // 10
        System.out.println(lista.obtenerValorNodo(2)); // 50
        System.out.println(lista.obtenerValorNodo(3)); // 40

        //Obtener la referencia del nodo por indice
        NodoDoble<Integer> nodo = lista.obtenerNodo(1);
        if (nodo != null) {
            System.out.println("Dato del nodo en índice 1: " + nodo.dato); // imprime 10
        } else {
            System.out.println("Índice no válido");
        }

        //Obtener posicion del nodo
        System.out.println(lista.obtenerPosicionNodo(30)); // -1 (no existe)
        System.out.println(lista.obtenerPosicionNodo(20)); // 0

        //Verificar que el indice sea valido
        System.out.println(lista.indiceValido(0)); // true
        System.out.println(lista.indiceValido(2)); // true
        System.out.println(lista.indiceValido(4)); // false
        System.out.println(lista.indiceValido(-1)); // false

        //Eliminar primero
        lista.eliminarPrimero();
        lista.imprimirLista(); // 10 <-> 50 <-> 40

        //Eliminar ultimo
        lista.eliminarUltimo();
        lista.imprimirLista(); // 10 <-> 50

        //Eliminar por valor
        lista.eliminar(10);
        lista.imprimirLista(); // 50

        //Agregamos más valores
        lista.agregarInicio(60);
        lista.agregarFinal(34);
        lista.agregarEnPosicion(2, 77);
        lista.imprimirLista(); // 60 <-> 50 <-> 77 <-> 34

        //Modificar un nodo
        lista.modificarNodo(2, 99);
        lista.imprimirLista(); // 60 <-> 50 <-> 99 <-> 34

        //Ordenar la lista
        lista.ordenarLista();
        lista.imprimirLista(); // 34 <-> 50 <-> 60 <-> 99

      
        //Borrar toda la lista
        lista.borrarLista();
        lista.imprimirLista(); // Lista vacía

        //Agregamos más valores
        lista.agregarInicio(45);
        lista.agregarFinal(64);
        lista.agregarEnPosicion(2, 37);
        lista.imprimirLista(); // 45 <-> 64 <-> 37

        
    }
}


