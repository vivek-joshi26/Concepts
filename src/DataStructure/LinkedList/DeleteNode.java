package DataStructure.LinkedList;

public class DeleteNode {

//1,1,2,5,3,1
    public void delete(LinkedList list,int data){

        while (list.head.data == data) {
                list.head = list.head.next;
        }
        LinkedList.Node temp1 = list.head;
        LinkedList.Node temp2 = temp1.next;
        while (temp2.next != null){
           if(temp2.data == data){
               temp1.next=temp2.next;
           }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if(temp2.data == data)
            temp1.next = null;
    }

    public static void main(String[] args) {
        LinkedList.Node n1 = new LinkedList.Node(4);
        n1.next = new LinkedList.Node(2);
        n1.next.next = new LinkedList.Node(3);
        n1.next.next.next = new LinkedList.Node(1);

        LinkedList l1 = new LinkedList();
        l1.head = n1;

        DeleteNode deleteNode = new DeleteNode();
        deleteNode.delete(l1,1);
        l1.printLL(l1);

    }
}
