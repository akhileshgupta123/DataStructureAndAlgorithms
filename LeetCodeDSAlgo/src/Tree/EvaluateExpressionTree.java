package Tree;
import java.util.*;
//1628. Design an Expression Tree With Evaluate Function
public class EvaluateExpressionTree {
    public static void main(String args[]){
        EvaluateExpressionTree obj = new EvaluateExpressionTree();
        String postfix[] = new String[]{"3","4","+","2","*","7","/"};
        EvaluateTreeNode node = obj.buildTree(postfix);

        int result = obj.evaluate(node);

        System.out.println("the result is :"+result);


        //obj.displayTree(node);
    }

    private void displayTree(EvaluateTreeNode node){
        if(node!=null && node.left!=null)
            displayTree(node.left);


        System.out.println(node.val);

        if(node!=null && node.right!=null)
            displayTree(node.right);
    }

    private EvaluateTreeNode buildTree(String[] postfix){
        Stack<EvaluateTreeNode> st = new Stack<EvaluateTreeNode>();
        for(String str: postfix){
            switch(str){
                case "+":
                case "-":
                case "*":
                case "/":
                    st.push(new EvaluateTreeNode(str, st.pop(), st.pop()));
                    break;
                default:
                    st.push(new EvaluateTreeNode(str, null, null));
            }
        }
        return st.pop();
    }

    private int evaluate(EvaluateTreeNode root){
        if(root==null)
            return 0;

        if (root.left == null && root.right == null && isNumeric(root.val))
            return Integer.parseInt(root.val);


        int leftEval = evaluate(root.left);

        // Evaluate right subtree
        int rightEval = evaluate(root.right);

        if (root.val.equals("+"))
            return leftEval + rightEval;

        if (root.val.equals("-"))
            return rightEval - leftEval;

        if (root.val.equals("*"))
            return leftEval * rightEval;

        return rightEval / leftEval;



    }

    public boolean isNumeric(String val) {
        for (char c : val.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }


}


class EvaluateTreeNode{
    String val;
    EvaluateTreeNode left, right;
    EvaluateTreeNode(String val, EvaluateTreeNode left, EvaluateTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
