class NQueen {

    public static boolean isSafe(int[][] board, int row, int col, int N) {
        int i, j;

        // check for col
        for(i = 0; i < row; i++){
            if(board[i][col] == 1){
                return false;
            }
        }

        // check upper diagonal left
        for(i = row, j = col; i >= 0 && j >= 0; i--,j--){
            if(board[i][j] == 1){
                return false;
            }
        }

        // check for lower diagonal left
        for(i = row, j = col; i < N && j>=0; i++,j--){
            if(board[i][j] == 1){
                return false;
            }
        }

        return true;
    }

    public static boolean nqueen(int[][] board, int row, int n) {
        if(row >= n){
            displayBoard(board,n);
            return true;
        }

        for(int col = 0; col < n; col++){
            if(isSafe(board,row, col,n)){
                board[row][col] = 1;
                if(nqueen(board,row+1, n)){
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static void displayBoard(int[][] board, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                    System.out.print(board[i][j] + " ");
                }
            System.out.println();
            }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        nqueen(board,0,n);
    }
}