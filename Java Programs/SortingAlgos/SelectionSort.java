import java.util.*;

class SelectionSort {
    
    public static int[] selectionSort(int[] arr){
        for(int i = 0; i<arr.length-1 ; i++) {
            int min = i;
            for(int j = i+1; j<arr.length ; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }

            if(min != i) {
                // swap
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {7,8,1,3,2,-1,-1,-4,0,1};
        int sorted_arr[] = selectionSort(arr);

        for(int i = 0; i<sorted_arr.length; i++){
            System.out.print(sorted_arr[i] + " ");
        }
    }
}