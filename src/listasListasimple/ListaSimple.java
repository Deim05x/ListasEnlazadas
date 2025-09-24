package listasListasimple;

public class ListaSimple<T> {

    private Node<T> nodoPrimero;
    private int tamanio;

    public ListaSimple() {
        nodoPrimero = null;
        tamanio = 0;
    }

    public Node<T> getNodoPrimero() {
        return nodoPrimero;
    }

    public void setNodoPrimero(Node<T> nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void agregarInicio(T valor) {

        Node<T> newNode = new Node<T>(valor);
        newNode.setNext(nodoPrimero);
        nodoPrimero = newNode;
        tamanio++;

    }

    public boolean isEmpty() {
        return nodoPrimero == null;
    }

    public void agregarFinal(T valor) {
        Node<T> newNode = new Node<T>(valor);
        if (isEmpty()) {
            nodoPrimero = newNode;
        } else {
            Node<T> nodoAux = nodoPrimero;
            while (nodoAux.next != null) {
                nodoAux = nodoAux.next;
            }

            nodoAux.next = newNode;

        }
        tamanio++;
    }

    public void agregarPorPosicion(int indice, T valor) {
        int contador = 0;
        Node<T> newNode = new Node<T>(valor);
        Node<T> nodoAux = nodoPrimero;
        while (nodoAux.next != null) {
            if (indice == contador) {
                newNode.setNext(nodoAux.next);
                nodoAux.setNext(newNode);
                break;
            }
            contador++;
        }

    }

}
