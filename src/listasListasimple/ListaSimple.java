package listasListasimple;

public class ListaSimple<T> {

    Node<T> nodoPrimero;
    int tamanio;

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

    public <T> void agregarInicio(T valor) {

        Node<T> newNode = new Node<T>(valor);
        newNode.setNext(nodoPrimero);
        nodoPrimero = newNode;
        size++;

    }

    public <T> boolean isEmpty() {
        return nodoPrimero = null;
    }

    public <T> void agregarFinal(T valor) {
        Node<T> newNode = new Node<T>(valor);
        if (isEmpty) {
            nodoPrimero = newNode;
        } else {
            Node<T> nodoAux = nodoPrimero;
            while (nodoAux.next != null) {
                nodoAux = nodoAux.next;
            }

            nodoAux.next = newNode;

        }
        size++;
    }

    public <T> void agregarPorPosicion(int indice, T valor) {
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
