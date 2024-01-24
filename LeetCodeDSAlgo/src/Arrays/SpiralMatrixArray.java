package Arrays;
import java.util.*;
//54. Spiral Matrix
public class SpiralMatrixArray {
    public static void main(String args[]){
        int a[][] = new int[][]{ { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };


        System.out.println(SpiralMatrixArray.spiralOrder(a));
    }

    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> ans = new ArrayList<Integer>();

        if (matrix.length == 0)
            return ans;


          int m = matrix.length;
          int n = matrix[0].length;


        int r1 = 0;
        int c1 = 0;
        int r2 = m - 1;
        int c2 = n - 1;

        while (ans.size() < m * n) {
            for (int j = c1; j <= c2 && ans.size() < m * n; ++j)
                ans.add(matrix[r1][j]);

            ++r1;
            for (int i = r1; i <= r2  && ans.size() < m * n; ++i)
                ans.add(matrix[i][c2]);
            --c2;


            for (int j = c2; j >= c1 && ans.size() < m * n; --j)
                ans.add(matrix[r2][j]);

            --r2;
            for (int i = r2; i >= r1 && ans.size() < m * n; --i)
                ans.add(matrix[i][c1]);

            ++c1;


        }
        return ans;
    }
}
