/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * @author VICTOR MANUEL
 * @param <E>
 */
public class BST<E extends Comparable<? super E>> implements Tree<E> {
    
    TreeNode<E> root;
    int size;
    
    public BST(){
        root =  null;
        size = 0;
    }
    
    @Override
    public void add(E element) {
        root = add(element, root);
    }
    
    private TreeNode<E> add(E element, TreeNode<E> node){
        if(node == null){
            size ++;
            return new TreeNode<>(element);
        }
        int c = element.compareTo(node.data);
        if( c < 0){
            node.left = add(element, node.left);
        } else if(c > 0){
            node.right = add(element, node.right);
        }
        return node;
    }
    
    @Override
     public boolean contains(E element) {
        return contains(element, root);
    }

    private boolean contains(E element, TreeNode<E> node) {
        if (node == null) {
            return false;
        }
        int c = element.compareTo(node.data);
        if (c == 0) {
            return true;
        } else if (c < 0) {
            return contains(element, node.left);
        } else {
            return contains(element, node.right);
        }
    }
    
    @Override
     public void remove(E element) {
        root = remove(element, root);
    }

    private TreeNode<E> remove(E element, TreeNode<E> node) {
        if (node == null) {
            return null;
        }
        int c = element.compareTo(node.data);
        if (c < 0) {
            node.left = remove(element, node.left);
        } else if (c > 0) {
            node.right = remove(element, node.right);
        } else {
            if(node.isLeaf()){
                return null;
            }else if(!node.hasLeft()){
                return node.right;
            }else if(!node.hasRight()){
                return node.left;
            }else{
                node.data = successor(node);
                node.right = remove(node.data, node.right);
                // node.data = predecessor(node);
                // node.left = remove(node.data, node.left);
            }
            size--;
        }
        return node;
    }


    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public LinkedList<E> inOrder() {
        return inOrder(root);
    }
    
    private LinkedList<E> inOrder(TreeNode<E> node){
        LinkedList<E> lst = new LinkedList<>();
        if(node == null){
            return lst;
        }
        lst.addAll(inOrder(node.left));
        lst.add(node.data);
        lst.addAll(inOrder(node.right));
        return lst;
    }

    @Override
    public LinkedList<E> preOrder() {
        return preOrder(root);
    }
    
    private LinkedList<E> preOrder(TreeNode<E> node){
        LinkedList<E> lst = new LinkedList<>();
        if(node == null){
            return lst;
        }
        lst.add(node.data);
        lst.addAll(preOrder(node.left));
        lst.addAll(preOrder(node.right));
        return lst;
    }

    @Override
    public LinkedList<E> postOrder() {
        return postOrder(root);
    }
    
    private LinkedList<E> postOrder(TreeNode<E> node){
        LinkedList<E> lst = new LinkedList<>();
        if(node == null){
            return lst;
        }
        lst.addAll(postOrder(node.left));
        lst.addAll(postOrder(node.right));
        lst.add(node.data);
        return lst;
    }

    @Override
    @SuppressWarnings("unchecked")
    public LinkedList<E> breadthFirst() {
        LinkedList<TreeNode> fila = new LinkedList<>();
        LinkedList<E> lst = new LinkedList<>();
        fila.add(root);
        while(!fila.isEmpty()){
            @SuppressWarnings("unchecked")
            TreeNode<E> node;
            node = fila.removeFirst();
            if(node.hasLeft()){
                fila.add(node.left);
            }
            if(node.hasRight()){
                fila.add(node.right);
            }
            lst.add(node.data);
        }
        return lst;
    }

    @Override
    public E predecessor(TreeNode<E> element) {
        if(!contains(element.data)){
            throw new NoSuchElementException();
        }
        
        if(!element.hasLeft()){
            return null;
        }
        TreeNode<E> node;
        node = element.left;
        while(node.right != null){
            node = node.right;
        }
        return node.data;
    }

    @Override
    public E successor(TreeNode<E> element) {
        if(!contains(element.data)){
            throw new NoSuchElementException();
        }
        
        if(!element.hasRight()){
            return null;
        }
        TreeNode<E> node;
        node = element.right;
        while(node.left != null){
            node = node.left;
        }
        return node.data;
    }

    @Override
    public E getLargest() {
        TreeNode<E> node;
        node = root;
        while(node.right != null){
            node = node.right;
        }
        return node.data;
    }

    @Override
    public E getLowest() {
        TreeNode<E> node;
        node = root;
        while(node.left != null){
            node = node.left;
        }
        return node.data;
    }

    @Override
    public int numLeaves() {
        return numHojas(root);
    }
    
    private int numHojas(TreeNode<E> element){
        if(element ==  null){
            return 0;
        }
        if(element.isLeaf()){
            return 1+ numHojas(element.left) + numHojas(element.right);
        }
        
            return numHojas(element.left) + numHojas(element.right);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getSibling(E element) {
      TreeNode<E> node = root;
      TreeNode<E> parent = null;
        while(node != null){
            int c = element.compareTo(node.data);
            if (c > 0){
                parent = node;
                node = node.right;
            }else if(c < 0){
                parent = node;
                node = node.left;
            }else if (c == 0){
                break;
            }
        }
        
        if(parent.left == null || parent.right == null){
            return null;
        }
        
        if(node.data == parent.left.data){
            return parent.right.data;
        }else if(node.data == parent.right.data){
            return parent.left.data;
        }else{
            return null;
        }
    }

    @Override
    public E getParent(E element) {
       if(element == root.data){
            return null;
        }
        TreeNode<E> node = root;
        TreeNode<E> parent = null;
        while(node != null){
            int c = element.compareTo(node.data);
            if (c > 0){
                parent = node;
                node = node.right;
            }else if(c < 0){
                parent = node;
                node = node.left;
            }else if (c == 0){
                break;
            }
        }
        
        return parent.data;
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(TreeNode<E> node) {
        if (node == null) {
            return -1;
        }
        if (node.isLeaf()) {
            return 0;
        }
        return Math.max(1 + height(node.left), 1 + height(node.right));
    }
    
    
}
