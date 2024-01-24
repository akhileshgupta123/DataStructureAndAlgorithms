package Arrays;

//55. Jump Game
public class CanJumpArray {

    public static void main(String args[]){
        //int arr[] = {2,3,1,1,4};
        int arr[] = {3,2,1,0,4};
        CanJumpArray obj = new CanJumpArray();
        boolean result = obj.canJump1(arr);

        System.out.println("the result is :"+result);
    }

    public boolean canJump(int nums[]){
        int max = 0;
        for(int i=0; i<nums.length; i++){


            if(max >= nums.length-1 || i > max)  break;
            max = Math.max(i+nums[i], max);

            System.out.println("max is:"+max);
        }
        System.out.println("outer max is:"+max);
        return max >= nums.length-1 ? true : false;
    }

    public boolean canJump1(int nums[]){
        int maxJ = 0, n = nums.length;
        for(int i=0;i<n;i++)
            if(i<=maxJ)   maxJ = Math.max(maxJ, i+nums[i]);
            else    return false;
        return true;
    }
}
