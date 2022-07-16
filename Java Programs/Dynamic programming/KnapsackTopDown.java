

public class KnapsackTopDown {

    static int max(int i, int j){
        return (i>j) ? i : j;
    }

    static int knapsack(int W, int[] wt, int[] val, int n) {
        int i,j;
        int t[][] = new int[n+1][W+1];

        for(i = 0; i <= n; i++){
            for(j = 0; j <= W; j++){
                if(i == 0 || j== 0){
                    t[i][j] = 0;
                } else if (wt[i-1] <= j){
                    t[i][j] = max(val[i-1] + t[i-1][j - wt[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][W];
    }

    public static void main(String[] args){
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapsack(W, wt, val, n));
    }
}
