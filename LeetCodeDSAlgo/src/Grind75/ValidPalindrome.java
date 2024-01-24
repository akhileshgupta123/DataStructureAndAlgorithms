package Grind75;

public class ValidPalindrome {
    public static void main(String args[]){
        ValidPalindrome obj = new ValidPalindrome();

        String content = "A man, a plan, a canal: Panama";

        boolean result = obj.isPalindrome(content);

        System.out.println("result is :"+result);

    }


    public boolean isPalindrome(String content){

        if(content.isEmpty())
            return true;

        int start = 0;
        int last = content.length()-1;

        while(start<=last){
            char currFirst = content.charAt(start);
            char currLast = content.charAt(last);

            if(!Character.isLetterOrDigit(currFirst)){

                start++;
            }else if(!Character.isLetterOrDigit(currLast)){
                last--;
            }else{

                if(Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)){
                    return false;
                }
                start++;
                last--;
            }
        }

        return true;
    }
}
