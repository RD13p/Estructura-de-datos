/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slinkedlist;

/**
 *
 * @author VICTOR MANUEL
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("** TEST SINGLY-LINKEDLIST CLASS **");
        System.out.println("\t** USING INTEGERS **");
        SLinkedList<Integer> iList = new SLinkedList<>();
        
        System.out.println("Testing: addFirst(i | i >= 0 && i < 10) + toString");
        System.out.println(iList);
        for (int i = 0; i < 10; i++) {
            iList.addFirst(i);
            System.out.println(iList);
        }
        System.out.println();

        System.out.println("Testing: isEmpty + removeFirst + toString");
        System.out.println(iList);
        while (!iList.isEmpty()) {
            iList.removeFirst();
            System.out.println(iList);
        }
        System.out.println();

        System.out.println("Testing: addLast(i | i >= 0 && i < 10) + toString");
        System.out.println(iList);
        for (int i = 0; i < 10; i++) {
            iList.addLast(i);
            System.out.println(iList);
        }
        System.out.println();

        System.out.println("Testing: isEmpty + removeLast + toString");
        System.out.println(iList);
        while (!iList.isEmpty()) {
            iList.removeLast();
            System.out.println(iList);
        }
        System.out.println();

        System.out.println("Testing: add(2 * i | i >= 0 && i < 10) + toString");
        System.out.println(iList);
        for (int i = 0; i < 10; i++) {
            iList.add(i, i * 2);
            System.out.println(iList);
        }
        System.out.println();

        System.out.println("Testing: remove(6) + toString");
        System.out.println(iList);
        iList.remove(6);
        System.out.println(iList);
        System.out.println("Testing: remove(new Integer(6)) + toString");
        iList.remove(new Integer(6));
        System.out.println(iList);
        System.out.println();

        System.out.println("Testing: size + indexOf + get");
        for (int i = 0; i < iList.size(); i++) {
            System.out.println("Get element at index " + iList.indexOf(iList.get(i)) + ": " + iList.get(i));
        }
        System.out.println();

        System.out.println("Testing: size + contains");
        for (int i = 0; i < iList.size(); i++) {
            System.out.println("Is element " + i + " contained in the list? " + iList.contains(i));
        }
        System.out.println();

        System.out.println("Testing: getFirst + toString");
        System.out.println(iList);
        System.out.println(iList.getFirst());
        System.out.println();

        System.out.println("Testing: getLast + toString");
        System.out.println(iList);
        System.out.println(iList.getLast());
        System.out.println();

        System.out.println("Testing: set(3, 20) + toString");
        System.out.println(iList);
        iList.set(3, 20);
        System.out.println(iList);
        System.out.println();

        System.out.println("Testing: toArray");
        Object[] array = iList.toArray();
        if (array != null) {
            for (Object array1 : array) {
                System.out.print(array1 + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Testing: clear + toString");
        System.out.println(iList);
        iList.clear();
        System.out.println(iList);
        System.out.println();

        System.out.println("\t** USING STRINGS **");
        SLinkedList<String> strLinkedList = new SLinkedList<>();
        strLinkedList.addLast("Hello");
        strLinkedList.addLast("World");
        System.out.println(strLinkedList);
        strLinkedList.remove("World");
        System.out.println(strLinkedList);
        
        
        System.out.println("\t** Testing Extra Methods **");
        iList.clear();
        for(int i=0;i<10;i++){
            iList.addFirst(i);
        }
        System.out.println(iList);
        System.out.println("Testing: Reverse");
        iList.reverse();
        System.out.println(iList);
        System.out.println();
        
        SLinkedList<Integer> iList2 = new SLinkedList<>();
        for(int i=10;i<20;i++){
            iList2.addLast(i);
        }
        System.out.println("Testing: Union");
        iList.union(iList2);
        System.out.println(iList);
        System.out.println();
    }
}