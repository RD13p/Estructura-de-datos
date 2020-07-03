/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlinkedlist;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 * @author VICTOR MANUEL
 */
public class DLinkedList<E> implements ListInterface<E> {

    private final DNode<E> top;
    private final DNode<E> bottom;
    private int numElements;

    public DLinkedList() {
        numElements = 0;
        top = new DNode<>(null);
        bottom = new DNode<>(null);
        top.next = bottom;
        bottom.prev = top;
    }

    @Override
    public void addFirst(E entry) {
        DNode<E> newNode = new DNode<>(entry);
        newNode.prev = top;
        newNode.next = top.next;
        top.next.prev = newNode;
        top.next = newNode;
        //newNode.next.prev = newNode;
        numElements++;
    }

    @Override
    public void addLast(E entry) {
        DNode<E> newNode = new DNode<>(entry);
        newNode.prev = bottom.prev;
        newNode.next = bottom;
        bottom.prev.next = newNode;
        bottom.prev = newNode;
        numElements++;
    }

    private DNode<E> getNode(int index) {
        DNode<E> n;
        if (index < numElements / 2) {
            n = top;
            int i = -1;
            while (i < index) {
                n = n.next;
                i++;
            }
        } else {
            n = bottom;
            int i = numElements;
            while (i > index) {
                n = n.prev;
                i--;
            }
        }
        return n;
    }

    @Override
    public void add(int index, E newEntry) {
        if (index < 0 || index > numElements) {
            throw new IndexOutOfBoundsException();
        }
        DNode<E> n = getNode(index);
        DNode<E> newNode = new DNode<>(newEntry);
        newNode.next = n;
        newNode.prev = n.prev;
        n.prev.next = newNode;
        n.prev = newNode;
        numElements++;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(numElements - 1);
    }

    @Override
    public E remove(int index) {
        checkRange(index);
        DNode<E> n = getNode(index);
        E data = n.data;
        n.prev.next = n.next;
        n.next.prev = n.prev;
        numElements--;
        return data;
    }

    private void checkRange(int index) throws NoSuchElementException {
        if (index < 0 || index >= numElements) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean remove(E entry) {
        int i = indexOf(entry);
        if (i >= 0) {
            remove(i);
            return true;
        }
        return false;
    }

    @Override
    public E getFirst() {
        return get(0);
    }

    @Override
    public E getLast() {
        return get(numElements - 1);
    }

    @Override
    public E get(int index) {
        checkRange(index);
        return getNode(index).data;
    }

    @Override
    public void set(int index, E entry) {
        checkRange(index);
        getNode(index).data = entry;
    }

    @Override
    public boolean contains(E entry) {
        return indexOf(entry) >= 0;
    }

    @Override
    public int indexOf(E entry) {
        DNode<E> i = top;
        int index = -1;
        while (i != null) {
            if (entry.equals(i.data)) {
                return index;
            }
            index++;
            i = i.next;
        }
        return -1;
    }

    @Override
    public void clear() {
        top.next = bottom;
        bottom.prev = top;
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
        E[] array = (E[]) new Object[numElements];
        DNode<E> i = top.next;
        int x = 0;
        while (i.next != null) {
            array[x++] = i.data;
            i = i.next;
        }
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

}
