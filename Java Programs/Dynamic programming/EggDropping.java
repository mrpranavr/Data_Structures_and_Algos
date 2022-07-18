public class EggDropping {

    static int eggDropRecursion(int n, int k){
        if(k == 1 || k == 0){
            return k;
        }

        if(n == 1){
            return k;
        }

        int min = Integer.MAX_VALUE;
        int res;

        for(int x = 1; x < k; x++){
            res = Math.max(eggDropRecursion(n-1, x - 1), eggDropRecursion(n, k-x));
            if(res < min){
                min = res;
            }
        }

        return min  + 1;
    }

    static int eggDropDynamic(int n, int k){
        int[][] floor = new int[n+1][k+1];

        for(int i = 1; i <= n; i++){
            floor[i][1] = 1;
            floor[i][0] = 0;
        }

        for(int i = 1; i <= k ;i++){
            floor[1][i] = i;
        }

        int res;

        for(int i = 2; i<= n; i++){
            for(int j = 2; j <= k; j++){
                floor[i][j] = Integer.MAX_VALUE;
                for(int x = 1; x <= j; x++){
                    res = 1+ Math.max(floor[i - 1][x - 1], floor[i][j - x]);
                    if(res < floor[i][j]){
                        floor[i][j] = res;
                    }
                }
            }
        }

        return floor[n][k];
    }
    
    public static void main(String[] args){
        int n = 2, k = 10;
        System.out.print("Minimum number of "
                         + "trials in worst case with "
                         + n + " eggs and " + k
                         + " floors is " + eggDropDynamic(n, k));
    }
}
