package Grind75;
//20. Valid Parentheses

//Time complexity:O(n)
//        Space complexity:O(n)

import java.util.*;
public class ValidParenthesis {
    public static void main(String args[]){
        String input = "()[]{}";
        //String input = "(]";
        ValidParenthesis obj = new ValidParenthesis();
        boolean result = obj.isValid(input);

        System.out.println(result);
    }

    boolean isValid(String str){
        Stack<Character> st = new Stack<Character>();

        if(str == null || str.length()==0)
            return true;

        for(int i=0;i< str.length(); i++){
            if(str.charAt(i)==')'){
                if(!st.isEmpty() && st.peek()=='('){
                    st.pop();
                }else{
                    return false;
                }
            }else if(str.charAt(i)=='}'){
                if(!st.isEmpty() && st.peek()=='{'){
                    st.pop();
                }else{
                    return false;
                }
            }else if(str.charAt(i)==']'){
                if(!st.isEmpty() && st.peek()=='['){
                    st.pop();
                }else{
                    return false;
                }

            }else{
                st.push(str.charAt(i));
            }
        }

        if(st.isEmpty())
            return true;
        else
            return false;


    }
}
