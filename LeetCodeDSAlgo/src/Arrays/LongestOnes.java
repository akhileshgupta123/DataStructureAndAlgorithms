package Arrays;
//1004. Max Consecutive Ones III
public class LongestOnes {
    public static void main(String args[]){
        LongestOnes obj = new LongestOnes();
        int nums[] = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int result = obj.longestOne(nums, k);
        System.out.println("The result is :"+result);
    }

    private int longestOne(int arr[], int k){
        int left = 0;
        int numZeros = 0;
        int maxLen = Integer.MIN_VALUE;
        for(int right = 0; right < arr.length; right++){
            if(arr[right] == 0)
                numZeros += 1;

            while(numZeros > k){

                if(arr[left] == 0)
                    numZeros -= 1;

                left += 1;

                System.out.println("inside while left is :"+left);

            }

            System.out.println("the left is :"+left);
            System.out.println("the right is :"+right);

            maxLen = Math.max(right-left+1, maxLen);

        }
        return maxLen;
    }
}
