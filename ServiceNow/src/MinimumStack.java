import java.util.*;
//Finding the minimum element from the stack.
public class MinimumStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    MinimumStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }

    public void push(int x){
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop(){
        if (stack.isEmpty()) {
            return;
        }
        int popped = stack.pop();
        if(popped==minStack.peek()){
            minStack.pop();
        }
    }

    public static void main(String args[]){

        MinimumStack minStack = new MinimumStack();
        minStack.push(3);
        minStack.push(5);
        minStack.push(2);
        minStack.push(1);

        System.out.println("Minimum element: " + minStack.getMin()); // Output should be 1

        minStack.pop();
        minStack.pop();

        System.out.println("Minimum element after popping: " + minStack.getMin()); // Output should be 3


    }
}
