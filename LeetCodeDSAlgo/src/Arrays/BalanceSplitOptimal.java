package Arrays;

import java.util.*;
public class BalanceSplitOptimal {

    public static void main(String args[]){
        BalanceSplitOptimal obj = new BalanceSplitOptimal();

        int arr[] = {1,2,1,1,3};
        //int arr[] = {12, 7, 6, 7, 6};
        boolean result = obj.balanceSplitExist(arr);

        System.out.println("the result is :"+result);
    }

    private boolean balanceSplitExist(int arr[]){
        int len = arr.length;
        if(len==0)
            return false;

        Arrays.sort(arr);

        int totalSum = 0;
        int remaining = arr[len-1];

        for(int i=0; i< len-1; i++){
            totalSum += arr[i];
        }

        for(int i= len-2; i>=0;i--){
            if(totalSum== remaining && arr[i]<arr[i+1])
                return true;
            if(totalSum<remaining)
                break;

            totalSum -= arr[i];
            remaining += arr[i];
        }

        return false;
    }
}
