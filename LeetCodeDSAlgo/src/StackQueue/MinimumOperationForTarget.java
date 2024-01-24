package StackQueue;
import java.util.*;
//2059. Minimum Operations to Convert Number
public class MinimumOperationForTarget {
    public static void main(String args[]){
        MinimumOperationForTarget obj = new MinimumOperationForTarget();
        int nums[] = new int[]{2,4,12};
        int start = 2;
        int goal = 12;
        int result = obj.getMinOperations(nums,start,goal);
        System.out.println("result is:"+result);
    }

    private int getMinOperations(int[] nums, int start, int goal){
        int res = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        q.offer(start);
        while(!q.isEmpty()){

            int size = q.size();
            for(int i = 0;i<size;i++){
                int val = q.poll();
                if(val == goal)
                    return res;

                if(val<0 || val>100 || set.contains(val))
                    continue;
                if(!set.contains(val))
                    set.add(val);


                System.out.println("value is :"+val);
                for(int num : nums){
                    q.offer(val + num);
                    q.offer(val - num);
                    System.out.println("num is :"+num);
                    System.out.println("xor is :"+(val^num));
                    q.offer(val ^ num);
                }

            }
            res++;
        }
        return -1;

    }
}
