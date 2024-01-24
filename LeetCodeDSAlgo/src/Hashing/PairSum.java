package Hashing;
import java.util.*;
//1. Two Sum
public class PairSum {

    public static void main(String args[]){

        //int arr[] = {1, 2, 3, 4, 3};
        int arr[] = {1, 5, 3, 3, 3};
        //int arr[] = {1, 5, 9, 11, 12};


        int k = 6;

        PairSum obj = new PairSum();
        int sum = obj.numberOfWays(arr,k);

        System.out.println("The sum of number of ways is :"+sum);

    }

    private int numberOfWays(int arr[], int k){
        int pairs=0;
        HashMap<Integer, List<Integer>> valloc = new HashMap<>();
        List<Integer> locs = null;

        for(int i=0; i<arr.length; i++){
            locs = valloc.get(arr[i]);
            if(locs==null){

                locs = new ArrayList<Integer>();
                locs.add(i);
                valloc.put(arr[i], locs);
            }else{
                locs.add(i);
            }
        }

        System.out.println("size is:"+valloc.size());

        for (int i = 0; i < arr.length; i++) {
            int val = Math.abs(k-arr[i]);
            locs = valloc.get(val);
            if (locs != null) {


                pairs += locs.size();
                if (val == arr[i]) {
                    System.out.println(val);
                    System.out.println("size"+locs.size());
                    pairs--;
                }
            }

        }
        return pairs / 2;
    }
}
