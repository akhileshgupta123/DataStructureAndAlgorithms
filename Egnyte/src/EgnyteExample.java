import java.util.*;
public class EgnyteExample {

    //Write a java program to find if an integer array has any subarray with sum  = k
    //
    //sum = 7
    //
    //
    //int[] = {1,2,3,4, 5, 6,7}
    public static void main(String args[]){
        //int[] array = new int[]{7,1,2,3,4, 5, 6,7};
        int[] array = new int[]{1, -3,-4, 14, -1, 1,3, 4, -2, 2};
       // -3,-4, 14,
        //-3,-4, 14, -1, 1
        //-1, 1,3, 4
        //3 ,4
        //-1, 1,3, 4, -2, 2
        //3, 4, -2, 2


        //{}

        int sum = 7;

        int start = 0;

        //int counter = countSumK(array, sum);

        //Time Complexity: O(n3)
        //int counter = countSubArrayWithSumK(array,sum);

        //Time Complexity: O(n)
        //Space Complexity: O(1)
        int counter = countSubarraysWithSumKHashMap(array,sum);




        System.out.println("sub array counter"+counter);


    }

    public static int countSumK(int[] array, int sum ){

        int start = 0;

        int counter = 0;

        boolean isSynArrayExist = false;
        EgnyteExample obj = new EgnyteExample();

        for(int i=0; i<array.length; i++){
            start = i;
            isSynArrayExist = false;
            int sum_start = sum;
            sum_start = sum_start-array[i];
            if(isArrayFind(sum_start)){
                counter++;
                isSynArrayExist = true;
            }
            for(int j=i+1; j< array.length; j++){// j=6 i=5
                sum_start = sum_start-array[j];
                if(isArrayFind(sum_start)){

                    counter++;
                    isSynArrayExist = true;
                    break;
                }
                /*if(sum_start==0){
                    counter++;

                    break;
                }*/


            }
            isSynArrayExist = false;
        }

        return counter;

    }

    private static boolean isArrayFind(int sum){
        if(sum==0)
            return true;
        else
            return false;
    }


    public static int countSubArrayWithSumK(int[] a, int K){
        int n = a.length;
        int count = 0;
        for(int i=0;i<n; i++){
            for(int j=i; j<n; j++){
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += a[k];
                }
                count += (sum == K ? 1 : 0);

            }
        }
        return count;
    }

    public static int countSubarraysWithSumKHashMap(int[] a, int K) {
        int n = a.length;
        HashMap < Integer, Integer > hash = new HashMap <Integer,Integer > ();
        int count = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum == K) {
                count++;
                System.out.println("here start count");
            }

            if (hash.get(sum - K) != null) {
                System.out.println("inner count find sum"+(sum));
                System.out.println("inner count find"+(sum-K));
                count += hash.get(sum - K);
            }

            if (hash.get(sum) != null) {
                hash.put(sum, hash.get(sum) + 1);
            } else {
                hash.put(sum, 1);
            }

        }

        for(Map.Entry<Integer,Integer> itr: hash.entrySet()){
            System.out.println(itr.getKey());
            System.out.println(itr.getValue());
            System.out.println("==================");
        }
        return count;
    }
}
