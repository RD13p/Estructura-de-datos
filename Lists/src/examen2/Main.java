/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Stack;
/**
 *
 * @author VICTOR MANUEL
 */
public class Main {
     /**
     * Si estas resolviendo el examen individualmente, cambia los valores de las
     * constantes SECCION al inciso del examen que vas a resolver ('a' o 'b').
     * Si estas trabajando en equipo, deja los valores como estan ('*').
     *
     */
    final static char SECCION1 = 'b';
    final static char SECCION2 = '*';

    /**
     * 1A
     */
    public static boolean isPrime(int n) {
        return false;
    }

    /**
     * 1B
     */
    public static boolean isPalindrome(String str) {
        if(str.length() == 0){return true;}
        if(str.length() == 1){return true;}
        if(str.charAt(0) == str.charAt(str.length()-1)){
            return isPalindrome(str.substring(1, str.length()-1));
        }
        return false;
    }

    /**
     * 2A
     */
    public static void stackShuffle(int[] a) {

    }

    /**
     * 2B
     */
    public static void fisherShuffle(int[] a) {
        Random r = new Random(42);
        int n = a.length;
        for(int i = n-1; i>0;i--){
          int j = r.nextInt(i+1);
            int apoyo = a[i]; 
            a[i] = a[j]; 
            a[j] = apoyo;
        }
    }

    public static void main(String[] args) {
        if (SECCION1 == 'a' || SECCION1 == '*') {
            System.out.println("\nTesting 1A");
            System.out.println("Is 7 prime? " + isPrime(7));
            System.out.println("Is 33 prime? " + isPrime(33));
            System.out.println("Is 2 prime? " + isPrime(2));
            System.out.println("Is 6 prime? " + isPrime(6));
        }
        if (SECCION1 == 'b' || SECCION1 == '*') {
            System.out.println("\nTesting 1B");
            System.out.println("Is 'anitalavalatina' a palindrome? " + isPalindrome("anitalavalatina"));
            System.out.println("Is 'a' a palindrome? " + isPalindrome("a"));
            System.out.println("Is 'aba' a palindrome? " + isPalindrome("aba"));
            System.out.println("Is 'aa' a palindrome? " + isPalindrome("aa"));
            System.out.println("Is 'abc' a palindrome? " + isPalindrome("abc"));
        }
        if (SECCION2 == 'a' || SECCION2 == '*') {
            System.out.println("\nTesting 2A");
            int[] a = {0, 1, 2, 3, 4, 5};
            System.out.println("Array before shuffle: " + Arrays.toString(a));
            stackShuffle(a);
            System.out.println("Array after shuffle: " + Arrays.toString(a));
            a = new int[]{100, 125, 358, 241, 265, 301, 330, 350};
            System.out.println("Array before shuffle: " + Arrays.toString(a));
            stackShuffle(a);
            System.out.println("Array after shuffle: " + Arrays.toString(a));
        }
        if (SECCION2 == 'b' || SECCION2 == '*') {
            System.out.println("\nTesting 2B");
            int[] a = {0, 1, 2, 3, 4, 5};
            System.out.println("Array before shuffle: " + Arrays.toString(a));
            fisherShuffle(a);
            System.out.println("Array after shuffle: " + Arrays.toString(a));
            a = new int[]{100, 125, 358, 241, 265, 301, 330, 350};
            System.out.println("Array before shuffle: " + Arrays.toString(a));
            fisherShuffle(a);
            System.out.println("Array after shuffle: " + Arrays.toString(a));
        }

        System.out.println("\nTesting 3");
        DoubleStack<Integer> ds = new DoubleStack<>(10);
        for (int i = 0; i < 7; i++) {
            System.out.println("Pushing into stack 1: " + i);
            ds.push(1, i);
            System.out.println(ds);
        }
        try {
            for (int i = 10; i < 15; i++) {
                System.out.println("Pushing into stack 2: " + i);
                ds.push(2, i);
                System.out.println(ds);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception thrown! Capacity exceeded.\n");
        }
        while (!ds.isEmpty(1)) {
            System.out.println("Popping stack 1: " + ds.pop(1));
            System.out.println(ds);
        }
        while (!ds.isEmpty(2)) {
            System.out.println("Popping stack 2: " + ds.pop(2));
            System.out.println(ds);
        }
        try {
            ds.pop(1);
        } catch (NoSuchElementException e) {
            System.out.println("Exception thrown! Nothing to pop.");
        }
    }
}
