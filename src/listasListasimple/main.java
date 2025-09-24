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
    }

}
