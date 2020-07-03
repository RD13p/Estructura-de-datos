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
public interface ListInterface<E> {
    
    /**
     * Adds a new entry at the beginning of the list
     * @param entry the new element
     */
    void addFirst(E entry);
    
    /**
     * Adds a new entry at the end of the list
     * @param entry the new element
     */
    void addLast(E entry);
    
    /**
     * Adds a new entry at the specified position
     * @param index the position
     * @param entry the new element
     * @throws IndexOutOfBoundsException if the position is invalid 
     * (negative or greater than size)
     */
    void add(int index, E entry);
    
    /**
     * Removes the first element
     * @return the element that was removed
     * @throws NoSuchElementException if the list is empty
     */
    E removeFirst();
    
    /**
     * Removes the last element
     * @return the element that was removed
     * @throws NoSuchElementException if the list is empty
     */
    E removeLast();
    
    /**
     * Removes the element in the given position
     * @param index the position
     * @return the element was removed
     * @throws IndexOutOfBoundsException if the position is invalid 
     * (negative or greater than size)
     */
    E remove(int index);
    
    /**
     * Removes the first occurrence of the given element, if possible
     * @param entry the element to be removed
     * @return true if the element was removed, false otherwise
     */
    boolean remove(E entry);
    
    /**
     * Gets the first element of the list
     * @return the first element
     * @throws NoSuchElementException if the list is empty
     */
    E getFirst();
    
    /**
     * Gets the last element of the list
     * @return the last element
     * @throws NoSuchElementException if the list is empty
     */
    E getLast();
    
    /**
     * Gets the element at the given position
     * @param index the position
     * @return the element at index
     * @throws IndexOutOfBoundsException if the position is invalid 
     * (negative or greater than size)
     */
    E get(int index);
    
    /**
     * Replaces the existing element at the given position with a new entry
     * @param index the position
     * @param entry the new value
     * @throws IndexOutOfBoundsException if the position is invalid 
     * (negative or greater than size)
     */
    void set(int index, E entry);
    
    /**
     * Checks if the entry is contained in the list
     * @param entry the element to be looked for
     * @return true if the element is in the list, false otherwise
     */
    boolean contains(E entry);
    
    /**
     * Returns the index of the first occurrence of the given element
     * @param entry the element to be looked for
     * @return the index of the first occurrence of the element,
     * or -1 if the element is not in the list
     */
    int indexOf(E entry);
    
    /**
     * Removes every element of the list
     */
    void clear();
    
    /**
     * Returns the number of elements in the list
     * @return the number of elements in the list
     */
    int size();
    
    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();
    
    /**
     * Retrieves an array representation of the list
     * @return an array containing every element of the list
     * in the established order
     */
    E[] toArray();
    
}
