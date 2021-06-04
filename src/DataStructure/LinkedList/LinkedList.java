package DataStructure.LinkedList;

public class LinkedList {
        Node head;

 public static class Node{
     public int data;
     public Node next;

     Node(int data){
         this.data = data;
         next = null;
     }

 }

    public void printLL(LinkedList list){
        LinkedList.Node temp = list.head;
        while (temp!= null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}
