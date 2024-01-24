package Grind75;
//70. Climbing Stairs

//(O(2^n))
public class ClimbingStair {
    public static void main(String args[]){
        int n = 4;
        ClimbingStair obj = new ClimbingStair();
        int result = obj.climbStairs(n);

        System.out.println(result);
    }

    public int climbStairs(int n){
        if(n==0 || n==1){
            return 1;
        }

        return climbStairs(n-1) + climbStairs(n-2);
    }
}
