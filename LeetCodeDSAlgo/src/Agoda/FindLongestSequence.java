package Agoda;
import java.util.*;
public class FindLongestSequence {
    public static void main(String args[]){
        int arr[] = new int[]{1, 94, 93, 1000, 5, 92, 78};
        int n = arr.length;

        FindLongestSequence obj = new FindLongestSequence();
        int result = obj.findLongestSequence(arr,n);

        System.out.println("the result is:"+result);
    }

    private int findLongestSequence(int arr[], int n){
        if(n==0)
            return 0;

        Arrays.sort(arr);

        int ans = 1;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {

                if (arr[i] - arr[i - 1] == 1) {
                    count += 1;
                }else {
                    ans = Math.max(ans, count);
                    count = 1;
                }

            }
        }


        return Math.max(ans, count);
    }
}
