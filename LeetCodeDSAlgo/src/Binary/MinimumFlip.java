package Binary;
import java.util.*;

//1888. Minimum Number of Flips to Make the Binary String Alternating
public class MinimumFlip {
    public static void main(String args[]){
        MinimumFlip obj = new MinimumFlip();
        String s = "111000";
        int result = obj.getMinFlip(s);
        System.out.println("The result is :"+result);
    }

    private int getMinFlip(String str){
        int min = Integer.MAX_VALUE;
        int n = str.length();

        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();

        int expected = str.charAt(0) - '0';
        int expected2 = 1 - (str.charAt(0) - '0');


        System.out.println("first:"+expected);
        System.out.println("second:"+expected2);
        for (int i = 0; i < 2*n; i++) {
            if (str.charAt(i % n) - '0' != expected) {
                set.add(i);
            }
            if (str.charAt(i % n) - '0' != expected2) {
                set2.add(i);
            }
            System.out.println("set is"+set);
            System.out.println("se2t is"+set2);

            expected = 1 - expected;
            expected2 = 1 - expected2;
            System.out.println("first:"+expected);
            System.out.println("second:"+expected2);

            if (i > n - 1) {
                set.remove(i - n);
                set2.remove(i - n);
            }

            if (i >= n - 1) {
                min = Math.min(set.size(), Math.min(set2.size(), min));
            }
        }
        return min;
    }
}
