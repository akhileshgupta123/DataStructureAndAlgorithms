package paypal;
import java.util.Stack;

public class PayPayCalculator {
    public static void main(String args[]){
        String input = " 3+5 / 2 ";
        int output = computeValue(input);
        System.out.println(output);
    }
    private static int computeValue(String expression){
        //define the stack
        Stack<Character> digitStack = new Stack<Character>();
        Stack<Character> operatorStack = new Stack<Character>();

        for( char value : expression.toCharArray()){
            //if its space coming, we dont have to do anything
            if (value == ' ') {
                continue;
            }

            if (value >= '0' && value <= '9') {
                //check the opertorStack and if opertorstack top value is * or / (high priority)
                //take the top value from digitStack compute and insert back the computed value

                if(operatorStack.isEmpty()) {
                    digitStack.push(value);
                }else{
                    char operator = operatorStack.peek();
                    if (operator == '*' || operator == '/') {
                        operator = operatorStack.pop();
                        int digit = digitStack.pop() - '0';
                        int newVaule = operator == '*' ? (value - '0') * digit : digit/ (value - '0') ;
                        digitStack.push(Character.forDigit(newVaule,10));
                    }else{
                        digitStack.push(value);
                    }
                }
            }else {
                //its a operator, simply insert it
                operatorStack.push(value);

            }

        }

        if (!operatorStack.isEmpty()) {

            char operator = operatorStack.pop();
            int digit1 = digitStack.pop() - '0';
            int digit2 = digitStack.pop() - '0';

            int newValue = operator == '+' ? (digit2) + digit1 : (digit2) - digit1;
            digitStack.push(Character.forDigit(newValue,10));

        }

        return digitStack.pop()-'0';
    }
}
