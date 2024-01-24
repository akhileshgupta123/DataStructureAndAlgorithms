package Backtracking;
import java.util.*;
//1519. Number of Nodes in the Sub-Tree With the Same Label
//DFS | O(26*n)
public class SubTreeNodeDFS {
    public static void main(String args[]){
        SubTreeNodeDFS obj = new SubTreeNodeDFS();
        /*int n = 7;
        int edges[][] = new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        String labels = "abaedcd";*/

        int n = 5;
        int edges[][] = new int[][]{{0,1},{0,2},{1,3},{0,4}};
        String labels = "aabab";



        int[] result = obj.countSubTrees(n,edges,labels);
        for(int test:result){
            System.out.println(test);
        }

    }

    private int[] countSubTrees(int n, int[][] edges, String labels) {

        // Create Graph
        HashMap<Integer, List<Integer>> map = new HashMap<Integer,List<Integer>>();
        for(int i=0; i<edges.length; i++){
            if(map.containsKey(edges[i][0])){
                List<Integer> item = map.get(edges[i][0]);
                item.add(edges[i][1]);
            }else{
                List<Integer> item = new ArrayList<Integer>();
                item.add(edges[i][1]);
                map.put(edges[i][0],item);
            }
/*
            if(map.containsKey(edges[i][1])){
                List<Integer> item = map.get(edges[i][1]);
                item.add(edges[i][0]);
            }else{
                List<Integer> item = new ArrayList<Integer>();
                item.add(edges[i][0]);
                map.put(edges[i][1],item);
            }*/
            //map.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
            //map.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }

        int[] ans = new int[n];
        findNumOfNodesWithSameLabel(0, labels, map, -1, ans);

        return ans;
    }


    private int[] findNumOfNodesWithSameLabel(int rootNode, String labels, HashMap<Integer, List<Integer>> map, int parent, int[] ans){

        int[] count = new int[26];
        count[labels.charAt(rootNode) - 'a']++; // For the current node

        List<Integer> li = map.get(rootNode);
        if(li == null){ // There are no children for the current node
            ans[rootNode] = count[labels.charAt(rootNode) - 'a'];
            return count;
        }

        for(Integer node : li){
            //if(node == parent) continue;
            int[] countNode = findNumOfNodesWithSameLabel(node, labels, map, rootNode, ans);
            System.out.println("before start here for rootnode"+rootNode);
            for(int mm:countNode){
                System.out.println(mm);
            }
            sumCountArray(count, countNode);
        }

        ans[rootNode] = count[labels.charAt(rootNode) - 'a'];
        return count;
    }

    private void sumCountArray(int[] count, int[] countNode){
        for(int i=0; i<26; i++){
            count[i] += countNode[i];
        }
    }
}
