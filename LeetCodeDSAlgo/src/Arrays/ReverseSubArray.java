package Arrays;
import java.util.*;
public class ReverseSubArray {

    public static void main(String args[]){
        int source[] = {1, 3, 2, 4};
        int target[] = {1, 2, 3, 4};

        ReverseSubArray obj = new ReverseSubArray();
        boolean result = obj.checkArray(source,target);

        System.out.println("result is :"+result);
    }

    private boolean checkArray(int source[], int target[]){
        if(source.length!= target.length)
            return false;

        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        for(int cur: target){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }

        for(int cur: source){
            if(!map.containsKey(cur)){
                return false;
            }
            map.put(cur, map.get(cur)-1);
            if(map.get(cur)==0)
                map.remove(cur);


        }

        return map.size()==0;
    }
}
