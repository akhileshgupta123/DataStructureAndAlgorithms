package BinarySearch;

public class SquareRoot {
    public static void main(String args[]){
        SquareRoot obj = new SquareRoot();
        int result = obj.mySqrt(9);

        System.out.println("the result is :"+result);
    }

    private int mySqrt(int x){
        if(x==0 || x==1)
            return x;
        int start = 0,end = x/2,ans=0;

        while(start<=end){

            int mid = (start+end)/2;

            if(mid*mid==x){
                return mid;
            }
            if(mid*mid<x){
                start=mid+1;
                ans=mid;
            }else{
                end = mid-1;
            }
        }
        return  ans;
    }
}
