/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 * @author VICTOR MANUEL
 */
public class SimpleList<E> {

    private class Node<T> {

        public T data;
        public Node<T> next;

        public Node() {
            data = null;
            next = null;
        }

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<E> top;
    private int numberOfElements;

    public SimpleList() {
        numberOfElements = 0;
        top = new Node<>();
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param e the element to add
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e the element to add
     */
    public void addLast(E e) {
        add(numberOfElements, e);
    }

    /**
     * Inserts the specified element at the specified position in this list
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index
     * > size())
     */
    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> n = getNodeAt(index - 1);
        Node<E> newNode = new Node<>(element);
        newNode.setNext(n.getNext());
        n.setNext(newNode);
        numberOfElements++;
    }

    /**
     * Returns the node at the specified position in the list Sentinel node is
     * located at position -1
     *
     * @param index index of the node to return
     * @return the node at the specified position in the list
     */
    private Node<E> getNodeAt(int index) {
        Node<E> n = top;
        int i = -1;
        while (i < index) {
            n = n.getNext();
            i++;
        }
        return n;
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return remove(0);

    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return remove(numberOfElements - 1);
    }

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index
     * >= size())
     */
    public E remove(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> n = getNodeAt(index - 1);
        E d = n.getNext().getData();
        n.setNext(n.getNext().getNext());
        numberOfElements--;
        return d;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if
     * it is present. If this list does not contain the element, it is
     * unchanged. Returns true if this list contained the specified element (or
     * equivalently, if this list changed as a result of the call).
     *
     * @param e element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    public boolean remove(E e) {
        Node<E> n = top;
        while (n.getNext() != null) {
            if (e.equals(n.getNext().getData())) {
                n.setNext(n.getNext().getNext());
                numberOfElements--;
                return true;
            } else {
                n = n.getNext();
            }
        }
        return false;
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list.
     * @throws NoSuchElementException if this list is empty
     */
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return get(0);
        }
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return get(numberOfElements - 1);
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index
     * >= size())
     */
    public E get(int index) {
        return getNodeAt(index).getData();
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index
     * >= size())
     */
    public E set(int index, E element) {
        Node<E> n = getNodeAt(index);
        E d = n.getData();
        n.setData(element);
        return d;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param e element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     *
     * @param e element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     */
    public int indexOf(E e) {
        Node<E> n = top;
        int i = 0;
        while (n.getNext() != null) {
            n = n.getNext();
            if (e.equals(n.getData())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after
     * this call returns.
     */
    public void clear() {
        top.setNext(null);
        numberOfElements = 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return numberOfElements;
    }

    /**
     * Returns true if this collection contains no elements.
     *
     * @return true if this collection contains no elements
     */
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element). The returned array will be safe in
     * that no references to it are maintained by this list. (In other words,
     * this method must allocate a new array). The caller is this free to modify
     * the returned array. This method acts as a bridge between array-based and
     * collection-based APIs.
     *
     * @return an array containing all of the elements in this list in proper
     * sequence
     */
    public Object[] toArray() {
        Node<E> n = top;
        Object[] e = new Object[numberOfElements];
        int i = 0;
        while (n.getNext() != null) {
            n = n.getNext();
            e[i++] = n.getData();
        }
        return e;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

 /*
 * **********************************
 *    Implementa aqui tus metodos
 * **********************************
 * 
 */
 
 public SimpleList<E> intersect(SimpleList<E> anotherLst){
     SimpleList<E> newLst = new SimpleList<>();
     int s = numberOfElements;
     if (s < anotherLst.numberOfElements){
         s = anotherLst.numberOfElements;
     }
     
     for(int i = 0;  i<s;i++){
         if(anotherLst.contains(get(i)))
             newLst.addFirst(get(i));
     }
     
     return newLst;
 }
 
 public boolean superset(SimpleList<E> anotherLst){
     int check = 0;
     int s = numberOfElements;
     //if (s < anotherLst.numberOfElements){
         for(int i  = 0; i<s;i++){
             if(anotherLst.contains(get(i))){
                 check++;
             }
     //    }
         
         
     }
     
     return(check ==anotherLst.numberOfElements);
     
 }
 
 public void slice(int index){
       int j = 0;
        for(int i = 0; i<numberOfElements;i++){
            if(index > numberOfElements){
            throw new IndexOutOfBoundsException();
            }
            if(j<index){
                removeFirst();
                j++;
            } 
        }
 }
 
}
