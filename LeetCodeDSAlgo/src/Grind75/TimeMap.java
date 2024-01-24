package Grind75;
import java.util.*;
//981. Time Based Key-Value Store
public class TimeMap {
    private HashMap<String, ArrayList<Pair>> hashMap;

    public TimeMap() {
        hashMap = new HashMap<>();
    }

    public static void main(String args[]){
        TimeMap obj = new TimeMap();
        obj.set("foo", "bar", 1);
        String result = obj.get("foo", 1);
        System.out.println(result);
        result = obj.get("foo", 3);
        System.out.println(result);
        obj.set("foo", "bar2", 4);
        result = obj.get("foo", 4);
        System.out.println(result);
        result = obj.get("foo", 5);
        System.out.println(result);



    }

    public void set(String key, String value, int timestamp) {
        if (hashMap.containsKey(key)) {
            hashMap.get(key).add(new Pair(timestamp, value));
        }else{
            ArrayList<Pair> arr = new ArrayList<Pair>();
            arr.add(new Pair(timestamp, value));
            hashMap.put(key, arr);
        }
    }

    public String get(String key, int timestamp) {
        String cand = "";

        if (hashMap.containsKey(key)) {
            ArrayList<Pair> arr = hashMap.get(key);
            int low = 0, high = arr.size() - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                int timeVal = arr.get(mid).timestamp;
                if (timeVal == timestamp) {
                    return arr.get(mid).val;
                }else if (timeVal < timestamp) {
                    cand = arr.get(low).val;
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }

            }
        }

        return cand;
    }
}
