package StackQueue;
import java.util.*;
//1628 - Design an Expression Tree With Evaluate Function
class ExpressionNode {
    String val;
    ExpressionNode left, right;
    ExpressionNode(String val, ExpressionNode left, ExpressionNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int evaluate() {
        if (left == null && right == null)
            return Integer.valueOf(val);

        int l = left.evaluate();
        int r = right.evaluate();

        switch (val) {
            case "+":
                return l+r;
            case "-":
                return r-l;
            case "*":
                return l*r;
            case "/":
                return r/l;
        }
        return -1;
    }
    // define your fields here
}
class TreeBuilder {
    ExpressionNode buildTree(String[] postfix) {
        Stack<ExpressionNode> stack = new Stack<>();
        for (String s : postfix) {
            switch (s) {
                case "+":
                case "-":
                case "*":
                case "/":
                    stack.push(new ExpressionNode(s, stack.pop(), stack.pop()));
                    break;
                default:
                    stack.push(new ExpressionNode(s, null, null));
            }
        }
        return stack.peek();
    }
}
public class ExpressionTreeEvaluation {
}
