package DynamicProgramming;
//45. Jump Game II

//Time Complexity: O(n)
//space O(1)
public class MinimumJumpReachEnd {
    public static void main(String args[]){

        int nums[] = new int[]{2,3,1,1,4};
        //int nums[] = new int[]{2,3,0,1,4};

        MinimumJumpReachEnd obj = new MinimumJumpReachEnd();
        //int result = obj.minJump(nums);
        int result = obj.minJump1(nums);
        System.out.println("result:"+result);
    }


    private int minJump(int A[]){

        int jump=0;
        int current = 0;
        int farthest=0;
        for(int i=0;i<A.length-1;i++){
            farthest=Math.max(farthest,A[i]+i);
            System.out.println("farthest"+farthest);
            if(i==current){
                System.out.println("inside here:"+current);
                current=farthest;
                jump++;

                System.out.println("jump here:"+jump);
            }

        }
        return jump;
    }


    private int minJump1(int arr[]){

        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;
      //2,3,1,1,4
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1){
                System.out.println("here step is:"+step);
                return jump;
            }


            maxReach = Math.max(maxReach, i + arr[i]);
            System.out.println("maxReach is:"+maxReach);
            System.out.println("step is:"+step);
            step--;
            if (step == 0) {
                jump++;
                if (i >= maxReach)
                    return -1;
                step = maxReach - i;
                System.out.println("inner i is:"+i);
                System.out.println("inner step is:"+step);
            }
        }

        return -1;
    }
}
