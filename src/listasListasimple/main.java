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

    }

}
