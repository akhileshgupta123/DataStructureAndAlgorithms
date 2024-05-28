import java.util.LinkedList;
import java.util.Queue;
// how to implement the fill logic of ms paint. if its bounded, fill the bounded area. if its unbounded it should fill all the area leaving the boundry.
public class ServiceNow {
    public static void main(String[] args) {
        int[][]  paintPage1 = new int[10][10];
        //createBoundary(paintPage, colorCode)
        int[][] paintPage = {{0,0,0,1,0},
                {0,0,1,1,0},
                {0,0,0,1,0},
                {1,0,0,0,0}};
        int row = 1;
        int col = 1;
        int color = 2;
        int n = paintPage.length;
        int m = paintPage[0].length;
        int[][] ans =fillColor (paintPage, row, col, color);
        for(int i=0;i<paintPage.length;i++){
            for(int j=0;j<m;j++){
                System.out.print(paintPage[i][j]);
            }
            System.out.println();
        }

    }

    private static int[][] fillColor(int[][] paintPage, int rowfill, int colfill, int color) {
        int n = paintPage.length;
        int m = paintPage[0].length;
//        int vis[][] = new int[n][m];
        paintPage[rowfill][colfill] = color;
        Queue<Pair>  q = new LinkedList<>();
        q.add(new Pair(rowfill, colfill));

        int[] deltarow ={-1, 1, 0, 0};
        int[] deltacol ={0, 0, 1,-1};
        while (!q.isEmpty()){
            Pair p = q.poll();
            for(int i=0;i<4;i++){
                int newRow = p.row+deltarow[i];
                int newCol = p.col+deltacol[i];

                if(newRow>=0 && newRow <n && newCol >=0 && newCol <m && paintPage[newRow][newCol] != color && paintPage[newRow][newCol] == 0){
                    paintPage[newRow][newCol] = color;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }

        return paintPage;

    }
}

class Pair{
    int row;
    int col;
    Pair( int row, int col){
        this.row = row;
        this.col = col;
    }
}

