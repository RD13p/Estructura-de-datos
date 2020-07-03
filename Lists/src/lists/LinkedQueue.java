/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 * @author VICTOR MANUEL
 * @param <E>
 */
public class LinkedQueue<E> implements QueueInterface<E> {
    
   private Node<E> firstNode, lastNode;
    private int numElements;
    
    public LinkedQueue(){
        numElements = 0;
        firstNode = null;
        lastNode = null;
    }

    @Override
    public void enqueue(E newEntry) {
        Node<E> newNode = new Node<>(newEntry);
        if(isEmpty()){
            firstNode = newNode;
        }else{
            lastNode.next = newNode;
        }
        lastNode = newNode;
        numElements++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        E element = firstNode.data;
        firstNode = firstNode.next;
        numElements--;
        return element;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        E element = firstNode.data;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public void clear() {
        numElements = 0;
        firstNode = null;
        lastNode = null;
    }

    @Override
    public E[] toArray() {
        @SuppressWarnings("unchecked")
        E[] queue = (E[])new Object[numElements];
        Node<E> n = firstNode;
        int i = 0;
        while(n != null){
            queue[i] = n.data;
            n = n.next;
            i++;
        }
        return queue;
    }
    
    @Override
    public String toString(){
        return Arrays.toString(toArray());
    }

    @Override
    public int size() {
        return numElements;
    }
   
}
