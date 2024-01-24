package DynamicProgramming;

public class LongestIncreasingSequence {

    public static void main(String args[]){

        LongestIncreasingSequence obj = new LongestIncreasingSequence();

        int matrix[][] = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        int result = obj.longestIncreasingPath(matrix);

        System.out.println("result is :"+result);

    }

    private int longestIncreasingPath(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j =0; j<m;j++){
                dp[i][j] =  -1;
            }
        }

        int max = 0;

        for(int i =0; i< n ; i++){
            for(int j =0; j< m ; j++){
                dp[i][j] = getPathLength(i,j, matrix, dp);
                max = Math.max(max, dp[i][j]);
            }
        }


        return max;

    }

    private int getPathLength(int row, int col, int matrix[][], int dp[][] ){
        if(dp[row][col]!=-1)
            return dp[row][col];

        int[] rowDir = {0, 0, -1, 1};
        int[] colDir = {1, -1, 0, 0};

        dp[row][col] = 1 ;

        for(int i = 0; i< 4; i++){
            int newRow = row + rowDir[i];
            int newCol = col + colDir[i];
            if(newRow < matrix.length && newCol < matrix[0].length && newRow >=0 && newCol >= 0){

                if(matrix[row][col]< matrix[newRow][newCol]){
                    dp[newRow][newCol] = getPathLength(newRow, newCol, matrix, dp);
                    dp[row][col] = Math.max(dp[newRow][newCol] + 1,  dp[row][col] );
                }

            }

        }



        return dp[row][col];

    }
}
