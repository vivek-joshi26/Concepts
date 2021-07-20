// Remove duplicate elements from a sorted LinkedList
package DataStructure.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {


    // example= 1,2,2,3,3,3
    public LinkedList removeDL(LinkedList list){
        if(list == null)
            return null;

        LinkedList.Node temp1 = list.head;
        LinkedList.Node temp2 = temp1.next;

        while (temp2 != null){
            if(temp1.data == temp2.data){
                temp1.next = temp2.next;
                temp2 = temp1.next;
            }
            else {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        return list;

    }

    //remove duplicate from unsorted list
    public LinkedList removeDL1(LinkedList list){
        if(list == null)
            return null;
        Set<Integer> set = new HashSet<>();
        LinkedList.Node temp1 = list.head;
        set.add(temp1.data);
        LinkedList.Node temp2;
        while (temp1 != null){
            temp2 = temp1.next;
            if (temp2 == null)
                break;
            if(set.contains(temp2.data)){
                temp1.next = temp2.next;
            }
            else {
                set.add(temp2.data);
                temp1 = temp2;
            }
        }
        return list;
    }

    // return or print kth to last element
    public LinkedList.Node kElement(LinkedList list, int k){
        if (list == null || k < 0)
            return null;
        LinkedList.Node temp= list.head;
        LinkedList.Node temp1 = temp;
        int count = 1;
        while (count < k && temp.next != null){
            temp = temp.next;
            count++;
        }
        if (count != k)
            return null;

        while (temp.next != null){
            temp = temp.next;
            temp1 = temp1.next;
        }
        System.out.println(temp1.data);
        return temp1;
    }

    public static void main(String[] args) {
        LinkedList.Node n1 = new LinkedList.Node(3);
        LinkedList.Node n2 = new LinkedList.Node(2);
        LinkedList.Node n3 = new LinkedList.Node(1);
        LinkedList.Node n4 = new LinkedList.Node(3);
        LinkedList.Node n5 = new LinkedList.Node(2);
        LinkedList.Node n6 = new LinkedList.Node(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        LinkedList l1 = new LinkedList();
        l1.head = n1;
        RemoveDuplicates duplicates = new RemoveDuplicates();
        l1.printLL(l1);
        duplicates.kElement(l1,0);

       // duplicates.printLL(l1);
        LinkedList l2 = duplicates.removeDL1(l1);
        l1.printLL(l2);
        //duplicates.printLL(l2);

    }
}
