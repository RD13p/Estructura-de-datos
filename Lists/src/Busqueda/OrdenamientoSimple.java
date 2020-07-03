/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busqueda;

import java.util.Arrays;

/**
 *
 * @author VICTOR MANUEL
 */
public class OrdenamientoSimple {
    public static void main(String[] args) {
	Integer[] arr1 = { 4, 2, 7, 5, 9, 1, 9, 4 };
	Double[] arr2 = { 1.1, 2.0, 2.3, 4.5, 5.5, 0.0 };
	Integer[] arr3 = { 1, 2, 4, 6, 7, 13 };
	Integer[] arr4 = { 8, 1, 0, 33, 12, 17, 89, 5, 42, 23 };
        String[] arr5 = {"estan", "ahi", "me", "oyen", "me", "escuchan"};
	Integer[] arr6 = { 1, 34, 11, 18, 88, 6, 41, 22, 7, 2 };

        System.out.println("Checking original arrays:");
	System.out.println(Arrays.toString(arr1) + " is ordered? " + isOrdered(arr1));
	System.out.println(Arrays.toString(arr2) + " is ordered? " + isOrdered(arr2));
	System.out.println(Arrays.toString(arr3) + " is ordered? " + isOrdered(arr3));
	System.out.println(Arrays.toString(arr4) + " is ordered? " + isOrdered(arr4));
	System.out.println(Arrays.toString(arr5) + " is ordered? " + isOrdered(arr5));
	System.out.println(Arrays.toString(arr6) + " is ordered? " + isOrdered(arr6));
	
	System.out.println("\nTesting Selection Sort:");
	selectionSort(arr1);
	selectionSort(arr2);
        System.out.println(Arrays.toString(arr1) + " is ordered? " + isOrdered(arr1));
        System.out.println(Arrays.toString(arr2) + " is ordered? " + isOrdered(arr2));

	System.out.println("\nTesting Insertion Sort:");
        insertionSort(arr3);
        insertionSort(arr4);
        System.out.println(Arrays.toString(arr3) + " is ordered? " +isOrdered(arr3));
        System.out.println(Arrays.toString(arr4) + " is ordered? " +isOrdered(arr4));
    
        System.out.println("\nTesting Bubble Sort:");
        bubbleSort(arr5);
        bubbleSort(arr6);
        System.out.println(Arrays.toString(arr5) + " is ordered? " +isOrdered(arr5));
        System.out.println(Arrays.toString(arr6) + " is ordered? " +isOrdered(arr6));
  }
  
  public static <T extends Comparable<? super T>> void selectionSort(T[] a){
      int min;
      T aux;
      for(int i = 0; i<a.length-1;i++){
        min = i;
        for(int j = i+1; j<a.length;j++){
            if(a[j].compareTo(a[min]) < 0){
                min = j;
            }
        
        if(min != i){
            aux = a[min];
            a[min] = a[i];
            a[i] = aux;      
            }
        }
      }
  }
  
  public static <T extends Comparable<? super T>> void insertionSort(T[] a){
      T element;
      int j;
      for(int i = 1; i<a.length;i++){
          element = a[i];
          j = i;
          while(j>0 && a[j-1].compareTo(element) > 0){
              a[j] = a[j-1];
              j -= 1;
          }
          a[j] = element;
      }
  }
  
  public static <T extends Comparable<? super T>> void bubbleSort(T[] a){
      T aux;
      for(int i = 1; i<a.length;i++){
          for(int j = 0; j<a.length-i;j++){
              if(a[j].compareTo(a[j+1]) > 0){
                  aux = a[j];
                  a[j] = a[j+1];
                  a[j+1] = aux;
              }
          }
      }
  }
  
  public static <T extends Comparable<? super T>> boolean isOrdered(T[] a) {
      return isOrdered(a, 0);
  }
  
  public static <T extends Comparable<? super T>> boolean isOrdered(T[] a, int n) {
      if (a.length - 1 == n){  //caso base
        return true;
      }
      return a[n].compareTo(a[n + 1]) <= 0 && isOrdered(a, n + 1);
    } 
}
