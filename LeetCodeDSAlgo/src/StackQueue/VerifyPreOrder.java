package StackQueue;
import java.util.*;
//255. Verify Preorder Sequence in Binary Search Tree
public class VerifyPreOrder {

    public static void main(String args[]){
        VerifyPreOrder obj = new VerifyPreOrder();
        int arr[] = new int[]{5,2,6,1,3};
        boolean result = obj.verifyPreorder(arr);
        System.out.println(result);
    }

    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack();
        for(int i: preorder){
            if(i<low)
                return false;
            while(!stack.isEmpty() && i>stack.peek())
                low = stack.pop();
            stack.push(i);
        }
        return true;
    }
}
