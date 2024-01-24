package Arrays;

public class MaximumAbsoluteDifference {

    public static void main(String args[]){
        int digit[] = {1,3,-1};
        MaximumAbsoluteDifference obj = new MaximumAbsoluteDifference();
        int result = obj.maximumDistance(digit);
        System.out.println("result is :"+result);

    }

    private int maximumDistance(int digit[]){

        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        System.out.println("max1:"+max1);
        System.out.println("max2:"+max2);
        System.out.println("min1:"+min1);
        System.out.println("min2:"+min2);

        for (int i = 0; i < digit.length; i++){
             max1 = Math.max(max1, digit[i]+i);
             min1 = Math.min(min1,digit[i]+i);
             max2 = Math.max(max2,digit[i]-i);
             min2 = Math.min(min2,digit[i]-i);

        }


        return Math.max(max1 - min1, max2 - min2);
    }
}
