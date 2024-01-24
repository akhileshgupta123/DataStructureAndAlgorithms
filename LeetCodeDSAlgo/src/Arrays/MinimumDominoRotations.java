package Arrays;
import java.util.*;

//1007. Minimum Domino Rotations For Equal Row
public class MinimumDominoRotations {
    public static void main(String args[]){

        MinimumDominoRotations obj = new MinimumDominoRotations();
        int tops[] = new int[]{3,5,1,2,3};
        int bottoms[] = new int[]{3,6,3,3,4};
        int result = obj.minimumDominoRotations(tops,bottoms);
        System.out.println("The result is :"+result);

    }

    private int minimumDominoRotations(int tops[], int bottoms[]){
        Set<Integer> topSet = new HashSet<Integer>();
        Set<Integer> bottomSet = new HashSet<Integer>();

        for (int t: tops) topSet.add(t);
        for (int b: bottoms) bottomSet.add(b);

        int minSwaps = -1;

        minSwaps = rotate(topSet, tops, bottoms);

        minSwaps = Math.min(minSwaps, rotate(bottomSet, bottoms, tops));

        return minSwaps;
    }

    private int rotate(Set<Integer> set, int[] main, int[] swap){
        int minSwaps = Integer.MAX_VALUE;
        for (int n: set) {
            int currentMin = 0;
            int count = 0;
            for (int i = 0; i < main.length; i++) {
                if (n == main[i])
                    count++;
                else if(n == swap[i]){
                    currentMin++;
                    count++;
                }
                else
                    break;
            }
            if (count == main.length)
                minSwaps = Math.min(minSwaps, currentMin);
        }
        return minSwaps == Integer.MAX_VALUE ? -1: minSwaps;
    }
}
