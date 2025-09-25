package ListaCircularDoblementeEnlazada;

public class Main {
    public static void main(String[] args) {
        ListaCircularDoblementeEnlazada<Integer> lista = new ListaCircularDoblementeEnlazada<Integer>();

        System.out.println("----- PRUEBAS LISTA CIRCULAR DOBLEMENTE ENLAZADA -----");

        // Prueba agregarInicio
        lista.agregarInicio(30);
        lista.agregarInicio(20);
        lista.agregarInicio(10);
        lista.imprimirLista(); // Esperado: 10 20 30

        // Prueba agregarFinal
        lista.agregarFinal(40);
        lista.agregarFinal(50);
        lista.imprimirLista(); // Esperado: 10 20 30 40 50

        // Prueba agregarPorPosicion
        lista.agregarPorPosicion(2, 25); // en índice 2
        lista.imprimirLista(); // Esperado: 10 20 25 30 40 50

        // Prueba obtenerValorNodo
        System.out.println("Valor en posición 3: " + lista.obtenerValorNodo(3)); // Esperado: 30

        // Prueba obtenerPosicionNodo
        System.out.println("Posición del valor 40: " + lista.obtenerPosicionNodo(40)); // Esperado: 4

        // Prueba modificarNodo
        lista.modificarNodo(1, 22);
        lista.imprimirLista(); // Esperado: 10 22 25 30 40 50

        // Prueba eliminarPrimero
        lista.eliminarPrimero();
        lista.imprimirLista(); // Esperado: 22 25 30 40 50

        // Prueba eliminarUltimo
        lista.eliminarUltimo();
        lista.imprimirLista(); // Esperado: 22 25 30 40

        // Prueba eliminar (por valor)
        lista.eliminar(25);
        lista.imprimirLista(); // Esperado: 22 30 40

        // Prueba ordenarLista
        lista.agregarInicio(100);
        lista.agregarFinal(5);
        lista.imprimirLista(); // Antes de ordenar
        lista.ordenarLista();
        lista.imprimirLista(); // Ordenada

        // Prueba Iterator (recorrer con foreach)
        System.out.print("Recorrido con Iterator: ");
        for (Integer num : lista) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Prueba borrarLista
        lista.borrarLista();
        lista.imprimirLista(); // Esperado: Lista vacía
        System.out.println("Tamaño: " + lista.getTamanio()); // Esperado: 0
    }
}

