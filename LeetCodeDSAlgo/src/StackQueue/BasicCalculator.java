package StackQueue;
import java.util.*;
//224. Basic Calculator
public class BasicCalculator {
    public static void main(String args[]){
        BasicCalculator obj = new BasicCalculator();
        String input = "6-4/2";
        //String input = "1 + 1";
        int result = obj.calculate(input);

        System.out.println("result :"+result);
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Queue<Character> q = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            q.offer(c);
        }
        q.offer('+');
        while(!q.isEmpty()){
            System.out.println(q.poll());

        }

        return cal(q);

    }

    private int cal(Queue<Character> q) {
        char sign = '+';
        Integer num = null;     // 1 - 0 - 1
        Stack<Integer> stack = new Stack<Integer>();
        while (!q.isEmpty()) {
            char c = q.poll();
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                if (num != null) {
                    num = 10 * num + c - '0';
                } else {
                    num = c - '0';
                }
            } else if (c == '(') {
                num = cal(q);
            } else {
                // + - * / )
                if (sign == '+' && num != null) {
                    stack.push(num);
                } else if (sign == '-') {
                    if (c == '-' && num == null) { // -1--1
                        c = '+'; // Negative + negative to positive
                    } else if(num != null){
                        stack.push(-num);
                    }
                } else if (sign == '*' && num != null) {
                    stack.push(stack.pop() * num);
                } else if (sign == '/' && num != null) {
                    stack.push(stack.pop() / num);
                }

                if (c == ')') {
                    break;
                }
                num = null;
                sign = c;
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
