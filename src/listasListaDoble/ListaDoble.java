package listasListaDoble;

public class ListaDoble<T> {
    
    private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;
    private int size; 

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;  

    }

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



    
}
