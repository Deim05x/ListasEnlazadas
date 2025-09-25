package ListasListaCircularSimple;

import java.util.Iterator;

public class ListaCircular<T extends Comparable<T>> implements Iterable<T> {

    private NodoCircular<T> cabeza;
    private NodoCircular<T> cola;
    private int size;

    public ListaCircular() {
        cabeza = null;
        cola = null;
        size = 0;
    }

    public boolean estaVacia() {
        return size == 0;
    }

    public int getTamanio() {
        return size;
    }

    public void agregarInicio(T dato) {
        NodoCircular<T> nuevo = new NodoCircular<>(dato);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.setNext(cabeza);
            cabeza = nuevo;
            cola.setNext(cabeza);
        }
        size++;
    }

    public void agregarFinal(T dato) {
        NodoCircular<T> nuevo = new NodoCircular<>(dato);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setNext(nuevo);
            cola = nuevo;
            cola.setNext(cabeza);
        }
        size++;
    }

    public T obtenerValorNodo(int indice) {
        if (!indiceValido(indice)) {
            return null;
        }
        NodoCircular<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getNext();
        }
        return actual.getDato();
    }

    private NodoCircular<T> obtenerNodo(int indice) {
        if (!indiceValido(indice)) {
            return null;
        }
        NodoCircular<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getNext();
        }
        return actual;
    }

    public int obtenerPosicionNodo(T valor) {
        if (estaVacia())
            return -1;
        NodoCircular<T> actual = cabeza;
        for (int i = 0; i < size; i++) {
            if (actual.getDato().equals(valor)) {
                return i;
            }
            actual = actual.getNext();
        }
        return -1;
    }

    public boolean indiceValido(int indice) {
        return indice >= 0 && indice < size;
    }

    public void modificarNodo(int indice, T nuevoValor) {
        NodoCircular<T> nodo = obtenerNodo(indice);
        if (nodo != null) {
            nodo.setDato(nuevoValor);
        }
    }

    public void eliminarPrimero() {
        if (estaVacia())
            return;
        if (size == 1) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.getNext();
            cola.setNext(cabeza);
        }
        size--;
    }

    public void eliminarUltimo() {
        if (estaVacia())
            return;
        if (size == 1) {
            cabeza = null;
            cola = null;
        } else {
            NodoCircular<T> actual = cabeza;
            while (actual.getNext() != cola) {
                actual = actual.getNext();
            }
            cola = actual;
            cola.setNext(cabeza);
        }
        size--;
    }

    public boolean eliminar(T valor) {
        if (estaVacia())
            return false;

        if (cabeza.getDato().equals(valor)) {
            eliminarPrimero();
            return true;
        }
        if (cola.getDato().equals(valor)) {
            eliminarUltimo();
            return true;
        }

        NodoCircular<T> actual = cabeza;
        while (actual.getNext() != cabeza) {
            if (actual.getNext().getDato().equals(valor)) {
                actual.setNext(actual.getNext().getNext());
                size--;
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }

    public void ordenarLista() {
        if (size <= 1)
            return;
        boolean cambiado;
        do {
            cambiado = false;
            NodoCircular<T> actual = cabeza;
            for (int i = 0; i < size - 1; i++) {
                NodoCircular<T> siguiente = actual.getNext();
                if (actual.getDato().compareTo(siguiente.getDato()) > 0) {
                    T temp = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(temp);
                    cambiado = true;
                }
                actual = siguiente;
            }
        } while (cambiado);

    }

    public void borrarLista() {
        cabeza = null;
        cola = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private NodoCircular<T> actual = cabeza;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                T dato = actual.getDato();
                actual = actual.getNext();
                count++;
                return dato;
            }
        };
    }

    public void imprimirLista() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        NodoCircular<T> actual = cabeza;
        for (int i = 0; i < size; i++) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getNext();
        }
        System.out.println("(vuelve al inicio)");
    }
}