package Arrays;
//1605. Find Valid Matrix Given Row and Column Sums
// Time complexity o(n)
public class FindMatrixWithSum {
    public static void main(String args[]){
        FindMatrixWithSum obj = new FindMatrixWithSum();
        int rowSum[] = new int[]{5,7,10};
        int colSum[] = new int[]{8,6,8};
        int result[][]= obj.populateMatrix(rowSum,colSum);

        for(int i=0; i<result.length; i++){
            for(int j=0; j<result[0].length; j++){
                System.out.print(result[i][j]+"  ");
            }
            System.out.println(" ");
        }
    }

    private int[][] populateMatrix(int row[], int col[]){
        int R = row.length;
        int C = col.length;
        int matrix[][] = new int[R][C];

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                /*int min = 0;


                if(row[r]<col[c]){
                    min = row[r];
                    row[r] = row[r]-min;
                    col[c] = col[c] -min;
                }else{
                    min = col[c];
                    col[c] = col[c]-min;
                    row[r] = row[r]-min;
                }


                matrix[r][c] = min;*/


                //if(row[r] == 0) break;
                //if(col[c] == 0) continue;

                matrix[r][c] = Math.min(row[r], col[c]);
                row[r] -= matrix[r][c];
                col[c] -= matrix[r][c];
            }

        }
        return matrix;
    }
}
