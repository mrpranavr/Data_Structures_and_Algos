public class Sudoku {
    public static int N = 9;

    static boolean isSafe(int[][] grid, int row, int col, int num){
        // check horizontal
        for(int i = 0; i <= 8; i++){
            if(grid[row][i] == num){
                return false;
            }
        }

        // check vertical
        for(int i = 0; i <= 8; i++){
            if(grid[i][col] == num){
                return false;
            }
        }

        // check 3x3 area
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(grid[startRow + i][startCol + j] == num){
                    return false;
                }
            }
        }

        return true;
    }

    static boolean solveSudoku(int[][] grid, int row, int col){
        if(row == N-1 && col == N){
            return true;
        }

        if(col == N){
            row++;
            col = 0;
        }

        if(grid[row][col] != 0){
            return solveSudoku(grid, row, col+1);
        }

        for(int num = 1; num <= 9; num++){
            if(isSafe(grid, row, col, num)){
                grid[row][col] = num;

                if(solveSudoku(grid, row, col+1)){
                    return true;
                }

                grid[row][col] = 0;
            }
        }

        return false;
    }

    static void printGrid(int[][] sol){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                         { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                         { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                         { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                         { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                         { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                         { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                         { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                         { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        if(!solveSudoku(grid, 0,0)){
            System.out.println("No solution found");
        } else {
            printGrid(grid);
        }
    }
}
