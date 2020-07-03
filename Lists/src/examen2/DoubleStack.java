/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2;

/**
 *
 * @author VICTOR MANUEL
 */

import java.util.NoSuchElementException;

public class DoubleStack<T> {
    private final int SIZE;
    private T[] stack;
    private int t1, t2, numElements;

    @SuppressWarnings("unchecked")
    public DoubleStack(int size) {
        t1 = 0;
        SIZE = size;
        t2 = SIZE - 1;
        numElements = 0;
        stack = (T[]) new Object[SIZE];
    }

    public void push(int s, T entry) {
        if(t2-t1 < 0){throw new IndexOutOfBoundsException();} else {
        if(s == 1){
          t1++;
          stack[t1-1] = entry;
        } else { 
        if(s == 2){
          stack[t2] = entry;
          t2--;
        } }}
    }

    public T pop(int s) {
      T salida = null;
        if(s == 1){ 
            if(isEmpty(1)){throw new NoSuchElementException();} else {
            salida = stack[t1]; 
            t1--; 
            return salida; 
        }}
        else if(s == 2){
            if(isEmpty(2)){throw new NoSuchElementException();} else {
            salida =stack[t2]; 
            t2++;
            return salida; }
        
    }return salida;}
        
    
    public boolean isEmpty(int s){
        if(s==1)return t1==0;
        else return t2==SIZE-1;
    }
    
    @Override
    public String toString() {
        String str = "Stack1: ";
        for(int i=t1-1;i>=0;i--){
            str += stack[i] + " ";
        }
        str += "| Stack2: ";
        for(int i=t2+1;i<stack.length;i++){
            str += stack[i] + " ";
        }
        return str;
    }
}
