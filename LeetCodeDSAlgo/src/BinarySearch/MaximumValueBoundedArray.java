package BinarySearch;

//1802. Maximum Value at a Given Index in a Bounded Array
//space complexity is O(1).
//time complexity is O(log(maxSum)).
public class MaximumValueBoundedArray {

    public static void main(String args[]){

        MaximumValueBoundedArray obj = new MaximumValueBoundedArray();
        int n = 4 ;
        int index = 2;
        int maxSum = 6;
/*
        int n = 6 ;
        int index = 1;
        int maxSum = 10;*/
        int result = obj.maxValue(n,index,maxSum);
        System.out.println("result is :"+result);
    }

    private int maxValue(int n, int index, int maxSum){
        long right = n-index-1;
        long left = index;
        long start =1;
        long end = maxSum;
        long sum =0;

        long res =0;


        while(start<=end){
            long mid = (end+start)/2;
            long ls =0; // Left Part sum
            long rs = 0; // Right Part Sum
            sum = mid;

            long m = mid-1;  // used in finding left sum and right sum

            if(right>0){
                if(right<=m)
                {   /*
                    When right part is filled with decreasing order natural numbers
                    then use this formula
                    */
                    rs = m*(m+1)/2 - (m-right)*(m-right+1)/2;
                }else {
                    /*
                    When right part is filled with 1's then use this formula
                    */
                    rs = m * (m + 1) / 2 + 1 * (right - m);
                }

            }

            if(left>0){

                if(left<=m) {

                /*
                9+8+7+6 = (1+2+3+4+5+.......+8+9) - (1+2+3+4+5)
                */
                    ls = m * (m + 1) / 2 - (m - left) * (m - left + 1) / 2;
                }
                else {

                    ls = m * (m + 1) / 2 + 1 * (left - m);
                }

            }

            // sum = left part + mid element + right part
            sum = sum +ls +rs;

            if(sum <= maxSum){

                res = Math.max(res,mid);
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return (int)res;
    }


}
