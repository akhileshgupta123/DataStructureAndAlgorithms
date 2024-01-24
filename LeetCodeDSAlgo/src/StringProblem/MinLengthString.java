package StringProblem;
//1750. Minimum Length of String After Deleting Similar Ends
//O(n) time, O(1) space
public class MinLengthString {
    public static void main(String args[]){
        MinLengthString obj = new MinLengthString();
        String str = "aabccabba";
        int result = obj.minimumLength(str);
        System.out.println("result is :"+result);
    }

    private int minimumLength(String s){
        int i=0;
        int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i)==s.charAt(j) && i!=j){
                i++;
                j--;
            }
            else if(i!=0 && s.charAt(i) == s.charAt(i-1)){
                i++;
            }else if(j!= s.length()-1 && s.charAt(j) == s.charAt(j+1)){
                j--;
            }else{
                break;
            }
        }

        if(j-i<0){
            return 0;
        }
        return j-i + 1;
    }
}
