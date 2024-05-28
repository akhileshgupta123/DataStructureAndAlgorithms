import java.util.*;
// Decode a string to find the count of each character’s appearance in the string.
public class DecodeString {
    public static void main(String args[]){
        String str = "2[abc]3[cd]ef";
        //String str = "3[a2[c]]";
        DecodeString obj = new DecodeString();

        String result = obj.decodeString(str);

        System.out.println("final result is :"+result);
    }

    public String decodeString(String s){
        Stack<Integer> stint = new Stack<Integer>();
        Stack<StringBuilder> stbuilder = new Stack<StringBuilder>();
        StringBuilder sb = new StringBuilder();
        int n=0;

        for(char ch: s.toCharArray()){

            if(Character.isDigit(ch)){
                n = n*10 + (ch-'0') ;
            }else if(ch=='['){
                stint.push(n);
                n=0;
                stbuilder.push(sb);
                sb=new StringBuilder();
            }else if(ch==']'){
                int k = stint.pop();
                StringBuilder temp = sb;
                sb = stbuilder.pop();
                while(k-->0){
                    sb.append(temp);
                }
            }else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    private int stringToInteger(String s){
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            ans = ans*10;
            ans  = ans + s.charAt(i)-'0';
        }
        return ans;
    }
}
