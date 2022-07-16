import java.util.*;

class InsertionSort {

    public static int[] insertionSort(int[] arr) {
        for(int i = 1; i<arr.length; i++) {
            int current = arr[i];
            int j = i-1;
            while(j>=0 && current < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = current;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {7,8,3,1,2,-1,-4,0};
        int[] sorted_arr = insertionSort(arr);

        for(int i = 0; i < sorted_arr.length; i++) {
            System.out.print(sorted_arr[i] + " ");
        }
    }
}