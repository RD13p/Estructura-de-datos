/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busqueda;

/**
 *
 * @author VICTOR MANUEL
 */
import java.util.Arrays;

public class Busqueda {
    public static void main(String[] args) {
    Integer[] arr1 = { 4, 2, 7, 5, 9, 1, 9, 4 };
    Double[] arr2 = { 1.1, 2.0, 2.3, 4.5, 5.5 };
    String[] arr3 = {"ahi", "escuchan", "estan", "me", "oyen", "siempre"};

    System.out.println("Linear search in array1 = " + Arrays.toString(arr1));
	System.out.println("Search 2: " + linearSearch(arr1, 2)); //1
    System.out.println("Search 4: " + linearSearch(arr1, 4)); //0
    System.out.println("Search 1: " + linearSearch(arr1, 1)); //5
    System.out.println("Search 42: " + linearSearch(arr1, 42)); //-1
    
    System.out.println("Binary search in array2 = " + Arrays.toString(arr2));
    System.out.println("Search 1.1: " + binarySearch(arr2, 1.1)); //0
    System.out.println("Search 2.0: " + binarySearch(arr2, 2.0)); //1
    System.out.println("Search 2.3: " + binarySearch(arr2, 2.3)); //2
    System.out.println("Search 4.5: " + binarySearch(arr2, 4.5)); //3
    System.out.println("Search 5.5: " + binarySearch(arr2, 5.5)); //4
    System.out.println("Search 42.0: " + binarySearch(arr2, 42.0)); //-1
    
    System.out.println("Binary search in array3 = " + Arrays.toString(arr3));
    System.out.println("Search 'ahi': " + binarySearch(arr3, "ahi")); //0
    System.out.println("Search 'escuchan': " + binarySearch(arr3, "escuchan")); //1
    System.out.println("Search 'estan': " + binarySearch(arr3, "estan")); //2
    System.out.println("Search 'me': " + binarySearch(arr3, "me")); //3
    System.out.println("Search 'oyen': " + binarySearch(arr3, "oyen")); //4
    System.out.println("Search 'siempre': " + binarySearch(arr3, "siempre")); //4
    System.out.println("Search 'feliz': " + binarySearch(arr3, "feliz")); //-1

    try{
	    System.out.println("Search unordered: " + binarySearch(arr1, 1));
    }catch(IllegalArgumentException e){
	    System.out.println("Cannot perform binary search in unordered array!");
    }
  }
  
  public static <T> int linearSearch(T[] a, T item){
      int index = 0; 
      for (T a1 : a) {
          if(a1.equals(item)){
             return index;
          }
          else {
              index ++;
          }
        }
      return -1;
  }
  
  public static <T extends Comparable<? super T>> int binarySearch(T[] a, T item){
      int inicio = 0;
      int fin = a.length;
      int intermedio = 0;
      int indice = 0;
      T comparacion;
      boolean busqueda = false;
      
      if(isOrdered(a) == false){
          throw new IllegalArgumentException();
      } else {
      
      while(busqueda != true){
          intermedio = (int)((fin-inicio)/2)+inicio;
          comparacion = a[intermedio];
          if(item.compareTo(comparacion) == 0 ){
              indice = intermedio;
              busqueda = true;
          } else if(item.compareTo(comparacion) <0 && intermedio != fin){
              fin = intermedio;
          } else if((item.compareTo(comparacion) >0) && intermedio != inicio){ 
              inicio = intermedio;
          } else {
              indice = -1;
              busqueda = true;
          }
      }
      }
      
      return indice;
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
