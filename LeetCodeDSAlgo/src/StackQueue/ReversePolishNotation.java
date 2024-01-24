package StackQueue;
import java.util.*;
//150. Evaluate Reverse Polish Notation
public class ReversePolishNotation {
    public static void main(String args[]){
        ReversePolishNotation obj = new ReversePolishNotation();
        //String arr[] = {"2", "1", "+", "3", "*"};
        String arr[] = {"4", "13", "5", "/", "+"};


        int result = obj.evalRPN(arr);
        System.out.println("The result is:"+result);
    }


    public int evalRPN(String tokens[]){
        int returnValue = 0;
        String operators = "+-*/";

        Stack<String> stack = new Stack<String>();

        for(String t: tokens){

            if(!operators.contains(t)){
                stack.push(t);
            }else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(t);

                switch(index){
                    case 0 :
                        stack.push(String.valueOf(a+b));
                        break;
                    case 1 :
                        stack.push(String.valueOf(b-a));
                        break;
                    case 2 :
                        stack.push(String.valueOf(a*b));
                        break;
                    case 3 :
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }

        returnValue = Integer.valueOf(stack.pop());
        return returnValue;
    }
}
