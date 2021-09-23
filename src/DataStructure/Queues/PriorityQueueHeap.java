// Priority Queue implementation using HEAP
package DataStructure.Queues;

/*
Methods that should be available
insert(p)
extractMax()
remove(i)
getMax()
changePriority(i,p)
// 45,31,20,14,7,12,18,11,7
            45
        31          20
    14     7   12      18
 11     7
 */
public class PriorityQueueHeap {
    private int arr[];
    private int size;
    private int numberOfItems;

    public PriorityQueueHeap(int size) {
        this.size = size;
        this.arr = new int[size];
        this.numberOfItems = -1;
    }

    // parent
    public int parent(int i){
        return (i-1)/2;
    }

    // left child
    public int leftChild(int i){
        return 2 * i + 1;
    }

    // right child
    public int rightChild(int i){
        return 2 * i + 2;
    }

    // percolate down
    public void shiftDown(int i){
        int max = i;
        if( leftChild(i) < size && arr[leftChild(i)] > arr[max])
            max = leftChild(i);
        if( rightChild(i) < size && arr[rightChild(i)] > arr[max])
            max = rightChild(i);

        if (max != i){
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            shiftDown(max);
        }
    }

    // shiftup
    public void shiftUp(int i){
        int temp = arr[i];
        while (i > 0 && arr[parent(i)] < temp){
            arr[i] = arr[parent(i)];
            i = parent(i);
        }
        arr[i] = temp;
    }

    // get max
    public int getMax(){
        return arr[0];
    }

    // extract max
    public int extractMax(){
        int max = arr[0];
        arr[0] = arr[numberOfItems];
        numberOfItems--;
        shiftDown(0);
        return max;
    }

    // changePriority
    public void changePriority(int i, int p){
        int oldPriority = arr[i];
        arr[i] = p;
        if (p > oldPriority)
            shiftUp(i);
        else shiftDown(i);
    }

    // insert
    public void insert(int p){
        numberOfItems++;
        arr[numberOfItems] = p;
        shiftUp(numberOfItems);
    }

    // remove the element from ith index
    public void remove(int i){
        // just increase the value of the element then place it at 0 then remove and then do the shift down operation
        int temp = getMax() + 1;
        arr[i] = temp;
        shiftUp(i);
        extractMax();
    }

    public void printQueue(){
        for (int n:arr
             ) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueueHeap queueHeap1 = new PriorityQueueHeap(10);
        queueHeap1.insert(7);
        queueHeap1.insert(17);
        queueHeap1.insert(27);
        queueHeap1.insert(14);
        queueHeap1.insert(37);
        queueHeap1.printQueue();
        System.out.println(queueHeap1.extractMax());
        queueHeap1.printQueue();
        queueHeap1.changePriority(2,39);
        queueHeap1.printQueue();
    }

}
