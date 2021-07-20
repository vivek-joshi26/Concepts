package Sorting;

public class BinarySearch {

    // recursively
    public int binarySearch1(int[] arr, int low, int high, int data){
        if( low > high)
            return -1;
        int mid = (low + high)/2;
        if( arr[mid] == data)
            return mid;
        if (arr[mid] < data)
            return binarySearch1(arr, mid+1, high, data);
        else
            return binarySearch1(arr,low,mid-1,data);

       // return -1;
    }

    // iteratively
    public int binarySearch2(int[] arr, int data){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid]  == data)
                return mid;
            if (arr[mid] < data)
                low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {3,8,9,11,17};
        System.out.println(binarySearch.binarySearch1(arr,0,4,179));
        System.out.println(binarySearch.binarySearch2(arr,179));
    }

}
