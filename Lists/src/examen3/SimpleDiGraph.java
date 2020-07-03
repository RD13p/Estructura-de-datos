/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen3;

import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author VICTOR MANUEL
 */
public class SimpleDiGraph<E> {

    // Clase privada interna que representa un nodo de un grafo
    // consistente de un dato, una lista de nodos vecinos y una bandera auxilar para recorridos
    private class Node<E> {

        E data;
        LinkedList<Node<E>> neighbors;

        public Node(E data) {
            this.data = data;
            neighbors = new LinkedList<>();
        }

        public void addNeighbor(Node<E> neighbor) {
            if (!neighbors.contains(neighbor)) {
                neighbors.add(neighbor);
            }
        }

        public LinkedList<Node<E>> getNeighbors() {
            return neighbors;
        }

        @Override
        public String toString() {
            return data.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Node<?> other = (Node<?>) obj;
            return Objects.equals(this.data, other.data);
        }

    }

    // Lista de nodos en el grafo
    LinkedList<Node<E>> nodes;

    // Constructor para crear un grafo vacio
    public SimpleDiGraph() {
        nodes = new LinkedList<>();
    }

    // Agrega un nodo al grafo
    public boolean addNode(E element) {
        Node<E> newNode = new Node(element);
        if (!nodes.contains(newNode)) {
            nodes.add(newNode);
            return true;
        }
        return false;
    }

    // Agrega un arco dirigido al grafo de source a destiny
    // Si source o destiny no son nodos en el grafo, crea dichos nodos
    public boolean addEdge(E source, E destiny) {
        Node<E> s = getNode(source);
        Node<E> d = getNode(destiny);
        if (s == null) {
            addNode(source);
            s = getNode(source);
        }
        if (d == null) {
            addNode(destiny);
            d = getNode(destiny);
        }
        s.addNeighbor(d);
        return true;
    }

    // Regresa referencia al nodo conteniendo element
    private Node<E> getNode(E element) {
        Node<E> node = new Node<>(element);
        int index = nodes.indexOf(node);
        if (index >= 0) {
            return nodes.get(index);
        } else {
            return null;
        }
    }

    // Indica si element esta contenido en el grafo
    public boolean contains(E element) {
        return getNode(element) != null;
    }

    // Regresa una lista con todos los vecinos de element
    public LinkedList neighbors(E element) {
        Node<E> n = getNode(element);
        return n.getNeighbors();
    }

    @Override
    public String toString() {
        String r = "DiGraph{\n";
        for (Node<E> n : nodes) {
            r += n.data + ": " + n.neighbors + "\n";
        }
        return r + '}';
    }

    // Implementa este metodo
    public int outDegree() {
        int vecinos = 0;
        for(Node <E> n : nodes){
            if(n.neighbors.size() > vecinos){
                vecinos = n.neighbors.size();
            }
        }
        return vecinos;
    }
}

