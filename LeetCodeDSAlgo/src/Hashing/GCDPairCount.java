package Hashing;
import java.util.*;

public class GCDPairCount {
    public static void main(String args[]){
        GCDPairCount obj = new GCDPairCount();
        int A[] = new int[]{2, 2, 1, 7, 5, 3};
        int K = 4;
        long result = obj.countPairs(A,K);
        System.out.println("The count pair is :"+result);
    }

    private int gcd(int a, int b) {
        if(b % a == 0) return a;
        return gcd(b % a, a);
    }

    private long countPairs(int[] arr, int k) {
        long ans = 0;
        HashMap<Integer, Integer> fmap = new HashMap<Integer, Integer>();

        for (int val : arr) {

            int rem = val % k;

            int ofreq = fmap.getOrDefault(rem, 0);

            fmap.put(rem, ofreq + 1);
        }
        return ans;
    }
}
