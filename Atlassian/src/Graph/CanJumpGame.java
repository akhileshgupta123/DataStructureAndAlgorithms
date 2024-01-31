package Graph;
//45. Jump Game II
public class CanJumpGame {
    public static void main(String args[]){
        //int[] arr = new int[]{2,3,1,1,4};
        int[] arr = new int[]{2,3,0,1,4};


        CanJumpGame obj =  new CanJumpGame();
        int result = obj.jump(arr);

        System.out.println(result);
    }

    private int jump(int[] arr){
        int jump=0;
        int prevEnd = 0;
        int currStart = 0;

        for(int i=0; i<arr.length-1; i++){
            currStart = Math.max(currStart, i+arr[i]);
            if(i==prevEnd){
                jump++;
                prevEnd = currStart;

                if (currStart >= arr.length - 1) {
                    break;
                }

            }
        }

        return jump;
    }
}
