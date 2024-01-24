package Hashing;
import java.util.*;
//358 : Rearrange String k Distance Apart
//Time complexity: O(nlogn) since we have to perform the poll and offer on the queue n times each given that there is n characters in s in total.
//Space complexity: O(26) = O(1)
public class ReArrangeString {
    public static void main(String args[]){
        ReArrangeString obj = new ReArrangeString();
        String s = "bbccaaad";
        int k = 2 ;
        String result = obj.rearrangeString(s, k);
        System.out.println(result);
    }

    public String rearrangeString(String s, int k){
        int len = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        System.out.println("here"+map);

        Queue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<Map.Entry<Character,Integer>>((a,b) -> {
            if (a.getValue() == b.getValue()) {
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue().compareTo(a.getValue());
        });

        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<Map.Entry<Character, Integer>>();

        maxHeap.addAll(map.entrySet());

        System.out.println("here"+maxHeap);

        StringBuilder sb = new StringBuilder();


        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            sb.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);
            waitQueue.offer(entry);
            if (waitQueue.size() < k) {
                continue;
            }
            Map.Entry<Character, Integer> front = waitQueue.poll();
            if (front.getValue() > 0) {
                maxHeap.offer(front);
            }
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }
}
