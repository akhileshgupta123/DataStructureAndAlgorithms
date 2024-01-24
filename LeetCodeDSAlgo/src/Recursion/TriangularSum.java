package Recursion;
//2221. Find Triangular Sum of an Array
public class TriangularSum {
    public static void main(String args[]){
        TriangularSum obj = new TriangularSum();

        int nums[] = new int[]{1,2,3,4,5};
        int result = obj.getTriangularSum(nums);
        System.out.println(result);
    }

    private int getTriangularSum(int[] nums){
        int length = nums.length;
        while(length > 1) {

            for (int i = 0; i < length -1; i++) {
                nums[i] = (nums[i] + nums[i+1]) % 10;
            }
            length--;
        }
        return nums[0];
    }
}
