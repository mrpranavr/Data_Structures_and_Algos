public class SubsetSum {

    static boolean max(boolean a, boolean b){
        return a || b;
    }

    static boolean subsetSum(int[] arr, int W, int n){
        int i,j;
        boolean t[][] = new boolean[n+1][W+1];

        for(i = 0; i <= n; i++){
            t[i][0] = true;
        }

        for(j = 1; j<= W; j++){
            t[0][j] = false;
        }


        for(i = 1; i <= n; i++){
            for(j = 1; j <= W; j++){
                if(arr[i-1] <= j){
                    t[i][j] = max(t[i-1][j - arr[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][W];
    }
    
    public static void main(String[] args){
        int arr[] = {2,3,8,7,10};
        int W = 1;
        int n = arr.length;
        System.out.println(subsetSum(arr, W, n));
    }
}
