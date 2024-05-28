public class MaximumSumCircularArray {
    public static void main(String args[]){
        //int[] nums = new int[]{1,-2,3,-2};
        //nums = [5,-3,5]

        int[] nums = new int[]{5,-3,2,5};

        MaximumSumCircularArray obj = new MaximumSumCircularArray();
        int result = obj.maxSubArrayCircularSum(nums);

        System.out.println("result :"+result);
    }

    public int maxSubArrayCircularSum(int[] arr){

        if(arr.length == 0) return 0;
        int sum = arr[0];
        int maxSoFar = arr[0];
        int maxTotal = arr[0];
        int minTotal = arr[0];
        int minSoFar = arr[0];

        for(int i = 1; i < arr.length; i++){

            int num = arr[i];
            maxSoFar = Math.max(num, maxSoFar + num);
            maxTotal = Math.max(maxSoFar, maxTotal);

            minSoFar = Math.min(num, minSoFar + num);
            minTotal = Math.min(minTotal, minSoFar);

            sum += num;
        }

        if(sum == minTotal) return maxTotal;

        return Math.max(sum - minTotal, maxTotal);

    }
}
