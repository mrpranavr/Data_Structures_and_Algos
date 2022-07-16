// Problem: The Number of ways to reach form top the bottom
// place in an n x m matrix using right and bottom motions

class MatrixPath {

    static int countWays(int n, int m) {
        if(n == 1 || m == 1){
            return 1;
        }

        return countWays(n-1,m) + countWays(n,m-1);
    }

    public static void main(String[] args){
        System.out.println(countWays(3,3));
    }
}

