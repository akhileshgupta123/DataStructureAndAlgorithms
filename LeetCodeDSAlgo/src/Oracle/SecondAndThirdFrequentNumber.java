package Oracle;
import java.util.*;
//Find the max freq number in an array.? How to find the second max or 3rd max freq of number in the array
public class SecondAndThirdFrequentNumber {
    public static void main(String args[]){
        int arr[] = {40,50,30,40,40,50,30,30,30};
        int n = arr.length;

        SecondAndThirdFrequentNumber obj = new SecondAndThirdFrequentNumber();
        int result = obj.mostFrequent(arr,n);
        System.out.println(result);
    }

    public int mostFrequent(int arr[], int n){
        Map<Integer, Integer> hp =
                new HashMap<Integer, Integer>();

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>(){

        public int compare (Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2){
            return obj1.getValue() - obj2.getValue();
        }
        });





        for(int i = 0; i < n; i++){
            int key = arr[i];
            if(hp.containsKey(key)){
                int freq = hp.get(key);
                freq++;
                hp.put(key, freq);

            }else{
                hp.put(key, 1);
            }
        }

        int max_count = 0, res = -1;

        for(Map.Entry<Integer, Integer> item: hp.entrySet() ){

            if(max_count<item.getValue()){
                res = item.getKey();
                max_count = item.getValue();
            }

            if(pq.size()==3){
                if(pq.peek().getValue()<item.getValue()){
                    pq.poll();
                    pq.add(item);
                }
            }else{
                pq.add(item);
            }
        }

        System.out.println("final second frequent element"+pq.peek().getValue());
        System.out.println("final second frequent element"+pq.peek().getKey());

        return res;

    }
}
