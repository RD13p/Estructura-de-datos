/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen3;

/**
 *
 * @author VICTOR MANUEL
 */
public class Main {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        System.out.println("***** Testing Tree *****");
        System.out.println("");
        SimpleBinaryTree<Integer> t1 = new SimpleBinaryTree<>(5);
        t1.insert(4, 5);
        t1.insert(7, 5);
        t1.insert(3, 4);
        t1.insert(6, 7);
        t1.insert(2, 3);
        System.out.println("t1: " + t1);
        System.out.println("");
        System.out.println("Testing mirror:");
        t1.mirror();
        System.out.println("ti Mirror: " + t1);
        System.out.println("");

        SimpleBinaryTree<Integer> t2 = new SimpleBinaryTree<>(6);
        t2.insert(9, 6);
        t2.insert(4, 6);
        t2.insert(11, 4);
        t2.insert(7, 4);
        t2.insert(15, 9);
        t2.insert(1, 9);
        System.out.println("t2: " + t2);
        System.out.println("");
        System.out.println("Testing mirror:");
        t2.mirror();
        System.out.println("t2 Mirror: " + t2);
    }

    private static void test2() {
        System.out.println("");
        System.out.println("***** Testing Graph *****");
        System.out.println("");
        SimpleDiGraph<Character> g1 = new SimpleDiGraph<>();
        g1.addEdge('A', 'B');
        System.out.println(g1);
        System.out.println("Graph g1 outDegree: " + g1.outDegree());
        g1.addEdge('B', 'E');
        g1.addEdge('B', 'F');
        g1.addEdge('B', 'H');
        System.out.println("");
        System.out.println(g1);
        System.out.println("Graph g1 outDegree: " + g1.outDegree());
        g1.addEdge('H', 'G');
        g1.addEdge('E', 'B');
        g1.addEdge('F', 'G');
        g1.addEdge('F', 'B');
        g1.addEdge('F', 'H');
        g1.addEdge('A', 'G');
        System.out.println("");
        System.out.println(g1);
        System.out.println("Graph g1 outDegree: " + g1.outDegree());
    }
}
