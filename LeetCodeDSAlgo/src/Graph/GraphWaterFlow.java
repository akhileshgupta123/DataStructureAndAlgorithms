package Graph;
import java.util.*;

public class GraphWaterFlow {

    private static final int[] dirs = {0, 1, 0, -1, 0};
    public static void main(String args[]){

        GraphWaterFlow obj = new GraphWaterFlow();
        int matrix[][] = new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> result = obj.waterFlow(matrix);

        System.out.println(result);

    }


    public List<List<Integer>> waterFlow(int matrix[][]){
        if(matrix.length==0)
            return new ArrayList<>();

        final int m = matrix.length;
        final int n = matrix[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        Queue<int[]> qP = new LinkedList<>();
        Queue<int[]> qA = new LinkedList<>();

        boolean seenP[][] = new boolean[m][n];
        boolean seenA[][] = new boolean[m][n];

        for(int i=0;i<m; i++){
            qP.add(new int[]{i,0});
            qA.add(new int[]{i, n-1});
   
            seenP[i][0] = true;
            seenA[i][n-1] = true;
        }




        for(int j=0;j<n; j++){
            qP.add(new int[]{0,j});
            qA.add(new int[]{m-1, j});
            seenP[0][j] = true;
            seenA[m-1][j] = true;
        }

        bfs(matrix,qP, seenP);
        bfs(matrix,qA, seenA);


        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                if(seenP[i][j] && seenA[i][j])
                    ans.add(new ArrayList<>(Arrays.asList(i,j)));
            }
        }
        return ans;

    }

    private void bfs(int matrix[][], Queue<int[]> q, boolean seen[][]){

        while(!q.isEmpty()){

            int item[] = q.peek();
            final int i = item[0];
            final int j = item[1];
            q.poll();
            System.out.println("i:"+i);
            System.out.println("j:"+j);
            //System.out.println("length:"+q.size());
            final int h = matrix[i][j];

            //System.out.println("the h value is:"+h);

            for(int k=0; k<4; k++){
                final int x = i + dirs[k];
                final int y = j + dirs[k + 1];
                System.out.println("x:"+x);
                System.out.println("y:"+y);
                if (x < 0 || x == matrix.length || y < 0 || y == matrix[0].length)
                    continue;
                if (seen[x][y] || matrix[x][y] < h)
                    continue;
                q.add(new int[] {x, y});
                seen[x][y] = true;
                System.out.println("final element is"+x + y);
            }

        }

    }
}
