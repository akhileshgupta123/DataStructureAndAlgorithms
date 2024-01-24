package Hashing;
import java.util.*;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public class SortHashMapKey {
    public static void main(String args[]){
        HashMap<Integer, String> hm=new HashMap<Integer, String>();
        hm.put(23, "Yash");
        hm.put(17, "Arun");
        hm.put(15, "Swarit");
        hm.put(9, "Neelesh");

        SortHashMapKey obj = new SortHashMapKey();
        HashMap<Integer, String> result = obj.sortKey(hm);

        for(Map.Entry<Integer,String> result1 : result.entrySet()){
            System.out.println("key is:"+result1.getKey());
            System.out.println("val is:"+result1.getValue());
        }

    }

    private HashMap sortKey(HashMap map){
        List<Map.Entry<Integer,String>> list = new ArrayList(map.entrySet());
        /*
        for(Map.Entry<Integer,String> result : list){
            System.out.println("key is:"+result.getKey());
            System.out.println("val is:"+result.getValue());
        }*/
        //Set<Map.Entry<Integer,String>> s = map.entrySet();
        //for (Map.Entry<String, Integer> it: s)
        //for(Map.Entry<Integer,String> item: s){

        //}

        /*
        for(Map.Entry<Integer,String> item: s){
            System.out.println("key:"+item.getKey());
            System.out.println("key:"+item.getValue());
        }*/


        Collections.sort(list,new Comparator<Map.Entry<Integer,String>>(){
            public int compare(Map.Entry<Integer,String> obj1, Map.Entry<Integer,String> obj2){
                //return obj2.getValue().compareTo(obj1.getValue());
                return obj2.getKey().compareTo(obj1.getKey());
            }
        });


        HashMap sortedHashMap = new LinkedHashMap();
        for(Map.Entry<Integer,String> result : list){
           sortedHashMap.put(result.getKey(),result.getValue());
        }
        return sortedHashMap;
    }
}
