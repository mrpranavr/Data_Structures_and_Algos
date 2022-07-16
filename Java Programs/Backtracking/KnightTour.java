import java.util.*;

public class KnightTour {
    public static int N = 7;

    static boolean isSafe(int x, int y, int[][] board){
        return (x >= 0 && x < N && y>=0 && y<N && board[x][y] == -1);
    }

    static boolean solveKt(){
        int[][] board = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board[i][j] = -1;
            }
        }

        board[0][0] = 0;

        int[] xMove = {2,1,-1,-2,-2,-1,1,2};
        int[] yMove = {1,2,2,1,-1,-2,-2,-1}; 

        if(!solveKtUtil(0,0,1,board,xMove,yMove)){
            System.out.println("Solution doesn't exist");
            return false;
        } else {
            printSolution(board);
        }
        return true;
    }

    static void printSolution(int[][] board){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

    static boolean solveKtUtil(int x, int y, int movei,int[][] board, int[] xMove, int[] yMove){
        
        if(movei == N*N){
            return true;
        }

        for(int k = 0 ; k < 8; k++){
            int next_x = x + xMove[k];
            int next_y = y + yMove[k];
            if(isSafe(next_x, next_y, board)){
                board[next_x][next_y] = movei;
                if(solveKtUtil(next_x, next_y, movei+1, board, xMove, yMove)){
                    return true;
                } else {
                    board[next_x][next_y] = -1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        solveKt();
    }
}
