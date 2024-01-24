package Hashing;
import java.util.*;
public class LongestConsecutiveSequence {
    public static void main(String args[]){
        int arr[] = new int[]{1, 9, 3, 10, 4, 20, 2};
        int n = arr.length;
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        int result = obj.findLongestSequence(arr,n);
        System.out.println("result is :"+result);
    }

    private int findLongestSequence(int arr[], int n){
        Set<Integer> s = new HashSet<Integer>();
        int ans = 0;
        for(int i=0; i<n; i++){
            s.add(arr[i]);
        }

        for (int i = 0; i < n; i++){

            if(!s.contains(arr[i]-1)){
                int j = arr[i];
                while(s.contains(j))
                    j++;

                if(ans<j-arr[i])
                    ans = j - arr[i];
            }

        }

        return ans;

    }
}
