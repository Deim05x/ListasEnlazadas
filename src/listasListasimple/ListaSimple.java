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

    public void imprimirLista() {
        Node<T> nodo = nodoPrimero;
        System.out.print("Lista: ");
        while (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            nodo = nodo.getNext();
        }
        System.out.println();
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

        if (indice == 0) {
            newNode.setNext(nodoPrimero);
            nodoPrimero = newNode;
            return;
        }

        while (nodoAux != null) {
            if (contador == indice - 1) {
                newNode.setNext(nodoAux.getNext());
                nodoAux.setNext(newNode);
                break;
            }
            contador++;
            nodoAux = nodoAux.getNext();
        }
    }

    public T obtenerValorNodo(int indice) {
        if (indice < 0) {
            System.out.println("El índice no puede ser negativo.");
        }

        int contador = 0;
        Node<T> nodoAux = nodoPrimero;

        while (nodoAux != null) {
            if (contador == indice) {
                return nodoAux.getDato();
            }
            nodoAux = nodoAux.getNext();
            contador++;
        }

        return null;
    }

    public Node<T> obtenerNodo(int indice) {
        int contador = 0;
        Node<T> nodoAux = nodoPrimero;

        while (nodoAux != null) {
            if (contador == indice) {
                return nodoAux;
            }
            nodoAux = nodoAux.getNext();
            contador++;
        }

        return null;
    }

    public int obtenerPosicionNodo(T valor) {
        int contador = 0;
        Node<T> nodoAux = nodoPrimero;

        while (nodoAux != null) {
            if (nodoAux.getDato().equals(valor)) {
                return contador;
            }
            nodoAux = nodoAux.getNext();
            contador++;
        }

        // si no se encontró el valor
        return -1;
    }


}
