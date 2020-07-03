/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlinkedlist;

/**
 *
 * @author VICTOR MANUEL
 */
public class DNode<E> {
    
    E data;
    DNode<E> prev;
    DNode<E> next;
    
    public DNode(E data){
        this.data = data;
        prev = null;
        next = null;
    }
    
    @Override
    public String toString(){
        return data.toString();
    }
    
}
