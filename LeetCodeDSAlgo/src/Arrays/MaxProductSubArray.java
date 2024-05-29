package Arrays;

//152. Maximum Product Subarray
public class MaxProductSubArray {
    public static void main(String args[]){
        MaxProductSubArray obj = new MaxProductSubArray();
        int nums[] = new int[]{1, -2, -3, 0, 7, -8, -2};
        //int nums[] = new int[]{2,3,-2,4};

        int result = obj.maxProduct(nums);

        System.out.println("result is :"+result);
    }

    private int maxProduct(int nums[]){
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int prod_left = 1;
        int prod_right = 1;

        for(int i=0; i<n; i++){
            prod_left = prod_left*nums[i];
            prod_right = prod_right*nums[n-i-1];
            if(max<prod_left || max<prod_right){
                max=Math.max(prod_left,prod_right);
            }

            if(nums[i]==0){
                prod_left=1;
            }
            if(nums[n-i-1]==0){
                prod_right=1;
            }
        }

        return max;
    }
}
