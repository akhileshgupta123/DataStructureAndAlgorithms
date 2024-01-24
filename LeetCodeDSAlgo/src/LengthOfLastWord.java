/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.*/
public class LengthOfLastWord {

    public static void main(String args[]){
        String st1 = "Start Coding Here";
        int count = getWordCount(st1);
        System.out.println("the count is :"+count);
    }

    public static int getWordCount(String str){
        if(str==null)
            return 0;

        int len=0;

       for(int i = str.length()-1; i>=0;i--){
            if(str.charAt(i)==' '){
                if(len>0)
                    break;
            }else{
                len++;
            }
       }
        return len;
    }
}
