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
import java.util.Arrays;
import java.util.Stack;


class StacksEx1 {
  public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        for (int i = 10; i < 100; i += 10) {
            s1.push(i);
        }
        s1.push(20);
        s1.push(1000);
        s1.push(20);
        System.out.println("Testing remove");
        System.out.println("Stack = " + s1);
        removeAllInstances(s1, 20);
        System.out.println("Stack after removing every 20 = " + s1);

        System.out.println("\nTesting reverse");
        System.out.println("Stack = " + s1);
        reverse(s1);
        System.out.println("Stack after reverse = " + s1);

        System.out.println("\nTesting palindrome");
        Integer[] a1 = {1, 0, 0, 1, 1, 0, 0, 1};
        Character[] a2 = {'a', 'n', 'i', 't', 'a', 'l', 'a', 'v', 'a', 'l', 'a', 't', 'i', 'n', 'a'};
        System.out.println(Arrays.toString(a1) + " is palindrome? " + palindrome(a1));
        System.out.println(Arrays.toString(a2) + " is palindrome? " + palindrome(a2));
        a1[0] = 0;
        System.out.println(Arrays.toString(a1) + " is palindrome? " + palindrome(a1));
        
        System.out.println("\nTesting evaluatePosfix");
        System.out.println("2 4 / = " + evaluatePosfix("2 4 /"));
        System.out.println("2 4 + 3 / = " + evaluatePosfix("2 4 + 3 /"));
        System.out.println("2 3 4 * 5 * - = " + evaluatePosfix("2 3 4 * 5 * -"));
        System.out.println("2 3 4 ^ 5 / = " + evaluatePosfix("2 3 4 + ^ 5 /"));
        System.out.println("6 3 4 2 ^ * + 5 = " + evaluatePosfix("6 3 4 2 ^ * + 5 -"));

  }
  
  public static <E> void removeAllInstances(Stack<E> stk, E entry){
     Stack<E> stk1 = new Stack();
	  while(stk.empty()==false)
	  {
	  E last = stk.pop();
	  if(last.equals(entry) == false)
	  stk1.push(last);
	  }
	    
	  while(stk1.empty()==false)
	  {
	  E last2 = stk1.pop();
	  stk.push(last2);
	  }
  }
  
  public static <E> void reverse(Stack<E> stk){
     Stack<E> stk1 = new Stack();
     Stack<E> stk2 = new Stack();
     
     while(stk.empty() == false){
        E apoyo = stk.pop();
        stk1.push(apoyo);
     }
     
     while(stk1.empty() == false){
        E apoyo = stk1.pop();
        stk2.push(apoyo);
     }
     
     while(stk2.empty() == false){
        E apoyo = stk2.pop();
        stk.push(apoyo);
     }
  }
  
  public static <E> boolean palindrome(E[] a){
      Stack<E> noReversed = new Stack();
      
      for (E a1 : a) {
          noReversed.push(a1);
      }
      
      for(int i = 0; i<noReversed.size();i++){
          E apoyo = noReversed.pop();
          if(a[i] != apoyo){
              return false;
          }
      }
            
      return true;
  }
  
  public static double evaluatePosfix(String expression) {
      Stack valueStack = new Stack();
      Double operandOne;
      Double operandTwo;
      Double result;
      
      int n = 0;
      while(n!=expression.length()){
            for(int i = 0;i<expression.length();i++){
                char character = expression.charAt(i);
                n++;
                 
                
                 if(Character.isDigit(character)){
                    double v =  Character.getNumericValue(character);
                    valueStack.push(v);
                }else if(character == '+'){
                    operandTwo = (Double) valueStack.pop();
                    operandOne = (Double) valueStack.pop();
                    result = operandOne+operandTwo;
                    valueStack.push(result);
                }else if(character == '-'){
                    operandTwo = (Double) valueStack.pop();
                    operandOne = (Double) valueStack.pop();
                    result = operandOne-operandTwo;
                    valueStack.push(result);
                }else if(character == '*'){
                    operandTwo = (Double) valueStack.pop();
                    operandOne = (Double) valueStack.pop();
                    result = operandOne*operandTwo;
                    valueStack.push(result);
                }else if(character == '/'){
                    operandTwo = (Double) valueStack.pop();
                    operandOne = (Double) valueStack.pop();
                    result = operandOne/operandTwo;
                    valueStack.push(result);
                }else if(character == '^'){
                    operandTwo = (Double) valueStack.pop();
                    operandOne = (Double) valueStack.pop();
                    result = (double)Math.pow(operandOne, operandTwo);
                    valueStack.push(result);
                }
         }
      }
      return (double) valueStack.peek();
  }
  
}
