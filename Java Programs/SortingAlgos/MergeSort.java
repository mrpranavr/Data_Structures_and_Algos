import java.util.*;

class MergeSort {

    public static int[] mergeSort(int[] arr,int start,int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1, end);
            merge(arr,start, mid,end);
        }

        return arr;
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while((i <= mid) && (j <= end)) {
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            }
            else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }

        while(i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        while(j <= end) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        for(int a = start; a< end+1; a++) {
            arr[a] = temp[a - start];
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,8,3,1,2,-1,-4,0};

        mergeSort(arr,0,arr.length -1);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}