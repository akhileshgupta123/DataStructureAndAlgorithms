package Arrays;

import java.util.*;
public class BalanceSplit {

    public static void main(String args[]){
        BalanceSplit obj = new BalanceSplit();
        //int arr[] = {1, 5, 7, 1};
        int arr[] = {12, 7, 6, 7, 6};
        //int arr[] = {1,2,6,7};

        boolean status = obj.isBalanceSplitExist(arr);

        System.out.println("the status is:"+status);

    }

    private boolean isBalanceSplitExist(int arr[]){
        if(arr==null || arr.length==0)
            return false;

        int totalLeft = 0;
        int totalRight = 0;

        Arrays.sort(arr);
        int i=0;
        int j = arr.length-1;

        while(i<=j){
            totalRight = totalRight + arr[j--];
            while(i<=j && totalLeft<totalRight){
                totalLeft += arr[i++];
            }
        }

        return totalLeft == totalRight && arr[i - 1] < arr[j + 1];

    }
}
