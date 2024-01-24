package StringProblem;

//125. Valid Palindrome
public class ValidPalindromeCheck {

    public static void main(String args[]){
        ValidPalindromeCheck obj = new ValidPalindromeCheck();
        String str = "A man, a plan, a canal: Panama";
        boolean result = obj.isPalindrome(str);

        System.out.println(result);

    }

    private boolean isPalindrome(String s){
        int l = 0;
        int h = s.length()-1;
        s = s.toLowerCase();

        while(l<h){

            if(!((s.charAt(l)>='a' && s.charAt(l)<='z') || (s.charAt(l)>=48 && s.charAt(l)<=57))){
                l++;
            }else if (!((s.charAt(h)>='a'&& s.charAt(h)<='z')|| (s.charAt(h)>=48 && s.charAt(h)<=57))){
                h--;
            }else if(s.charAt(l) == s.charAt(h)){
                l++;
                h--;
            }else
                return  false;

        }

        return true;
    }
}
