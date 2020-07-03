/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slinkedlist;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 * @author VICTOR MANUEL
 */
public class SLinkedList<E> implements ListInterface<E>{
    private Node<E> top;
    private int numElements;
    
    public SLinkedList(){
        this.top = new Node<>(null);
        numElements = 0;
    }

    @Override
    public void addFirst(E entry) {
        //Node<E> newNode = new Node<>(entry, top.next);
        Node<E> newNode = new Node<>(entry);
        newNode.next = top.next;
        top.next = newNode;
        numElements++;
    }

    @Override
    public void addLast(E entry) {
        Node<E> i = top; 
        while(i.next != null){
            i = i.next;
        }
        Node<E> newNode = new Node<>(entry);
        i.next = newNode;
        numElements++;
    }

    @Override
    // Actividad
    public void add(int index, E entry) {
      if(index > numElements || index < 0 ){
            throw new IndexOutOfBoundsException();
        }
        
        Node<E> newNode = new Node(entry);
        Node<E> i = top;
        
        if(isEmpty()){
            addFirst(entry);
        }else{
        
        int count = 0;
        while(count <= numElements){
            if(count == index){
                newNode.next = i.next;
                i.next = newNode;
                numElements++;
                break;
            }
            count++;
            i = i.next;
        }
        }
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        E element = top.next.data;
        top.next = top.next.next;
        numElements--;
        return element;
    }

    @Override
    // Actividad
    public E removeLast() {
      if(isEmpty()){
            throw new NoSuchElementException();
        }
        // Crear variable para no mover a top
        Node<E> i =top;
       // Buscamos hasta llegar al final 
       while(i.next.next != null){
           // Cambiamos el top al que sigue para seguir avanzando en la lista
           i = i.next;
       }
       E data = i.next.data;
       i.next= null;
       numElements--;
       return data;
    }

    @Override
    public E getFirst() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return top.next.data;
        
    }
    

    @Override
    // Actividad
    public E remove(int index) {
       if(index > numElements || index < 0 ){
            throw new IndexOutOfBoundsException();
        }
        
        Node<E> i = top;
        
        E data = null;
        int count = 0;
        while(count <= numElements){
            if(index == count){
                data = i.next.data;
                i.next = i.next.next;
                numElements--;
                
            }
            count++;
            i = i.next;
            
        }
        return data;
    }

    @Override
    // Actividad
    public boolean remove(E entry) {
       Node<E> i= top.next;
        int count=0;
        while(count<numElements){
            if(i.data.equals(entry)){
                remove(count);
                return true;
            }
            count++;
            i=i.next;
        }
        return false;
    }    

   

    @Override
    public E getLast() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node<E> i = top;
        while(i.next != null){
            i = i.next;
        }
        return i.data;
    }

    @Override
    // Actividad
    public E get(int index) {
         if(index > numElements || index < 0 ){
            throw new IndexOutOfBoundsException();
        }
        Node<E> i = top;
        E data = null;
        int count = 0;
        while(i.next !=null){
            if(index == count){
                data = i.next.data;
                break;
            }
            count++;
            i = i.next;
            
        }
        return data;
    }

    @Override
    // Actividad
    public void set(int index, E entry) {
        if(index > numElements || index < 0 ){
            throw new IndexOutOfBoundsException();
        }
        Node<E> i = top;
        Node<E> newEntry = new Node(entry);
        int count = 0;
        while(count <= numElements){
            if(index == count){
                newEntry.next = i.next.next;
                i.next = newEntry;
            }
            i = i.next;
            count++; 
        }
    }

    @Override
    // Actividad
    public boolean contains(E entry) {
        Node<E> i = top; 
        int count = 0;
        while(i.next != null){
            count ++;
            i = i.next;
            if(i.data == entry){
            return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E entry) {
        Node<E> i = top.next;
        int index = 0;
        while(i != null){
            if(i.data.equals(entry)){
                return index;
            }
            i = i.next;
            index++;
        }
        return -1;
    }

    @Override
    public void clear() {
        top.next = null;
        numElements = 0;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public E[] toArray() {
        @SuppressWarnings("unchecked")
        E[] arrayList = (E[]) new Object[numElements];
        Node<E> i = top.next;
        int index = 0;
        while(i != null){
            arrayList[index] = i.data;
            i = i.next;
            index++;
        }
        return arrayList;
    }
   
    @Override
    public String toString(){
        return Arrays.toString(toArray());
    }
    
    public void union(SLinkedList<E> otherLst){
        for(int i = 0;i<otherLst.numElements;i++){
            addLast(otherLst.get(i));
        }
    }
    
    public void reverse(){
     E[] reversible = toArray();
        int j = reversible.length-1;
        for(int i = 0; i < reversible.length;i++){
                set(i,reversible[j]);
                j--;
            }        
    }  
}

