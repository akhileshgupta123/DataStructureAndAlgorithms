package Arrays;
import java.util.*;
//1906. Minimum Absolute Difference Queries
//Time Compexity: O((m + n) * 100) // m = queries.length, n = nums.length
//        Space Complexity: O(n * 100) // n = nums.length
public class MinimumDifference {
    public static void main(String args[]){
        MinimumDifference obj = new MinimumDifference();
        int ums[] = new int[]{1,3,4,8};
        int queries[][] = new int[][]{{0,1},{1,2},{2,3},{0,3}};
        int result[] = obj.minDifference(ums,queries);

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }

    }

    public int[] minDifference(int[] nums, int[][] queries) {

        int n = nums.length;
        int[][] count = new int[n + 1][100];
        int q = queries.length;
        int ans[] = new int[q];

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < 100; ++j)
                count[i + 1][j] = count[i][j];

            System.out.println("here :"+count[i + 1][nums[i] - 1]);
            ++count[i + 1][nums[i] - 1];
        }

        for(int i = 0; i < n; ++i) {
            for (int j = 0; j < 100; ++j){
                System.out.print(count[i+1][j] + " ");
            }

            System.out.println(" ");
        }


        for(int i = 0; i < q; ++i) {



            int low = queries[i][0];
            int high = queries[i][1] + 1;
            System.out.println("high"+high);
            List<Integer> present = new ArrayList<>();
            int min = 100;

            for(int j = 0; j < 100; ++j)
                if(count[high][j] - count[low][j] != 0)
                    present.add(j);

            System.out.println("the present size is:"+present);
            for(int j = 1; j < present.size(); ++j)
                min = Math.min(min, present.get(j) - present.get(j - 1));

            if(present.size() == 1)
                min = -1;

            ans[i] = min;
        }
        return ans;
    }
}
