package DynamicProgramming;
import java.util.*;
public class ClimbingStair {
    Map<Integer, Integer> map = new HashMap<Integer,Integer>();
    public static void main(String args[]){
        ClimbingStair obj = new ClimbingStair();
        int result = obj.climbStairs(3);

        System.out.println(result);

        System.out.println(obj.map);
    }

    public int climbStairs(int n) {
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        if(map.containsKey(n))
            return map.get(n);
        int ans = climbStairs(n-1) + climbStairs(n-2);
        map.put(n, ans);
        return ans;
    }
}
