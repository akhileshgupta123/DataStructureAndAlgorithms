package Arrays;
import java.io.*;
//702. Search in a Sorted Array of Unknown Size
//Time: O(\log 10^4)O(log10

        //Space: O(1)O(1)
public class SearchSortedArray {
    public static void main(String args[]){
        SearchSortedArray obj = new SearchSortedArray();

        int array[] = new int[]{-1,0,3,5,9,12};
        int target = 9;
    }
/*
    public int search(ArrayReader reader, int target) {

        int lo = 0, hi = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            int val = reader.get(mi);
            if (val == target) return mi;
            else if (val < target) lo = mi + 1;
            else hi = mi - 1;
        }
        return -1;



    }*/
}
