package Arrays;
//1014. Best Sightseeing Pair
public class MaxScoreSightSeenPair {
    public static void main(String args[]){

        MaxScoreSightSeenPair obj = new MaxScoreSightSeenPair();

        int values[] = new int[]{8,1,5,2,6};
        int result = obj.maxScorePair(values);

        System.out.println("the result is :"+result);

    }

    private int maxScorePair(int arr[]){
        int max = 0 + arr[0];
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i<arr.length; i++) {

            ans = Math.max(max+arr[i] - i, ans);

            if(arr[i] + i > max)
                max = arr[i] + i;
        }
        return ans;
    }
}
