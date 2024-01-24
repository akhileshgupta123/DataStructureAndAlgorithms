package SlidingWindow;
import java.util.*;
//862  : Shortest Subarray with Sum at Least K
//O(N)time
//O(N)space
public class ShortestSubArray {
    public static void main(String args[]){
        ShortestSubArray obj = new ShortestSubArray();
        int nums[] = new int[] {2,-1,2};
        int  k = 3;
        int result = obj.shortestSubarray(nums,k);
        System.out.println("the result is :"+result);
    }
    public int shortestSubarray(int[] A, int K) {
        int N = A.length, res = N + 1;
        int[] B = new int[N + 1];
        for (int i = 0; i < N; i++) {
            System.out.println(B[i]);
            B[i + 1] = B[i] + A[i];
            System.out.println("next:"+B[i+1]);
        }
        Deque<Integer> d = new LinkedList<Integer>();
        for (int i = 0; i < N + 1; i++) {
            System.out.println(d);
            while (d.size() > 0 && B[i] - B[d.getFirst()] >=  K) {
                System.out.println("first while"+ i);
                System.out.println("first while element"+ B[d.getFirst()]);
                res = Math.min(res, i - d.pollFirst());
            }
            while (d.size() > 0 && B[i] <= B[d.getLast()]) {
                System.out.println("second while"+ i);
                d.pollLast();
            }
            d.addLast(i);
        }

        return res <= N ? res : -1;
    }
}
