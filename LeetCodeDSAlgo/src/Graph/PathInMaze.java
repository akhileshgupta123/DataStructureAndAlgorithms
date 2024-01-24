package Graph;
import java.util.*;
//2077. Paths in Maze That Lead to Same Room
public class PathInMaze {
    public static void main(String args[]){
        int n = 5;
        int[][] corridor = new int[][]{{1,2},{5,2},{4,1},{2,4},{3,1},{3,4}};
        PathInMaze obj = new PathInMaze();
        int result = obj.numberOfPaths(n,corridor);
        System.out.println(result);
    }

    public int numberOfPaths(int n, int[][] corridors) {
        Map<Integer, Set<Integer>> graph = new HashMap<Integer,Set<Integer>>();

        for(int i=1; i<=n; i++){
            graph.put(i, new HashSet<Integer>());
        }

        for(int[] e:corridors){
            if(e[0]<e[1]) graph.get(e[0]).add(e[1]);
            else graph.get(e[1]).add(e[0]);


            //System.out.println(graph.get(e[0]));
        }

        for(Map.Entry<Integer, Set<Integer>> it:graph.entrySet()){
            System.out.println(it.getKey());
            System.out.println(it.getValue());
        }

        int ans = 0;
        for(int[] e:corridors){
            Set<Integer> s1 = graph.get(e[0]);
            Set<Integer> s2 = graph.get(e[1]);
            System.out.println("start");
            for(int k:s1){
                if(s2.contains(k)){
                    ans++;
                    System.out.println("when increases");
                }

            }
        }

        return ans;
    }


}
