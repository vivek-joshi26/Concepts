package Sorting;

public class QuickSort {

    // Method just to swap to elements at position i and j
    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // it calls the partition method to get the index of the pivot element and then creates two arrays and calls quicksort recursively
    void quickSort(int[] arr, int l, int r){

        if(l<r){
            int pi = partition(arr,l,r);
            quickSort(arr,l,pi-1);
            quickSort(arr,pi+1,r);
        }
    }

    //It takes the last element as the pivot and then try to compare the elements starting from l index
    // whenever element at j index is smaller than pivot, it swaps jth index element with ith index one
    // such that by the end all the smaller elements than the pivot will be on left of pivot and greater ones will be on right.
    int partition(int[] arr, int l, int r){

        int pivot = arr[r];
        int i = l-1;

        for(int j = l; j <= r-1;j++){

            if(arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }
        // it places the pivot element at its right place
        swap(arr,i+1,r);
        return (i+1);
    }

    public static void main(String[] args) {
        QuickSort obj1 = new QuickSort();
        int[] arr = {34,17,9,1,19,100};
        obj1.quickSort(arr,0,arr.length-1);
        for (int a: arr
             ) {
            System.out.print(a+" ");
        }
    }
}
