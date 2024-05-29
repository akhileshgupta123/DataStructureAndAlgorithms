package StackQueue;
import java.util.*;
public class BracketSequence {
    public static void main(String args[]){
        String input = "()())";
        char brackets[] = input.toCharArray();
        int size = brackets.length;
        Stack<Integer> stack = new Stack<Integer>();
        int target = -1;

        for (int i = 0; i < size; i++) {
            if(brackets[i] == ')') {

                if(stack.empty()) {
                    target = i;
                    break;
                }
                stack.pop();
            }else{
                stack.push(i);
            }
        }

        System.out.println("target is:"+target);

        if(target == -1) {
            System.out.println(size - stack.peek());
            //return size - stack.peek();
        }else{
            System.out.println(target + 1);
        }


    }
}
