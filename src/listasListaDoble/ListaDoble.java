package listasListaDoble;
 public class ListaDoble<T extends Comparable<T>> {

    private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;
    private int size;

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    // ================= MÉTODOS DE AGREGAR =================
    public void agregarInicio(T dato) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }
        size++;
    }

    public void agregarFinal(T dato) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);
        if (cola == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
        size++;
    }

    public void agregarEnPosicion(int posicion, T dato) {
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (posicion == 0) {
            agregarInicio(dato);
            return;
        }
        if (posicion == size) {
            agregarFinal(dato);
            return;
        }
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);
        NodoDoble<T> actual = cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.siguiente;
        }
        nuevoNodo.siguiente = actual.siguiente;
        nuevoNodo.anterior = actual;
        actual.siguiente.anterior = nuevoNodo;
        actual.siguiente = nuevoNodo;
        size++;
    }

    // ================= MÉTODOS PEDIDOS =================

    // 1. obtenerValorNodo
    public T obtenerValorNodo(int posicion) {
        return obtenerNodo(posicion).dato;
    }

    // 2. obtenerNodo
    public static void main(String[] args) {
        
    } NodoDoble<T> obtenerNodo(int posicion) {
        if (!indiceValido(posicion)) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        NodoDoble<T> actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual;
    }

    // 3. obtenerPosicionNodo (devuelve índice de un valor)
    public int obtenerPosicionNodo(T valor) {
        NodoDoble<T> actual = cabeza;
        int index = 0;
        while (actual != null) {
            if (actual.dato.equals(valor)) {
                return index;
            }
            actual = actual.siguiente;
            index++;
        }
        return -1; // no encontrado
    }

    // 4. indiceValido
    public boolean indiceValido(int posicion) {
        return posicion >= 0 && posicion < size;
    }

    // 5. estaVacia
    public boolean estaVacia() {
        return size == 0;
    }

    // 6. eliminarPrimero
    public void eliminarPrimero() {
        if (estaVacia()) return;
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        }
        size--;
    }

    // 7. eliminarUltimo
    public void eliminarUltimo() {
        if (estaVacia()) return;
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cola = cola.anterior;
            cola.siguiente = null;
        }
        size--;
    }

    // 8. Eliminar dado el valor de un nodo
    public boolean eliminar(T valor) {
        NodoDoble<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(valor)) {
                if (actual == cabeza) {
                    eliminarPrimero();
                } else if (actual == cola) {
                    eliminarUltimo();
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                    size--;
                }
                return true; // eliminado
            }
            actual = actual.siguiente;
        }
        return false; // no encontrado
    }

    // 9. modificarNodo
    public void modificarNodo(int posicion, T nuevoValor) {
        NodoDoble<T> nodo = obtenerNodo(posicion);
        nodo.dato = nuevoValor;
    }

    // 10. ordenarLista (burbuja)
    public void ordenarLista() {
        if (size <= 1) return;
        boolean cambiado;
        do {
            cambiado = false;
            NodoDoble<T> actual = cabeza;
            while (actual.siguiente != null) {
                if (actual.dato.compareTo(actual.siguiente.dato) > 0) {
                    T temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;
                    cambiado = true;
                }
                actual = actual.siguiente;
            }
        } while (cambiado);
    }

    // 11. imprimirLista
    public void imprimirLista() {
        NodoDoble<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // 12. Iterator (clase interna)
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private NodoDoble<T> actual = cabeza;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                T dato = actual.dato;
                actual = actual.siguiente;
                return dato;
            }
        };
    }

    // 13. borrarLista
    public void borrarLista() {
        cabeza = null;
        cola = null;
        size = 0;
    }

    // ================= UTILIDADES =================
    public int size() {
        return size;
    }
}


    

