/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

/**
 *
 * @author VICTOR MANUEL
 */
public class TreeNode<E> {
    E data;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean isLeaf() {
        return !hasRight() && !hasLeft();
    }

    @Override
    public String toString() {
        return " " + data.toString();
    }
}
