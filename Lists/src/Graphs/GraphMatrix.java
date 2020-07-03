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
public class GraphMatrix<E> implements Graph<E> {
    
    //Two-dimensional boolean array representing edges on the graph
    private boolean[][] matrix;
    
    //Array containing the nodes in the graph
    private E[] nodes;
    
    //Current number of nodes in the graph
    int numNodes;
    
    @SuppressWarnings("unchecked")
    public GraphMatrix(int maxNodes){
        nodes = (E[]) new Object[maxNodes];
        matrix  = new boolean[maxNodes][maxNodes];
        numNodes = 0;
    }
    
    @Override
    public boolean addNode(E element) {
        if(numNodes < nodes.length && !contains(element)){
            for(int i = 0; i< nodes.length; i++){
                if(nodes[i] == null){
                    nodes[i] = element;
                    numNodes ++;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean addEdge(E source, E destiny) {
        int s = indexOf(source);
        int d = indexOf(destiny);
        if (s >= 0 && d >= 0) {
            matrix[s][d] = true;
            matrix[d][s] = true;
            return true;
        }
        return false;
    }
    
    private int indexOf(E element) {
        for(int i = 0; i < nodes.length; i++){
            if(nodes[i] != null && nodes[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public boolean deleteNode(E element) {
        for (E node : nodes) {
               deleteEdge(node, element);
           }
        
        if(contains(element)){
            for(int i = 0; i< nodes.length; i++){
                if(nodes[i] == element){
                    nodes[i] = null;
                    numNodes --;
                }
            }
        return true;
        }
        return false;
    }

    @Override
    public boolean deleteEdge(E source, E destiny) {
       int s = indexOf(source);
        int d = indexOf(destiny);
        boolean result = false;
        if (s >= 0 && d >= 0) {
            result = matrix[s][d] || matrix[d][s];
            matrix[s][d] = false;
            matrix[d][s] = false;
        }
        return result;
    }

    @Override
    public LinkedList<E> neighbors(E element) {
        int i = indexOf(element);
        LinkedList<E> neighbors = new LinkedList<>();
        if (i >= 0) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    neighbors.add(nodes[j]);
                }
            }
        }
        return neighbors;
    }
    
    @Override
    public String toString(){
        String headers = "\t\t";
        for (E n : nodes) {
            headers += n + "\t";
        }
        String edges = "";
        int i = 0;
        for (boolean[] m : matrix) {
            edges += nodes[i] + "\t|\t";
            for (boolean e : m) {
                edges += e ? "1\t" : "0\t";
            }
            i++;
            edges += "\n";
        }
        return headers + "\n" + edges;
    }
}
