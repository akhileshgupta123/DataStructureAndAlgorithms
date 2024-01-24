package Arrays;
// rotate 90 degree
public class RotateMatrix {
    public static void main(String args[]){
        int arr[][] =  new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        RotateMatrix obj = new RotateMatrix();
        int row = 4;
        int col = 4;

        obj.rotateMatrix(row, col, arr);

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
                System.out.print( arr[i][j] + " ");
            System.out.print("\n");
        }

    }

    private void rotateMatrix(int m, int n, int mat[][]){
        int row=0;
        int col=0;
        int prev,curr;

        while(row<m && col<n){

            prev = mat[row + 1][col];
            for(int i=col;i<n;i++){
                curr = mat[row][i];
                mat[row][i] = prev;
                prev = curr;
            }
            row++;

            for(int i=row;i<m;i++){
                curr= mat[i][n-1];
                mat[i][n-1] = prev;
                prev = curr;
            }

            n--;

            if (row < m){
                for(int i=n-1;i>=col; i--){
                    curr = mat[m-1][i];
                    mat[m-1][i] = prev;
                    prev = curr;
                }
            }
            m--;

            if(col<n){
                for(int i=m-1; i>=row;i--){
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;

                }

            }
            col++;

        }

    }
}
