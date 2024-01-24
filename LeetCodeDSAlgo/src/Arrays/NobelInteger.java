package Arrays;
import java.util.*;
public class NobelInteger {

    public static void main(String args[]){
        int arr[] = {1, 1, 3, 3};
        int res = findNobelInteger(arr);
        System.out.println("The nobek integer is:"+res);
    }

    private static int findNobelInteger(int arr[]){
        Arrays.sort(arr);
        int n = arr.length;

        for(int i=0; i<n-1;i++){
            if(arr[i]==arr[i+1])
                continue;

            if(arr[i] == n-i-1)
                return arr[i];

        }

        if(arr[n-1]==0)
            return arr[n-1];
        return -1;
    }
}
