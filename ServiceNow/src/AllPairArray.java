import java.util.*;
// Find all pairs in an array of numbers that add up to a specific result.
public class AllPairArray {
    public static void main(String args[]){
        int[] arr = new int[]{1, 5, 7, -1, 5, 3, 3, 3};
        int n = arr.length;
        int sum = 6;

        AllPairArray obj = new AllPairArray();
        obj.printPairs(arr,n,sum);
    }

    private void printPairs(int[] arr, int n, int sum){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int rem = sum - arr[i];
            if (rem == arr[i]) {
                if (map.containsKey(rem) && map.get(rem) == 1) {
                    System.out.println("(" + rem + ", " + arr[i] + ")");
                }

            }else if (map.containsKey(rem) && !map.containsKey(arr[i])){
                System.out.println("(" + rem + ", " + arr[i] + ")");
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

    }
}
