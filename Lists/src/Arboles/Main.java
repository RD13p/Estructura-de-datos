/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author VICTOR MANUEL
 */
public class Main {
    // Implementar
    
    private static <E extends Comparable<? super E>> BST<E> slimFast(BST<E> tree) {
        BST<E> salida = new BST<>();
        salida.add(tree.getLargest());
        tree.inOrder();
            for(E i : tree.inOrder()){
                if(i.compareTo(salida.getLargest()) < 0){
                     salida.add(i);
            }
        }
      return salida;
    }

    public static void main(String args[]) {

        BST<Integer> p = new BST<>();

        System.out.println("Insertando nodos.");

        Random r = new Random(42);
        for (int i = 0; i < 20; i++) {
            int n = r.nextInt(100);
            System.out.println("Añadiendo " + n);
            p.add(n);
        }

        System.out.println("\n***  Arbol con inserciones  *** \n");

        System.out.println("\nRecorrido en inOrden: " + p.inOrder());
        System.out.println("\nRecorrido en preOrden: " + p.preOrder());
        System.out.println("\nRecorrido en postOrden: " + p.postOrder());
        System.out.println("\nRecorrido en profundidad: " + p.breadthFirst());

        System.out.println("\n\n***  Probando metodos CONTIENE  *** \n");
        System.out.println("\nContiene el arbol el dato 30?: " + (p.contains(30) ? "SI" : "NO"));
        System.out.println("\nContiene el arbol el dato 48?: " + (p.contains(48) ? "SI" : "NO"));
        System.out.println("\nContiene el arbol el dato 56?: " + (p.contains(56) ? "SI" : "NO"));
        System.out.println("\nContiene el arbol el dato 1?: " + (p.contains(1) ? "SI" : "NO"));

        System.out.println("\nEl arbol tiene " + p.size() + " nodos y " + p.numLeaves() + " hojas.");

        System.out.println("\n\n***  Probando metodo HERMANO  *** \n");
        System.out.println("\nEl hermano de 2 es: " + p.getSibling(2));
        System.out.println("\nEl hermano de 9 es: " + p.getSibling(9));
        System.out.println("\nEl hermano de 63 es: " + p.getSibling(63));
        System.out.println("\nEl hermano de 56 es: " + p.getSibling(56));
        System.out.println("\nEl hermano de 76 es: " + p.getSibling(76));

        System.out.println("\n\n***  Probando metodo PADRE  *** \n");
        System.out.println("\nEl padre de 2 es: " + p.getParent(2));
        System.out.println("\nEl padre de 9 es: " + p.getParent(9));
        System.out.println("\nEl padre de 63 es: " + p.getParent(63));
        System.out.println("\nEl padre de 56 es: " + p.getParent(56));
        System.out.println("\nEl padre de 30 es: " + p.getParent(30));

        System.out.println("\n\n***  Probando metodos MAYOR y MENOR  *** \n");
        System.out.println("\nEl mayor dato del arbol es: " + p.getLargest());
        System.out.println("\nEl menor dato del arbol es: " + p.getLowest());

        System.out.println("\n\n***  Probando metodo ELIMINA  *** \n");
        p.remove(2);
        System.out.println("\nBorrando el 2 (nodo hoja): " + p.inOrder());

        p.remove(43);
        System.out.println("\nBorrando el 43 (nodo hoja): " + p.inOrder());

        p.remove(92);
        System.out.println("\nBorrando el 92 (nodo hoja): " + p.inOrder());

        p.remove(82);
        System.out.println("\nBorrando el 82 (nodo con un hijo): " + p.inOrder());

        p.remove(100);
        System.out.println("\nBorrando el 100 (nodo inexistente): " + p.inOrder());

        p.remove(63);
        System.out.println("\nBorrando el 63 (nodo con dos hijos): " + p.inOrder());

        p.remove(30);
        System.out.println("\nBorrando el 30 (nodo raiz): " + p.inOrder());

        System.out.println("\n\n***  Probando metodo CLEAR  *** \n");
        System.out.println("\nBorrando todos los datos del arbol... ");
        p.clear();

        System.out.println("\n\nInsertando el 85 (nodo raiz)... ");
        p.add(85);
        System.out.println("\nRecorrido en inOrden: " + p.inOrder());
        p.remove(85);
        System.out.println("\nBorrando el 85 (nodo raiz SIN hijos): " + p.inOrder());

        System.out.println("\nBorrando todos los datos del arbol... ");
        p.clear();

        System.out.println("\n\nInsertando el 36 (nodo raiz)... ");
        p.add(36);

        System.out.println("\nInsertando el 74 ... ");
        p.add(74);
        System.out.println("\nRecorrido en inOrden: " + p.inOrder());

        p.remove(36);
        System.out.println("\nBorrando el 36 (nodo raiz con hijo derecho): " + p.inOrder());

        System.out.println("\nBorrando todos los datos del arbol... ");
        p.clear();

        System.out.println("\nInsertando el 54 (nodo raiz)... ");
        p.add(54);
        System.out.println("\nInsertando el 22 ... ");
        p.add(22);
        System.out.println("\nRecorrido en inOrden: " + p.inOrder());
        p.remove(54);
        System.out.println("\nBorrando el 54 (nodo raiz con hijo izquierdo): " + p.inOrder());

        p.clear();
        System.out.println("\n\n***  Probando metodo SLIMFAST  *** \n");
        p.add(20);
        p.add(10);
        p.add(35);
        p.add(5);
        p.add(15);
        p.add(22);
        p.add(42);
        BST<Integer> slim = slimFast(p);
        System.out.println("\nAltura de árbol original: " + p.height());
        System.out.println("\nAltura de árbol adelgazado: " + slim.height());
    }
}
