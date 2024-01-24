package Hashing;
import java.util.*;
//1124. Longest Well-Performing Interval
public class LongestWellPerform {

    public static void main(String args[]){
        LongestWellPerform obj = new LongestWellPerform();
        int hours[] = new int[]{9,9,6,0,6,6,9};
        //int hours[] = new int[]{6,6,6};
        int result = obj.longestWPI(hours);
        System.out.println(result);
    }

    private int longestWPI(int[] hours){

        int i=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int sum=0;
        //map.put(sum,-1);
        int max=Integer.MIN_VALUE;

        for(int val:hours){
            if(val>8)
                sum = sum+1;
            else
                sum = sum -1;

            if(!map.containsKey(sum))
                map.put(sum,i);

            if(sum>0)
                max=i+1;
            else if(map.containsKey(sum-1))
                max=Math.max(i-map.get(sum-1),max);
            i++;

        }

        System.out.println(map);
        if(max==Integer.MIN_VALUE)
            max=0;
        return max;

    }
}
