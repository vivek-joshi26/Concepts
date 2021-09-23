// Priority Queue Implementation using Simple Array
package DataStructure.Queues;


/*
Methods that should be present-
1- add(int num) adds num to the queue
2- poll() removes the number with highest priority
3- peek() gives the number that is currently present at the peak
4- size() returns the size of the queue
5- bool isFull() returns true if queue is full else false
 */

public class PriorityQueue {

    private int MAX;
    private int[] arr;
    private int numberOfItems;

    public PriorityQueue(int MAX) {
        this.MAX = MAX;
        this.arr =  new int[MAX];;
        this.numberOfItems = 0;
    }

    // peek()
    public int peek(){
        return arr[numberOfItems - 1];
    }

    public int size(){
        return numberOfItems - 1;
    }

    public boolean isFull(){
        return numberOfItems - 1 == MAX;
    }

    public int poll(){
        //***************************************
        return arr[--numberOfItems];
    }

    public void add(int num){
        if(numberOfItems == 0){
            arr[numberOfItems] = num;
        }
        else {
            int i ;
            for( i = numberOfItems - 1; i >= 0 ; i--){
                if(arr[i] < num){
                    arr[i+1] = arr[i];
                }
                else {
                    break;
                }
            }
            arr[i + 1] = num;
        }
        numberOfItems++;
    }

    public void printPQ(){
        for (int n:arr
             ) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue queue1 = new PriorityQueue(10);
        queue1.printPQ();
        queue1.add(10);
        //System.out.println(queue1.peek());
        queue1.add(12);
        //System.out.println(queue1.peek());
        queue1.add(13);
        //System.out.println(queue1.peek());
        queue1.add(2);
        //System.out.println(queue1.peek());
        queue1.printPQ();
        System.out.println(queue1.poll());
        //System.out.println(queue1.peek());
        queue1.printPQ();
        queue1.add(3);
        System.out.println(queue1.poll());
        queue1.printPQ();
    }

}
