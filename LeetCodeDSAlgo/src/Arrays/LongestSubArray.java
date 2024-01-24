package Arrays;

//2419. Longest Subarray With Maximum Bitwise AND
//O(N) | O(1)
public class LongestSubArray {
    public static void main(String args[]){
        LongestSubArray obj = new LongestSubArray();
        int nums[] = new int[]{1,2,3,3,2,2};
        int result = obj.longestSubarray(nums);
        System.out.println(result);
    }

    public int longestSubarray(int[] nums) {
        int maxLen = 0;
        int maxEle = 0;

        int tempLen = 1;
        int prev = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]==prev){
                tempLen++;
            }else{
                if(prev>maxEle){
                    maxEle = prev;
                    maxLen = tempLen;
                }else if (prev==maxEle && tempLen>=maxLen){
                    maxLen = tempLen;
                }
                tempLen=1;
                prev=nums[i];
            }
        }

        if(prev>maxEle){
            maxLen = tempLen;
        }else if (prev==maxEle && tempLen>maxLen){
            maxLen = tempLen;
        }
        return maxLen;
    }
}
