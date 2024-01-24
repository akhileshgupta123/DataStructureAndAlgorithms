package Arrays;
//2257. Count Unguarded Cells in the Grid
public class CountUnguardedCell {
    public static void main(String args[]){
        CountUnguardedCell obj = new CountUnguardedCell();
        int m = 4;
        int n = 6;
        int guards[][] = new int[][]{{0,0},{1,1},{2,3}};
        int walls[][] = new int[][]{{0,1},{2,2},{1,4}};

        int result = obj.countUnguarded(m,n,guards,walls);

        System.out.println(result);
    }

    private int countUnguarded(int m, int n, int[][] guards, int[][] walls){
        char[][] matrix = new char[m][n];
        int result = 0;
        for (int i = 0; i < guards.length; i++) {
            int guardRow = guards[i][0];
            int guardCol = guards[i][1];
            matrix[guardRow][guardCol] = 'G';
        }

        for (int i = 0; i < walls.length ; i++) {
            int wallRow = walls[i][0];
            int wallCol = walls[i][1];
            matrix[wallRow][wallCol] = 'W';
        }

        for (int i = 0; i < guards.length ; i++) {
            int currentRow = guards[i][0];
            int currentCol = guards[i][1] - 1;
            while (currentCol >= 0) {
                if (matrix[currentRow][currentCol] != 'W'
                        && matrix[currentRow][currentCol] != 'G') {
                    matrix[currentRow][currentCol] = 'R';
                } else {
                    break;
                }
                currentCol--;
            }
            currentRow = guards[i][0];
            currentCol = guards[i][1] + 1;
            while (currentCol < n ) {
                if (matrix[currentRow][currentCol] != 'W'
                        && matrix[currentRow][currentCol] != 'G') {
                    matrix[currentRow][currentCol] = 'R';
                } else {
                    break;
                }
                currentCol++;
            }


            currentRow = guards[i][0] - 1;
            currentCol = guards[i][1];
            while (currentRow >= 0) {
                if (matrix[currentRow][currentCol] != 'W'
                        && matrix[currentRow][currentCol] != 'G') {
                    matrix[currentRow][currentCol] = 'R';
                } else {
                    break;
                }
                currentRow--;
            }

            currentRow = guards[i][0] + 1;
            currentCol = guards[i][1];
            while (currentRow < m ) {
                if (matrix[currentRow][currentCol] != 'W'
                        && matrix[currentRow][currentCol] != 'G') {
                    matrix[currentRow][currentCol] = 'R';
                } else {
                    break;
                }
                currentRow++;
            }

        }


        for (int i = 0; i < m ; i++) {
            for (int j = 0; j <n ; j++) {
                if (matrix[i][j] != 'R' && matrix[i][j] != 'G' && matrix[i][j] != 'W') {
                    result++;
                }
            }
        }

        return result;
    }
}
