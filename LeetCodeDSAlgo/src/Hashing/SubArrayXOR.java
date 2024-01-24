package Hashing;
import java.util.*;
//Count the number of subarrays having a given XOR
public class SubArrayXOR {

    public static void main(String args[]){
        int arr[] = {4,2,2,6,4};
        int n = arr.length;
        int m = 6;
        calculateSubArrayXOR(arr,n,m);
    }

    private static long calculateSubArrayXOR(int arr[], int n, int m){
        long ans = 0;
        int xorArr[] = new int[n];
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
        xorArr[0] = arr[0];

        for(int i=1;i<n;i++){
            xorArr[i] = xorArr[i-1] ^ arr[i];
        }

        System.out.println(Arrays.toString(xorArr));
        for(int i=0;i<n; i++){


            int tmp = m ^ xorArr[i];

            System.out.println(tmp);
            if(mp.containsKey(tmp)){
                ans = ans+ (long)mp.get(tmp);
            }

            System.out.println("map element:"+mp.get(tmp));

            if (xorArr[i] == m)
                ans++;

            if(mp.containsKey(xorArr[i])){
                mp.put(xorArr[i], mp.get(xorArr[i]) + 1);
            }else{
                mp.put(xorArr[i], 1);
            }


        }
        System.out.println("after xor:"+ans);
        return ans;
    }
}
