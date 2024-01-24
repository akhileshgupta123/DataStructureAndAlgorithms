package Hashing;
import java.util.*;
//509. Fibonacci Number
public class NthFabonacciMap {
    public static void main(String args[]){
        NthFabonacciMap obj = new NthFabonacciMap();
        Map<Integer, Integer> memorize = new HashMap<Integer,Integer>();
        memorize.put(1,0);
        memorize.put(2,1);
        int result = obj.getNthFabonacci(5,memorize);
        System.out.println("result is :"+result);
    }

    private int getNthFabonacci(int n, Map<Integer, Integer> memoize){
        if(memoize.containsKey(n)){
            return memoize.get(n);
        }else{
            memoize.put(n, getNthFabonacci(n - 1, memoize) + getNthFabonacci(n - 2, memoize));
            return memoize.get(n);
        }

    }
}
