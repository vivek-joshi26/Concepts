package Sorting;
/*
10 6 1 7 3

1 6 10 7 3
1 3 10 7 6
1 3 6 7 10
1 3 6 7 10

It starts by getting the minimum value from array and placing it at the start, then starts checking for the remaining elements one by one
1st Iteration of outer loop i goes from 0 to 3 and inner loop from 1 to 4 and  found the index minimum element of 1 at 2 so it swaps the element at i index with this(1 is replaced with 10)
2nd Iteration of i from 1 to 3 and inner from 2 to 4 adn found element 3 at 4th index so replaces it with the element at 1 index

 */
public class SelectionSort {

    void sort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int min_index = i;
            for (int j = i+1; j < n; j++){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }

    void print(int[] arr) {
        for (int a : arr
        ) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {6, 1, 7, 3, 2, 1};
        SelectionSort obj1 = new SelectionSort();
            obj1.print(arr);
            obj1.sort(arr);
            obj1.print(arr);
    }
}
