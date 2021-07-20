package DataStructure.Trees;

// A heap is a type of complete Binary tree.
// It can be min heap or max heap, meaning the root of each node will be less than its child or in case of max heap will be greater than its children
// Heap can be implemented using arrays or PriorityQueue(quite easy to implement using Priority queue)
// in arrays, parent/root node will be at (i-1)/2 position, left child will be at 2*i + 1, right child at 2*i + 2
public class Heap {
    public int[] array;
    public int count;
    public int capacity;
    public int heap_type;

    public Heap(int capacity, int heap_type) {
        this.capacity = capacity;
        this.heap_type = heap_type;
        this.count = 0;
        this.array = new int[capacity];
    }

    // Can be used to return the parent index of any position from the array
    public int Parent(int i){
        if(i <= -1 || i > this.count)
            return -1;
        return (i-1)/2;
    }

    // Can be used to return the left child of a given index element
    public int LeftChild(int i){
        int left = 2*i + 1;
        if( left >= this.count)
            return -1;
        return left;
    }

    // Can be used to return the right child of a given index element
    public int RightChild(int i){
        int right = 2*i + 2;
        if( right >= this.count)
            return -1;
        return right;
    }

    //Getting the maximum element, in case of max heap, in case of min heap also, it will return the minimum value
    public int GetMaximum(){
        if(this.count == 0)
            return -1;
        return this.array[0];
    }

    // Heapify, when we insert a new element in the heap, it may not satisfy the heap, in that case we need to adjust the positions of heap elements
    // We need to find the maximum value from its children and replace it with that
    // We do this on a index, function is called as PercolateDown
    public void PercolateDown(int i){
        int l,r,max;
        l = LeftChild(i);
        r = RightChild(i);
        if( l != -1 && this.array[l] > this.array[i])
            max = l;
        else max = i;
        if( r != -1 && this.array[r] > this.array[max])
            max = r;
        if(max != i){
            int temp = this.array[max];
            this.array[max] = this.array[i];
            this.array[i] = temp;
            PercolateDown(max);
        }

    }

    // Delete, removes the and the returns the first element
    // then replaces the first element with last one and calls the Heapify or PercolateDown method
    public int Delete(){
        if(this.count == 0)
            return -1;
        int data = this.array[0];
        this.array[0] = this.array[this.count - 1];
        this.count--;
        PercolateDown(0);
        return data;
    }

    // Inserting an element
    // Increase the heap size, keep the new element at the end of the heap, and heapify from bottom to up
    public void Insert(int data){
        this.count++;
        int i = this.count - 1;

        while ( i > 0 && data > this.array[(i-1)/2]){
                this.array[i] = this.array[(i-1)/2];
                i = (i-1)/2;
        }
        array[i] = data;
    }
}
