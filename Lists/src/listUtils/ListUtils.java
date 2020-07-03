/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listUtils;
import java.util.Collections;
import java.util.LinkedList;
/**
 *
 * @author VICTOR MANUEL
 */
public class ListUtils{
        /**
     * Returns a new list without every nth element from the received list
     * @param <T> the data type of the list
     * @param lst the received list
     * @param n the nth elements to remove
     * @return a new list without every nth element
     */
    public static <T> LinkedList<T> removeNth(LinkedList<T> lst, int n) {
        LinkedList<T> newLst = new LinkedList<>(); // creamos una lista vacia
        int j = 1;
        for(int i = 0; i<lst.size();i++){
            if(j<n){
                newLst.add(newLst.size(),lst.get(i));
                j++;
            } else if(j == n){
               j = 1;
            }
        }
        // Itera sobre cada elemento de lst, usando dos contadores, i para la lista, j para contar nesimos
        // Solo agrega elemento de lst en posicion i cuando j < n
        // Si j == n, resetea j a 0 
        return newLst;
    }

    /**
     * Returns a new list containing alternating elements from the received lists
     * @param <T> the data types of the lists
     * @param lst1 the first list
     * @param lst2 the second list
     * @return a new list containing alternating elements from lst1 and lst2
     */
    public static <T> LinkedList<T> alternate(LinkedList<T> lst1, LinkedList<T> lst2) {
        LinkedList<T> newLst = new LinkedList<>(); // creamos una nueva lista vacia
        
        int x = lst1.size();
        
        if(lst1.size() < lst2.size()){
            x = lst2.size();
        }
        
        for(int i = 0; i<x;i++){
                if(lst2.size() <=i){
                  newLst.add(newLst.size(), lst1.get(i));
                } else if (lst1.size() <= i){
                  newLst.add(newLst.size(), lst2.get(i));
                } else {
                newLst.add(newLst.size(), lst1.get(i));
                newLst.add(newLst.size(), lst2.get(i));
        }}
            
        // Utiliza un ciclo para recorrer ambas listas al mismo tiempo
        // Agrega un elemento de lst1, después uno de lst2
        // Ten en cuenta que las listas pueden ser de tamaños distinto
        // De tal manera que si ya no hay elementos en una de las listas, agrega los restantes de la otra
        return newLst;
    }

    /**
     * Returns a new list containing all the elements from the received lists in ascending order
     * @param <T> the data type of the lists
     * @param lst1 the first sorted list
     * @param lst2 the second sorted list
     * @return a new sorted list containing all elements from both lists
     */
    public static <T extends Comparable<? super T>> LinkedList<T> concatenateSorted(LinkedList<T> lst1, LinkedList<T> lst2) {
        LinkedList<T> newLst = new LinkedList<>(); // creamos una nueva lista vacia
       
        newLst.addAll(lst1);
        newLst.addAll(lst2);
        Collections.sort(newLst);
        
        // Usa dos contadores, una para recorrer lst1, y otro para lst2
        // Mientras tengas elementos por procesar en ambas listas (i < lst1.size() y j < lst2.size())
        // Compara elementos de ambas listas (Usa el método compareTo para hacerlo)
        // Agrega el mas pequeño, ya sea lst1 o lst2
        // y actualiza el contador que corresponda, sumándole 1
        
        // En caso de que las listas sean de tamaño diferente
        // Revisa si todavia quedan elementos en lst1 o lst2 y agregalos
        return newLst;
    }

}