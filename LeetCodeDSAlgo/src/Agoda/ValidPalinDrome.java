package Agoda;

public class ValidPalinDrome {
    public static void main(String args[]){
        String str = "A man, a plan, a canal: Panama";
        ValidPalinDrome obj  = new ValidPalinDrome();
        boolean result = obj.isPalindrome(str);
        System.out.println(result);
    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(!Character.isLetterOrDigit(leftChar)){
                left++;
            }else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            }else{
                if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
