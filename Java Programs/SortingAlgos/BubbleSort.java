import java.util.*;

class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {7,8,3,1,2};

        // Bubble sort
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j<arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    // Swap the elements
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        
    }
}