/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

import java.util.LinkedList;

/**
 *
 * @author VICTOR MANUEL
 */
public interface Graph<E> {
    /**
     * Adds a new node to the graph
     *
     * @param element the value being added to the graph
     * @return true if the add operation was successful, false otherwise
     */
    boolean addNode(E element);

    /**
     * Adds a new edge between two nodes in the graph
     *
     * @param source the origin of the edge
     * @param destiny the destiny of the edge
     * @return true if the edge was successfully added, false otherwise
     */
    boolean addEdge(E source, E destiny);

    /**
     * Checks if an element is contained in the graph
     *
     * @param element the value being searched
     * @return true if the element is contained, false otherwise
     */
    boolean contains(E element);

    /**
     * Removes a node from the graph All edges containing the node are also
     * removed
     *
     * @param element the value being removed
     * @return true if the node was removed, false otherwise
     */
    boolean deleteNode(E element);

    /**
     * Removes an edge from the graph
     *
     * @param source the origin of the edge
     * @param destiny the destiny of the edge
     * @return true if the edge was removed, false otherwise
     */
    boolean deleteEdge(E source, E destiny);

    /**
     * Returns a LinkedList containing the neighboring values of the given
     * element
     *
     * @param element the value of the node
     * @return a LinkedList of neighboring values
     */
    LinkedList<E> neighbors(E element);
}
