package Sorting;

public class InsertionSort {

    public void print(int[] arr){
        for (int element: arr
             ) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    public void sort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n ; i++){
            int j = i -1;
            int key = arr[i];

            while (j >= 0 && key < arr[j]){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }

    }

    public static void main(String[] args) {
        InsertionSort obj1 = new InsertionSort();
        int[] arr = {11,13,15,7,9,3};
        obj1.print(arr);
        obj1.sort(arr);
        obj1.print(arr);

    }
}
