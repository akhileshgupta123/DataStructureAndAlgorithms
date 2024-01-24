package StringProblem;
//125. Valid Palindrome
public class ValidPalindrome {
    public static void main(String args[]){
        ValidPalindrome obj = new ValidPalindrome();

        String str = "abc";
        //String str = "A man, a plan, a canal: Panama";
        boolean result = obj.validPalindrome(str);

        System.out.println("the result is:"+result);

    }

    private boolean validPalindrome(String s){
        int left = 0;
        int right = s.length()-1;

        while(left<right){

            if(s.charAt(left)!=s.charAt(right)){

                if (isValid(s, left, right - 1)) {
                    return true;
                }
                if (isValid(s, left + 1, right)) {
                    return true;
                }


                return false;

            }else{
                left++;
                right--;
            }

        }


        return true;
    }

    private boolean isValid(String s, int start, int end){
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start ++;
            end --;
        }

        return true;
    }
}
