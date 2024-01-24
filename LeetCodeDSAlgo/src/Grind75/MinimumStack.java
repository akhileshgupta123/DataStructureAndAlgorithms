package Grind75;
import java.util.*;
//155 Min Stack
public class MinimumStack {

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
    public static void main(String args[]){

        MinimumStack obj = new MinimumStack();

        obj.push(-2);
        obj.push(0);
        obj.push(-3);

        System.out.println(obj.getMin());
        obj.pop();

        System.out.println(obj.top());
        obj.pop();



    }

    public void push(int x){
        if(stack.empty()){
            stack.push(x);
            minStack.push(x);
        }else{
            stack.push(x);
            if(minStack.peek() > x){
                minStack.push(x);
            }else{
                minStack.push(minStack.peek());
            }
        }

    }

    public void pop() {
        if(stack.empty()){
            //throw exception
        }else{
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if(stack.empty()){
            //throw Exception();
            return -1;
        }else{
            return stack.peek();
        }
    }

    public int getMin() {
        if(minStack.empty()){
            //throw Exception
            return -1;
        }else{
            return minStack.peek();
        }
    }
}
