package Recursion;
import java.util.*;
// 394. Decode String
//Time complexity: O(n)
//Space complexity: O(n)
public class DecodeString {

    public static void main(String args[]){

        String str = "2[abc]3[cd]ef";
        //String str = "3[a2[c]]";
        DecodeString obj = new DecodeString();

        String result = obj.decodeValue(str);

        System.out.println("final result is :"+result);

    }


    public String decodeValue(String str){
        Stack<Integer> stint = new Stack<Integer>();
        Stack<StringBuilder> stbuilder = new Stack<StringBuilder>();
        StringBuilder sb = new StringBuilder();
        int n=0;

        for(char ch: str.toCharArray()){

            if(Character.isDigit(ch)){
                n = n*10 + (ch-'0') ;
            }else if(ch=='['){
                stint.push(n);
                n=0;
                stbuilder.push(sb);
                sb = new StringBuilder();
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


}
