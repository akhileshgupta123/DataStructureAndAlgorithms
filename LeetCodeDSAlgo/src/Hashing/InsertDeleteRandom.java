package Hashing;

//380. Insert Delete GetRandom O(1)

import java.util.*;
public class InsertDeleteRandom {
    HashMap<Integer, Integer> locs;
    ArrayList<Integer> nums;
    Random rand = new Random();

    InsertDeleteRandom(){
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Integer>();
    }
    public static void main(String args[]){

        InsertDeleteRandom obj = new InsertDeleteRandom();
        System.out.println(obj.rand.nextInt(3));
    }


    public boolean insert(int val){
        boolean contain = locs.containsKey(val);
        if ( contain )
            return false;

        locs.put( val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val){
        boolean contain = locs.containsKey(val);
        if ( ! contain ) return false;

        int loc = locs.get(val);

        if (loc < nums.size() - 1 ){
            int lastone = nums.get(nums.size() - 1 );
            nums.set( loc , lastone );
            locs.put(lastone, loc);
        }

        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;

    }

    public int getRandom(){
        return nums.get( rand.nextInt(nums.size()) );
        //return -1;
    }
}
