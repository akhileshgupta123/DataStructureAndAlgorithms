package Oracle;
import java.util.*;
//1636. Sort Array by Increasing Frequency
//Sort the array with max frequency first then by value
public class FrequencySort {
    public static void main(String args[]){
       //int[] arr = new int[]{1,1,5,5,6,7,8,9,6,5,1,1};

        List<Integer> arr
                = Arrays.asList(2, 5, 2, 8, 5, 6, 8, 8);
        int n = arr.size();


        int N = arr.size();
        Map<Integer, Integer> mpp
                = new HashMap<Integer,Integer>(); // val, freq
        for (int a : arr) {
            mpp.put(a, mpp.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>(){

            public int compare (Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2){
                if(obj2.getValue()== obj1.getValue()){
                    return obj1.getKey() - obj2.getKey();
                }else{
                    return obj2.getValue() - obj1.getValue() ;
                }

            }
        });


        for(Map.Entry<Integer, Integer> item: mpp.entrySet() ){
            pq.add(item);
        }

        int j = 0;

        int[] arrResult = new int[arr.size()];

        while (pq.size() > 0) {

            int val = pq.peek().getKey(); // val
            int freq = pq.peek().getValue(); // freq

            while (freq-- > 0) {
                arrResult[j] = val;
                j++;
            }

            pq.poll();

        }

        for(int i=0; i<arrResult.length; i++){
            System.out.println(arrResult[i]);
        }




    }
}
