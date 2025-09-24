package listasListasimple;

public class Node<T> {

    private T dato;

    private Node<T> next;

    public Node(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> nodoPrimero) {
        this.next = nodoPrimero;
    }

    

}
