package StackQueue;
import java.util.*;

public class ParenthesisCheck {

    public static void main(String args[]){

        ParenthesisCheck obj = new ParenthesisCheck();
        boolean result = obj.isValid("([{}])");

        System.out.println("result is:"+result);
    }

    private boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();

        char str[] = s.toCharArray();

        for(char ch:str){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }else{
                if(stack.isEmpty())
                    return  false;

                char ob = stack.pop();

                if((ob=='(' && ch==')') || (ob=='{' && ch=='}') || (ob=='[' && ch==']')){
                    continue;
                }else{
                    return false;
                }

            }
        }

        if(!stack.isEmpty())
            return false;
        else
            return true;

    }
}
