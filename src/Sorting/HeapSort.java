package Sorting;

public class HeapSort {

    public void Heapify(int[] arr, int n, int i){
        // n size of heap, i is given index
        int l,r,max = i,temp;

        l = 2*i + 1;    // left child
        r = 2*i + 2;    // right child

        if( l < n && arr[l] > arr[max])
            max = l;
        if( r < n && arr[r] > arr[max])
            max = r;
        if( max != i){
            temp = arr[i];      // if any of this child is greater than the parent swap both
            arr[i] = arr[max];
            arr[max] = temp;

            Heapify(arr,n,max);     // recursively call Heapify for the subtree
        }

    }

    public void sort(int[] arr){
        int n = arr.length;
        // create a heap, by calling heapify for each parent starting from bottom towards top
        for( int i = (n/2)-1; i >= 0; i--)
            Heapify(arr,n,i);

        //after creating a heap, we need to extract element one by one from it
        for( int i = n-1; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            Heapify(arr,i,0);

        }
    }

    public void Print(int[] arr){
        for (int a: arr
             ) {
            System.out.print(a+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HeapSort obj1 = new HeapSort();
        int[]  arr = {3,2,4,1,5};
        System.out.println("Before heapifying the array");
        obj1.Print(arr);
        //obj1.Heapify(arr,arr.length,2);obj1.Heapify(arr,arr.length,1);obj1.Heapify(arr,arr.length,0);

        System.out.println("After heapifying the array");
        obj1.sort(arr);
        obj1.Print(arr);
    }
}
