// rotate matrix by 90 degrees
public class Rotate2DArray {
    public static void main(String args[]){
        Rotate2DArray obj = new Rotate2DArray();
        int arr[][] =  new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};


        int row = 4;
        int col = 4;

        obj.rotateMatrix( arr);

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
                System.out.print( arr[i][j] + " ");
            System.out.print("\n");
        }


    }

    private void rotateMatrix( int matrix[][]){
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Flip horizontally (or you can flip vertically)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }

        }
    }
}
