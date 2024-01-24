package StackQueue;
import java.util.*;
//1429. First Unique Number (Medium)
public class FirstUnique {
    HashMap<Integer, Integer> map;
    Queue<Integer> queue;

    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        for (int num : nums) {
                      add(num);
                    }
            }

           public int showFirstUnique() {
               while (!queue.isEmpty()) {
                      int num = queue.peek();
                       int freq = map.get(num);
                      if (freq > 1) {
                              queue.poll();
                            } else {
                             return num;
                           }
               }
               return -1;
          }

          public void add(int value) {
               if (map.containsKey(value)) {
                      map.put(value, map.get(value) + 1);
               } else {
                      map.put(value, 1);
                      queue.add(value);
               }
          }
}
