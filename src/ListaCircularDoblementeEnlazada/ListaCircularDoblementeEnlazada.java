package ListaCircularDoblementeEnlazada;

import java.util.Iterator;

public class ListaCircularDoblementeEnlazada<T extends Comparable<T>> implements Iterable<T> {
    private NodoDoble<T> nodoPrimero;
    private int tamanio;

    public ListaCircularDoblementeEnlazada() {
        nodoPrimero = null;
        tamanio = 0;
    }

    public boolean isEmpty() {
        return nodoPrimero == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void imprimirLista() {
        if (isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }

        NodoDoble<T> actual = nodoPrimero;
        System.out.print("Lista: ");
        do {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        } while (actual != nodoPrimero);
        System.out.println();
    }

    public void agregarInicio(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if (isEmpty()) {
            nodoPrimero = nuevo;
        } else {
            NodoDoble<T> ultimo = nodoPrimero.getAnterior();
            nuevo.setSiguiente(nodoPrimero);
            nuevo.setAnterior(ultimo);
            nodoPrimero.setAnterior(nuevo);
            ultimo.setSiguiente(nuevo);
            nodoPrimero = nuevo;
        }
        tamanio++;
    }

    public void agregarFinal(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if (isEmpty()) {
            nodoPrimero = nuevo;
        } else {
            NodoDoble<T> ultimo = nodoPrimero.getAnterior();
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(nodoPrimero);
            nodoPrimero.setAnterior(nuevo);
        }
        tamanio++;
    }

    public void agregarPorPosicion(int indice, T valor) {
        if (indice < 0 || indice > tamanio) return;

        if (indice == 0) {
            agregarInicio(valor);
            return;
        }
        if (indice == tamanio) {
            agregarFinal(valor);
            return;
        }

        NodoDoble<T> nuevo = new NodoDoble<>(valor);
        NodoDoble<T> actual = nodoPrimero;

        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }

        NodoDoble<T> anterior = actual.getAnterior();

        anterior.setSiguiente(nuevo);
        nuevo.setAnterior(anterior);

        nuevo.setSiguiente(actual);
        actual.setAnterior(nuevo);

        tamanio++;
    }

    public T obtenerValorNodo(int indice) {
        NodoDoble<T> nodo = obtenerNodo(indice);
        return nodo != null ? nodo.getDato() : null;
    }

    public NodoDoble<T> obtenerNodo(int indice) {
        if (!indiceValido(indice)) return null;

        NodoDoble<T> actual = nodoPrimero;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public int obtenerPosicionNodo(T valor) {
        if (isEmpty()) return -1;

        NodoDoble<T> actual = nodoPrimero;
        int indice = 0;
        do {
            if (actual.getDato().equals(valor)) return indice;
            actual = actual.getSiguiente();
            indice++;
        } while (actual != nodoPrimero);

        return -1;
    }

    public boolean indiceValido(int indice) {
        return indice >= 0 && indice < tamanio;
    }

    public void eliminarPrimero() {
        if (isEmpty()) return;

        if (tamanio == 1) {
            nodoPrimero = null;
        } else {
            NodoDoble<T> ultimo = nodoPrimero.getAnterior();
            nodoPrimero = nodoPrimero.getSiguiente();
            nodoPrimero.setAnterior(ultimo);
            ultimo.setSiguiente(nodoPrimero);
        }
        tamanio--;
    }

    public void eliminarUltimo() {
        if (isEmpty()) return;

        if (tamanio == 1) {
            nodoPrimero = null;
        } else {
            NodoDoble<T> ultimo = nodoPrimero.getAnterior();
            NodoDoble<T> penultimo = ultimo.getAnterior();
            penultimo.setSiguiente(nodoPrimero);
            nodoPrimero.setAnterior(penultimo);
        }
        tamanio--;
    }

    public void eliminar(T valor) {
        if (isEmpty()) return;

        NodoDoble<T> actual = nodoPrimero;
        do {
            if (actual.getDato().equals(valor)) {
                if (tamanio == 1) {
                    nodoPrimero = null;
                } else {
                    NodoDoble<T> anterior = actual.getAnterior();
                    NodoDoble<T> siguiente = actual.getSiguiente();

                    anterior.setSiguiente(siguiente);
                    siguiente.setAnterior(anterior);

                    if (actual == nodoPrimero) {
                        nodoPrimero = siguiente;
                    }
                }
                tamanio--;
                return;
            }
            actual = actual.getSiguiente();
        } while (actual != nodoPrimero);
    }

    public void modificarNodo(int indice, T nuevoValor) {
        NodoDoble<T> nodo = obtenerNodo(indice);
        if (nodo != null) {
            nodo.setDato(nuevoValor);
        }
    }

    public void ordenarLista() {
        if (tamanio <= 1) return;

        boolean cambiado;
        do {
            cambiado = false;
            NodoDoble<T> actual = nodoPrimero;
            for (int i = 0; i < tamanio - 1; i++) {
                NodoDoble<T> siguiente = actual.getSiguiente();
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
        nodoPrimero = null;
        tamanio = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            NodoDoble<T> actual = nodoPrimero;
            boolean primeraVez = true;

            @Override
            public boolean hasNext() {
                return actual != null && (primeraVez || actual != nodoPrimero);
            }

            @Override
            public T next() {
                T dato = actual.getDato();
                actual = actual.getSiguiente();
                primeraVez = false;
                return dato;
            }
        };
    }
}

