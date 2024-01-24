package Hashing;
import java.util.*;
public class CanMakeEquals {
    public static void main(String args[]){
        int source[]=new int[]{1, 2, 3, 4};
        int target[]=new int[]{1, 4, 3, 2};

        CanMakeEquals obj = new CanMakeEquals();
        boolean result = obj.canEquals(source,target);
        System.out.println("result is : "+result);
    }


    private boolean canEquals(int source[], int target[]){

        Map<Integer, Integer> sourcemap = new HashMap<Integer,Integer>();
        Map<Integer, Integer> targetmap = new HashMap<Integer,Integer>();
        for(int i = 0; i < target.length; i++) {
            int firstCount = targetmap.getOrDefault(target[i], 0);
            targetmap.put(target[i], ++firstCount);
            int secondCount = sourcemap.getOrDefault(source[i], 0);
            sourcemap.put(source[i], ++secondCount);
        }

        System.out.println(sourcemap);
        System.out.println(targetmap);
        return(sourcemap.equals(targetmap));
    }
}
