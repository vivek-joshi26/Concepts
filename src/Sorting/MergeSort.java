package Sorting;

public class MergeSort {


    //After the sort this merge method will be called.
    // which will create 2 arrays(left,right) with length equal to m-l+1 and r-m
    // then we will populate these arrays with values from arr from l+i and m+1+j
    // then we will compare individual elements from left and right arrays and we will place small array at position k(k = l at start)
    void merge(int arr[],int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i = 0; i < n1; i++)
            left[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2){

            if( left[i] <= right[j]){
                arr[k] = left[i];
                i++;
                k++;
            }
            else {
                arr[k] = right[j];
                j++;
                k++;
            }

        }
        while(i < n1){
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < n2){
            arr[k] = right[j];
            k++;
            j++;
        }

    }


    // sort method is used to call sort and merge method recursively by dividing the array into two halves
    // one half will be for l to m and the other one for m+1 to r, once it gets sorted a merge method will be called
    // by passing array l,m,r to combine the sorted data
    void sort(int arr[],int l, int r){
        if(l<r){
            int m = l + (r-l)/2;
            sort(arr,l,m);
            sort(arr,m+1,r);
            merge(arr,l,m,r);

        }
    }


    public static void main(String[] args) {
        MergeSort obj1 = new MergeSort();
        int[] arr = {11,15,16,7,4,19,1};
        obj1.sort(arr,0,arr.length-1);

        for (int a:arr
             ) {
            System.out.println(a);
        }
    }
}
