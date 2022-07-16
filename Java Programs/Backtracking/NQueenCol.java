import java.util.*;

public class NQueenCol {

    public static int N = 4;

    static boolean isSafe(int row , int col, char[][] board){
        // horizontal
        for(int i = 0 ; i < col ; i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }

        // vertical
        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // upper left diagonal
        for(int i = row, j = col; i >= 0 && j >= 0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // lower left diagonal
        for(int i = row, j = col; i < N && j >= 0; i++, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    static void saveBoard(char[][] board, List<List<String>> allBoard){
        String row = "";
        List<String> newBoard = new ArrayList<>();

        for(int i = 0; i < N; i++){
            row = "";
            for(int j = 0 ; j < N; j++){
                if(board[i][j] == 'Q'){
                    row += 'Q';
                } else {
                    row += '.';
                }
            }
            newBoard.add(row);
        }

        allBoard.add(newBoard);
    }

    static void solveNQueen(char[][] board, List<List<String>> allBoards, int col){
        if(col == N){
            saveBoard(board, allBoards);
            return ;
        }
        
        for(int row = 0 ; row < N; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                solveNQueen(board, allBoards, col+1);
                board[row][col] = '.';
            }
        }
    }

    public static void main(String[] args){
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[N][N];
        solveNQueen(board, allBoards, 0);
        System.out.println(allBoards);
    }
}
