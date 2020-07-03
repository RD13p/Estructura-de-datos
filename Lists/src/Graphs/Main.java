/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

/**
 *
 * @author VICTOR MANUEL
 */
public class Main {
    public static void main(String[] args) {
        boolean result;
        System.out.println("*** Testing GraphMatrix ***");
        GraphMatrix<Character> gm = new GraphMatrix<>(4);
        System.out.println(gm);
        System.out.println("");

        char[] chars = {'a', 'e', 'i', 'o', 'u'};
        for (char c : chars) {
            System.out.println("Adding node " + c);
            result = gm.addNode(c);
            System.out.println("Result: " + result);
            System.out.println(gm);
            System.out.println("");
        }
        System.out.println("\n** Adding edges **\n");
        System.out.println("Adding a-a");
        result = gm.addEdge('a', 'a');
        System.out.println("Result: " + result);
        System.out.println(gm.toString());
        System.out.println("");

        System.out.println("Adding a-e");
        result = gm.addEdge('a', 'e');
        System.out.println("Result: " + result);
        System.out.println(gm.toString());
        System.out.println("");

        System.out.println("Adding i-o");
        result = gm.addEdge('i', 'o');
        System.out.println("Result: " + result);
        System.out.println(gm.toString());
        System.out.println("");

        System.out.println("Adding a-b"); // Fail
        result = gm.addEdge('a', 'b');
        System.out.println("Result: " + result);
        System.out.println(gm.toString());
        System.out.println("");

        System.out.println("\n** Deleting edges **\n");
        System.out.println("Deleting edge a-e");
        result = gm.deleteEdge('a', 'e');
        System.out.println("Result: " + result);
        System.out.println(gm.toString());
        System.out.println("");
        
        System.out.println("Deleting edge e-i");
        result = gm.deleteEdge('e', 'i');
        System.out.println("Result: " + result);
        System.out.println(gm.toString());
        System.out.println("");

        System.out.println("\n** Deleting nodes **\n");
        System.out.println("Deleting node i");
        result = gm.deleteNode('i');
        System.out.println("Result: " + result);
        System.out.println(gm.toString());
        System.out.println("");
        
        System.out.println("Deleting node o");
        result = gm.deleteNode('o');
        System.out.println("Result: " + result);
        System.out.println(gm.toString());
        System.out.println("");

        System.out.println("Deleting node i");
        result = gm.deleteNode('i');
        System.out.println("Result: " + result);
        System.out.println(gm.toString());
        System.out.println("");

        System.out.println("\n** Adding nodes and edges after delete **\n");        
        System.out.println("Adding node u");
        result = gm.addNode('u');
        System.out.println("Result: " + result);
        System.out.println(gm);
        System.out.println("");

        System.out.println("Adding u-e");
        result = gm.addEdge('u', 'e');
        System.out.println("Result: " + result);
        System.out.println(gm.toString());
        System.out.println("");
    }
}
