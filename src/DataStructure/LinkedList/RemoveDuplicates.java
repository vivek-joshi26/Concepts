// Remove duplicate elements from a sorted LinkedList
package DataStructure.LinkedList;

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

    public static void main(String[] args) {
        LinkedList.Node n1 = new LinkedList.Node(1);
        LinkedList.Node n2 = new LinkedList.Node(2);
        LinkedList.Node n3 = new LinkedList.Node(2);
        LinkedList.Node n4 = new LinkedList.Node(3);
        LinkedList.Node n5 = new LinkedList.Node(3);
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
       // duplicates.printLL(l1);
        LinkedList l2 = duplicates.removeDL(l1);
        l1.printLL(l2);
        //duplicates.printLL(l2);

    }
}
