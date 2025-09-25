package ListasListaCircularSimple;

public class Main {
    public static void main(String[] args) {
        ListaCircular<Integer> lista = new ListaCircular<>();

        System.out.println("========== PRUEBAS LISTA CIRCULAR ==========\n");

        // 1. Agregar elementos al inicio
        System.out.println("Agregando elementos al inicio...");
        lista.agregarInicio(30);
        lista.agregarInicio(20);
        lista.agregarInicio(10);
        lista.imprimirLista();

        // 2. Agregar elementos al final
        System.out.println("\nAgregando elementos al final...");
        lista.agregarFinal(40);
        lista.agregarFinal(50);
        lista.imprimirLista();

        // 3. Mostrar tamaño
        System.out.println("\nTamaño actual de la lista: " + lista.getTamanio());

        // 4. Obtener valor por índice
        System.out.println("\nValor en índice 2: " + lista.obtenerValorNodo(2));

        // 5. Modificar nodo
        System.out.println("\nModificando índice 1 -> nuevo valor = 25");
        lista.modificarNodo(1, 25);
        lista.imprimirLista();

        // 6. Eliminar primero
        System.out.println("\nEliminando el primer nodo...");
        lista.eliminarPrimero();
        lista.imprimirLista();

        // 7. Eliminar último
        System.out.println("\nEliminando el último nodo...");
        lista.eliminarUltimo();
        lista.imprimirLista();

        // 8. Eliminar por valor
        System.out.println("\nEliminando el nodo con valor 40...");
        lista.eliminar(40);
        lista.imprimirLista();

        // 9. Buscar posición de un valor
        System.out.println("\nPosición del nodo con valor 25: " + lista.obtenerPosicionNodo(25));

        // 10. Ordenar lista
        System.out.println("\nAgregando valores desordenados...");
        lista.agregarFinal(70);
        lista.agregarFinal(5);
        lista.agregarFinal(60);
        lista.agregarFinal(15);
        lista.imprimirLista();

        System.out.println("\nOrdenando lista...");
        lista.ordenarLista();
        lista.imprimirLista();

        // 11. Recorrer con for-each (gracias al Iterator)
        System.out.println("\nRecorriendo lista con for-each:");
        for (Integer valor : lista) {
            System.out.print(valor + " ");
        }
        System.out.println();

        // 12. Borrar toda la lista
        System.out.println("\nBorrando lista completa...");
        lista.borrarLista();
        lista.imprimirLista();

        System.out.println("\n========== FIN DE PRUEBAS ==========");
    }
}

