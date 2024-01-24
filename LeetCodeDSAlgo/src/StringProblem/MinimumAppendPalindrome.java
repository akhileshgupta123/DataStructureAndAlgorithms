package StringProblem;

public class MinimumAppendPalindrome {
    public static void main(String args[]){

        MinimumAppendPalindrome obj = new MinimumAppendPalindrome();
        //String s = "abede";
        String s = "leetcode";
        int result = obj.solve(s);
        System.out.println("the result is :"+result);

    }
    private int solve(String A){
        int i=0,j=A.length()-1,k=0,t=0;

        while(i<=j){

            if(A.charAt(i) != A.charAt(j)){
                i++;
                j = A.length()-1;
            }else{
                if(j==A.length()-1)
                    k=i;
                i++;
                j--;
            }

        }


        return k;
    }
}
