/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listUtils;
import java.util.LinkedList;

/**
 *
 * @author VICTOR MANUEL
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> lst1 = new LinkedList<>();
        LinkedList<Integer> lst2 = new LinkedList<>();
        for (int i = 0, j = 4; i < 10; i += 3, j += 2) {
            lst1.add(i);
            lst1.add(i + 1);
            lst2.add(j);
        }

        System.out.println("List 1: " + lst1);
        System.out.println("List 2: " + lst2);
        System.out.println("");

        System.out.println("**** Testing remove Nth ****");
        System.out.println("Removing 2nd from lst1: " + ListUtils.removeNth(lst1, 2));
        System.out.println("Removing 3rd from lst2: " + ListUtils.removeNth(lst2, 3));
        System.out.println("");

        System.out.println("**** Testing alternate ****");
        System.out.println("Alternate lst1, lst1: " + ListUtils.alternate(lst1, lst1));
        System.out.println("Alternate lst1, lst2: " + ListUtils.alternate(lst1, lst2));
        System.out.println("Alternate lst2, lst1: " + ListUtils.alternate(lst2, lst1));
        System.out.println("");

        System.out.println("**** Testing concatenate sorted ****");
        System.out.println("Concatenate sorted lst1, lst2: " + ListUtils.concatenateSorted(lst1, lst2));
  }

}
