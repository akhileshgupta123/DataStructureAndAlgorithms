package StackQueue;
import java.util.*;
public class ValidParenthesisString {
    public static void main(String args[]){
        ValidParenthesisString obj = new ValidParenthesisString();
        String test = "lee(t(c)o)de)";

        String result = obj.parsedString(test);
        System.out.println(result);

    }

    private String parsedString(String str){

        Stack<Integer> st = new Stack<Integer>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch=='('){
                st.push(i);
            }else if(ch==')'){
                if(st.size()>0 && str.charAt(st.peek())=='('){
                    st.pop();
                }else{
                    st.push(i);
                }
            }
        }

        char[] arr = str.toCharArray();

        while(st.size() > 0){
            int idx = st.pop();
            arr[idx] = '.'; // to avoid alphabets
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != '.'){
                sb.append(arr[i]);
            }
        }



        return sb.toString();
    }
}
