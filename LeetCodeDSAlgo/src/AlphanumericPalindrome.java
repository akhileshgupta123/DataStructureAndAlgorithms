public class AlphanumericPalindrome {

    public static void main(String args[]){
        String teststr = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(teststr);
        System.out.println("result is :"+result);
    }


    public static boolean isPalindrome(String str){
        int size = str.length();
        String ics = str.toLowerCase();
        int left=0;
        int right = size-1;

        while(right>= left){
            if(ics.charAt(left) == ics.charAt(right)){
                right--;
                left++;
            }else if(!Character.isLetter(ics.charAt(left))){
                left++;
            }else if(!Character.isLetter(ics.charAt(right))){
                right--;
            }else{
                return false;
            }

        }

        return true;
    }
}
