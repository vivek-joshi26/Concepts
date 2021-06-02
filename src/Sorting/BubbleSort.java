package Sorting;
/*
10 6 1 7 3

6 10 1 7 3
6 1 10 7 3
6 1 7 10 3
6 1 7 3 10

1 6 7 3 10
1 6 7 3 10
1 6 3 7 10


1 6 3 7 10
1 3 6 7 10

1 3 6 7 10

It compares 2 adjacent elements
like in 1st Iteration of outer loop(i will run from 0 to 3, i.e. 4 times and inner loop will run from j =0 to 4-0=4) 10 and 6 will be compared and swapped then 10 and 1 will be compared and swapped, then 10 and 7 compared and swapped and 10 and 3 compared and swapped
Now for 2nd Iteration of outer loop(i will run from 1 to 3, i.e. 3 times and inner loop will run from j =0 to 4-1=3) 1 and 6 will be compared and no action taken, then 6 and 7 same case and finally 7 and 3 will be compared and swapped
Now for 3rd Iteration of outer loop(i will run from 2 to 3, i.e. 2 times and inner loop will run from j =0 to 4-2=2) 1 and 6 will be compared and no action, then 6 and 3 compared and swapped
Now for 4th Iteration of outer loop(i will run once for 3, and inner loop will run from j = 0 to 4-3 = 1) 1 and 3 will be compared and no action taken
 */


public class BubbleSort {


    void sort(int[] arr){
        int n = arr.length;
        for(int i = 0;i < n-1; i++){
            for(int j = 0; j < n-1-i; j++){

                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr [j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }

    // This can be optimized by maintaining a flag to see if there is no swap needed then the array is already in sorted order
    // because we are comparing 2 adjacent elements so if by the end of inner loop there are no swaps, the array is already sorted
    // so O(n) is the best time when array is sorted and for other cases it is O(n^2)
    void optimizedSort(int[] arr){
        boolean swapped;
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            swapped = false;
            for( int j = 0; j < n-1-i; j++){
                if( arr[j] > arr[j+1]){
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if( swapped == false)
                break;

        }
    }

    void print(int[] arr){
        for ( int a: arr
             ) {
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {6,1,7,3,2,1};
        BubbleSort obj1 = new BubbleSort();
        obj1.print(arr);
        obj1.sort(arr);
        obj1.optimizedSort(arr);
        obj1.print(arr);
    }
}
