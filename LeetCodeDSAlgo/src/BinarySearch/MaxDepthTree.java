package BinarySearch;
import java.util.*;
//1902. Depth of BST Given Insertion Order 
public class MaxDepthTree {

    public static void main(String args[]){
        MaxDepthTree obj = new MaxDepthTree();
        int arr[] = new int[]{2,1,4,3};
        int result = obj.maxDepthTree(arr);
        System.out.println("resukt is:"+result);
    }

    private int maxDepthTree(int order[]){
        TreeMap<Integer,Integer> depthMap = new TreeMap<Integer,Integer>();
        int maxDepth = 1;
        depthMap.put(order[0], 1);
        int length = order.length;

        for(int i=1; i < length; i++){
            int curr = order[i];
            Integer prev = depthMap.floorKey(curr);
            Integer next = depthMap.ceilingKey(curr);
            int currDepth = 0;

            System.out.println("prev:"+prev);
            System.out.println("next:"+next);
            if(prev!=null && next!=null){
                currDepth = Math.max(depthMap.get(prev), depthMap.get(next)) + 1;
            }
            else if (prev != null)
                currDepth = depthMap.get(prev) + 1;
            else
                currDepth = depthMap.get(next) + 1;

            depthMap.put(curr, currDepth);
            maxDepth = Math.max(maxDepth, currDepth);
        }
        return maxDepth;
    }
}
