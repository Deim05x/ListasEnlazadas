package listasListasimple;

public class main {

    public static void main(String[] args) {
        ListaSimple<Integer> lista = new ListaSimple<>();

        //Agregar inicio
        lista.agregarInicio(10);
        lista.agregarInicio(20);
        System.out.println("Tamaño después de agregar al inicio: " + lista.getTamanio());
        lista.imprimirLista();

        //Agregar final
        lista.agregarFinal(40);
        System.out.println("Tamaño después de agregar al inicio: " + lista.getTamanio());
        lista.imprimirLista();


        //Agregar por posicion dado un indice
        lista.agregarPorPosicion(2, 50);
        System.out.println("Tamaño después de agregar al inicio: " + lista.getTamanio());
        lista.imprimirLista();

        //Obtenener valor de un nodo dado el indice
        System.out.println(lista.obtenerValorNodo(0)); // 20
        System.out.println(lista.obtenerValorNodo(1)); // 10
        System.out.println(lista.obtenerValorNodo(2)); // 50
        System.out.println(lista.obtenerValorNodo(3)); // 40
        System.out.println(lista.obtenerValorNodo(4)); // null

        //Obtener la referencia del nodo por indice
        Node<Integer> nodo = lista.obtenerNodo(1);
        if (nodo != null) {
            System.out.println("Dato del nodo: " + nodo.getDato()); // imprime 10 (indice 1)
        } else {
            System.out.println("Índice no válido");
        }

        //Obtener posicion del nodo
        System.out.println(lista.obtenerPosicionNodo(30)); // -1
        System.out.println(lista.obtenerPosicionNodo(20)); // 0

        //Verificar que el indice sea valido
        System.out.println(lista.indiceValido(0)); // true
        System.out.println(lista.indiceValido(2)); // true
        System.out.println(lista.indiceValido(4)); // false (fuera de rango)
        System.out.println(lista.indiceValido(-1)); // false (negativo)

        //Eliminar primero
        lista.eliminarPrimero();
        lista.imprimirLista(); // 10-50-40

        //Eliminar ultimo
        lista.eliminarUltimo();
        lista.imprimirLista(); // 10-50

        //Eliminar por valor
        lista.eliminar(10);
        lista.imprimirLista(); // 50

        //Agregamos mas valores
        lista.agregarInicio(60);

        lista.agregarFinal(34);

        lista.agregarPorPosicion(2, 77);
        lista.imprimirLista();

        //Modificar un nodo
        lista.modificarNodo(2, 99);
        lista.imprimirLista(); // 77 -> 99

        //Ordenar la lista
        lista.ordenarLista();
        lista.imprimirLista(); // 34-50-60-99

        //Recorrer con iterator
        for (Integer valor : lista) {
            System.out.print(valor + " ");
        }
        System.out.println();

        //Borrar toda la lista
        lista.borrarLista();
        lista.imprimirLista(); // Lista vacia

        //Agregamos mas valores
        lista.agregarInicio(45);

        lista.agregarFinal(64);

        lista.agregarPorPosicion(2, 37);
        lista.imprimirLista();

        //Lista invertida
        lista.invertirContenido();
        lista.imprimirLista(); // 37-64-45
    }
}
