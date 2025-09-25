package ListasListaCircularSimple;

public class NodoCircular<T> {

    private T dato;
    private NodoCircular<T> next;

    public NodoCircular(T dato) {
        this.dato = dato;
        this.next = this; // Al inicio, el nodo se apunta a sí mismo
    }

    // Getter y Setter del dato
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    // Getter y Setter del siguiente nodo
    public NodoCircular<T> getNext() {
        return next;
    }

    public void setNext(NodoCircular<T> next) {
        this.next = next;
    }
}
