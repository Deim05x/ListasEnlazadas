package listasListasimple;

public class main {

    public static void main(String[] args) {
        ListaSimple<Integer> lista = new ListaSimple<>();

        lista.agregarInicio(10);
        lista.agregarInicio(20);
        System.out.println("Tamaño después de agregar al inicio: " + lista.getTamanio());
        lista.imprimirLista();

        lista.agregarFinal(40);
        System.out.println("Tamaño después de agregar al inicio: " + lista.getTamanio());
        lista.imprimirLista();

        lista.agregarPorPosicion(4, 50);
        System.out.println("Tamaño después de agregar al inicio: " + lista.getTamanio());
        lista.imprimirLista();
    }

}
