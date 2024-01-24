package BinarySearch;
import java.util.*;
//LeetCode 2557. Maximum Number of Integers to Choose From a Range II
public class MaximumNumberIntegerSearch {
    public static void main(String args[]){
        int[] banned = new int[]{1, 3, 7};
        int n = 8;
        int maxSum = 21;

        MaximumNumberIntegerSearch obj = new MaximumNumberIntegerSearch();
        int result = obj.maxCount(banned,n,maxSum);
        System.out.println(result);
    }

    public int maxCount(int[] banned, int n, long maxSum) {
        Set<Integer> bannedSet = new HashSet<Integer>();
        for (int b : banned) {
            bannedSet.add(b);
        }

        int l = 1, r = n;

        while (l < r) {
            int m = (l + r + 1) / 2;

            if (getSum(bannedSet, m) > maxSum) {
                r = m - 1;
            }else{
                l = m;
            }
        }
        int count = 0;
        for (int b : bannedSet) {
            if (b <= l) {
                count++;
            }
        }
        return l - count;
    }

    private long getSum(Set<Integer> bannedSet, long m) {
        long sum = m * (m + 1) / 2;
        for (int b : bannedSet) {

            if (b <= m) {
                sum -= b;
            }
        }

        return sum;
    }
}
