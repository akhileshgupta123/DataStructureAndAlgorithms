package Recursion;
import java.util.*;
//1106. Parsing A Boolean Expression
public class BooleanExpression {
    public static void main(String args[]){
        //String expression = "&(|(f))";
        String expression  = "|(f,f,f,t)";
        BooleanExpression obj = new BooleanExpression();
        boolean result = obj.ParseBooleanExpression(expression);
        System.out.println(result);
    }

    public boolean ParseBooleanExpression(String expression){
        Stack<Character> stack = new Stack<Character>();
        for(char c: expression.toCharArray()) {

            if(c == '(' || c == ',') {
                continue;
            }
            if(c == ')'){

                boolean True = false, False = false;
                while(stack.peek() == 't' || stack.peek() == 'f'){
                    if(stack.pop() == 't') {
                        True = true;
                    } else {
                        False = true;
                    }

                }

                char operator = stack.pop(), result;
                if(operator == '&') {
                    result = False ? 'f' : 't';
                }else if(operator == '|') {
                    result = True ? 't' : 'f';
                }else {
                    result = True ? 'f' : 't';
                }

                stack.push(result);
                continue;
            }

            stack.push(c);
        }
        return stack.pop() == 't' ? true : false;
    }
}
