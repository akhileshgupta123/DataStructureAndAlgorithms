package Graph;
import java.util.*;
public class CycleDetection {
    public static void main(String args[]){
        int graph[][] = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};



        int n=graph.length;
        int vis[]=new int[n];
        int dfsVis[]=new int[n];
        boolean present_cycle[]=new boolean[n];

        CycleDetection obj = new CycleDetection();
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                obj.dfs(i,vis,dfsVis,graph,present_cycle);
            }
        }

        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(present_cycle[i]!=true){
                list.add(i);
            }
        }

        System.out.println(list);
    }


    public boolean dfs(int node,int vis[],int dfsVis[],int graph[][],boolean present_cycle[]){
        vis[node]=1;
        dfsVis[node]=1;


        for(int it:graph[node]){

            if(vis[it]!=1){
                if(dfs(it,vis,dfsVis,graph,present_cycle)==true){
                    return present_cycle[node]=true;
                }
            }
            else if(dfsVis[it]==1){
                return present_cycle[node]=true;
            }
        }

        dfsVis[node]=0;
        return false;

    }
}
