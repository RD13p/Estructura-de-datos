/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/**
 *
 * @author VICTOR MANUEL
 */
public class Node<E> {
    
    E data;
    Node<E> next;
    
    public Node(E data){
        this(data, null);
    }
    
    public Node(E data, Node<E> next){
        this.data = data;
        this.next = next;
    }
    
    @Override
    public String toString(){
        return data.toString();
    }
    
}
