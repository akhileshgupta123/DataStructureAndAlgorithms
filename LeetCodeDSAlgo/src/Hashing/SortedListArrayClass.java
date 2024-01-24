/*
Given are Three arrays A, B and C.

Return the sorted list of numbers that are present in atleast 2 out of the 3 arrays.
 */

package Hashing;
import java.util.*;
import java.util.Map.*;
public class SortedListArrayClass {
    public static void main(String args[]){
        int a[] = {2, 3, 8, 4, 1, 9, 8};
        int b[] = {6, 5, 3, 7, 9, 2, 1};
        int c[] = {5, 1, 8, 2, 4, 0, 5};
        compute(a,b,c);
    }

    private static void compute(int a[], int b[], int c[]){
        HashMap<Integer,Integer>  baseMap = new HashMap<Integer, Integer>();

        fillMap(a, baseMap);
        fillMap(b, baseMap);
        fillMap(c, baseMap);

        for(Entry<Integer,Integer> entrySet : baseMap.entrySet()){
            System.out.println("key is:"+entrySet.getKey() + " val is :"+entrySet.getValue());
            /*
            if(baseMap.get(entrySet.getKey())>1){
                System.out.println("val is:"+entrySet.getKey());
            }*/

        }
    }

    private static void fillMap(int arr[], HashMap<Integer, Integer> map){
        for(int i=0; i<arr.length; i++){
            if(map.get(arr[i])==null){
                map.put(arr[i],1);
            }else{
                int count = map.get(arr[i]);
                map.put(arr[i], ++count);
            }
        }
    }
}
