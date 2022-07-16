public class RatMaze {
    static int N;

    static boolean solveRatUtil(int[][] maze, int x, int y, int[][] sol){
        if(x == N-1 && y == N-1 && maze[x][y] == 1){
            sol[x][y] = 1;
            return true;
        }

        if(isSafe(x,y, maze)){
            if(sol[x][y] == 1){
                return false;
            }

            sol[x][y] = 1;

            if(solveRatUtil(maze, x+1, y, sol)){
                return true;
            }

            if(solveRatUtil(maze, x, y+1, sol)){
                return true;
            }

            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    static boolean isSafe(int x, int y, int[][] maze){
        return (x>=0 && x < N && y>=0 && y < N && maze[x][y] == 1);
    }

    static void printSolution(int[][] sol){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean solveRat(int[][] maze){
        int[][] sol = new int[N][N];

        if(solveRatUtil(maze,0,0,sol) == false){
            System.out.println("No solution");
            return false;
        } else {
            printSolution(sol);
        }
        return true;
    }

    public static void main(String[] args){
        int maze[][] = { { 1, 0, 0, 0 ,0, 0},
                         { 1, 1, 0, 1, 0, 0},
                         { 0, 1, 0, 0, 0, 0},
                         { 1, 1, 1, 1, 0, 0},
                         { 0, 1, 0, 1, 0, 0},
                         { 0, 1, 0, 1, 1, 1},
                         };
 
        N = maze.length;
        solveRat(maze);
    }
}
