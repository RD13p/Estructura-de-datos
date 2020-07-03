/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1;

/**
 *
 * @author VICTOR MANUEL
 */
 class Main {
    
    public static void main(String[] args) {
        SimpleList<Integer> a = new SimpleList<>();
        SimpleList<Integer> b = new SimpleList<>();
        SimpleList<Integer> c = new SimpleList<>();
        for (int i = 0; i < 10; i++) {
            a.addLast(i);
        }
        for (int i = 15; i > 5; i--) {
            b.addLast(i);
            c.addFirst(i);
        }
        for (int i = 0; i <= 5; i++){
            c.addFirst(i);
        }

        System.out.println("TESTING EXAM");
        System.out.println("*************");
        testIntersect(a, b);
        System.out.println();
        testSuperset(a, c);
        System.out.println();
        testSlice(a);
        System.out.println();

    }

    public static <T> void testIntersect(SimpleList<T> a, SimpleList<T> b){
        System.out.println("Testing Intersect");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a.intersect(b) = " + a.intersect(b));
    }
    
    public static <T> void testSuperset(SimpleList<T> a, SimpleList<T> b){
        System.out.println("Testing Superset");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a superset of b? " + a.superset(b));
        System.out.println("b superset of a? " + b.superset(a));
    }
    
    public static <T> void testSlice(SimpleList<T> a){
        System.out.println("Testing Slice");
        System.out.println("a = " + a);
        a.slice(5);
        System.out.println("After a.slice(5), a = " + a);
        a.slice(3);
        System.out.println("After a.slice(3), a = " + a);
        try{
            System.out.println("Attempting a.slice(3)");
            a.slice(3);
            System.out.println("After a.slice(3), a = " + a);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Exception!");
        }
    } 
}
