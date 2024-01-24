package Backtracking;

public class NQueenProblem {
    final int N=4;
    public static void main(String args[]){

        NQueenProblem Queen = new NQueenProblem();
        Queen.solveNQ();
    }

    private void printSolutions(int board[][]){

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(" " + board[i][j]
                        + " ");

            }
            System.out.println();
        }
    }

    private boolean isSafe(int board[][], int row, int col){
        int i,j;

        for(i=0;i<col;i++){
            if(board[row][i]==1)
                return false;
        }

        for(i=row,j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 1)
                return false;
        }

        for(i=row,j=col; j>=0 && i<N; i++,j--){
            if(board[i][j] == 1)
                return false;
        }

        return true;

    }

    private boolean solveNQUtil(int board[][], int col){
        if(col>=N)
            return true;

        for (int i = 0; i < N; i++) {
            System.out.println("col is:"+col);
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                System.out.println("row :"+i);
                System.out.println("col :"+col);

                if (solveNQUtil(board, col + 1) == true)
                    return true;
                board[i][col] = 0;
            }
        }

        return false;
    }

    boolean solveNQ()
    {
        int board[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };

        if (solveNQUtil(board, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolutions(board);
        return true;
    }
}
