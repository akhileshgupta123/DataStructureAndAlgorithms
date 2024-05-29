package Graph;
import java.util.*;
//947. Most Stones Removed with Same Row or Column
public class RemoveStone {
    public static void main(String args[]){
        int[][] stones = new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        //int[][] stones = new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}};

        RemoveStone obj = new RemoveStone();
        int result = obj.removeStone(stones);

        System.out.println(result);
    }

    private int removeStone(int[][] stones){
        int isIsolateStone = 0;
        Set<Integer> visited = new HashSet<Integer>();

        for (int i = 0; i < stones.length; i++) {
            if(visited.contains(i)){
                continue;
            }
            System.out.println("here"+i);
            isIsolateStone++;

            dfs(i, stones, visited);

            System.out.println("visited : "+visited.size());
        }



        return stones.length - isIsolateStone;
    }

    private void dfs(int id, int[][] stones, Set<Integer> visited){
        System.out.println("outer here id"+id);
        visited.add(id);
        for (int nextId = 0; nextId < stones.length; nextId++) {
            if (visited.contains(nextId))
                continue;


            System.out.println("inner here"+nextId);
            if (stones[id][0] == stones[nextId][0] ||
                    stones[id][1] == stones[nextId][1]) {
                dfs(nextId, stones, visited);
            }

        }
    }


}
