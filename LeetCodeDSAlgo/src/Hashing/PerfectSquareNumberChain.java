package Hashing;
import java.util.*;

/*
Q: perfect square of numbers chains to identify

        input : [2, 3, 4, 5, 6, 7, 8, 9, 16, 256 ]
        Expected output: [4, 16, 256] since this is the chain of perfect square of numbers in the list

 */
public class PerfectSquareNumberChain {
    public static void main(String args[]){
        int [] arr = {2, 3, 4, 5, 6, 7, 8, 9, 16, 256};
        Arrays.sort(arr);

        HashMap <Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(!mp.containsKey(arr[i])) {
                mp.put(arr[i], 0);
            }
            mp.put(arr[i], mp.get(arr[i])+1);
        }

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[i]);

            int next = temp.get(temp.size()-1)*temp.get(temp.size()-1);
            while(mp.containsKey(next)) {
                temp.add(next);
                next = temp.get(temp.size()-1)*temp.get(temp.size()-1);
            }

            if(temp.size() > 0) list.add(temp);
        }

        int max = 0, idx = -1;

        for(int i = 0; i < list.size(); i++) {
            int size = list.get(i).size();
            if(max < size) {
                max = size;
                idx = i;
            }
        }


        if(idx != -1) {
            for(int i = 0; i < list.get(idx).size(); i++) {
                System.out.print(list.get(idx).get(i) + " ");
            }
        }
    }
}
