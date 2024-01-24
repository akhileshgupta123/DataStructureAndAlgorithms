package StackQueue;
import java.util.*;
//331. Verify Preorder Serialization of a Binary Tree
public class ValidSerialization {
    public static void main(String args[]){
        ValidSerialization obj = new ValidSerialization();
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean status = obj.isValid(preorder);
        System.out.println("the status is:"+status);

    }

    private boolean isValid(String preorder){
        if (preorder == null) {
            return false;
        }

        Stack<String> st = new Stack<String>();
        String[] strs = preorder.split(",");
        for (int pos = 0; pos < strs.length; pos++) {
            String curr = strs[pos];

            while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
                System.out.println("first item:"+st.peek());
                st.pop();
                if (st.isEmpty()) {
                    return false;
                }
                System.out.println("second item:"+st.peek());
                st.pop();
                System.out.println("stack size is:"+st.size());
            }
            st.push(curr);
        }
        return st.size() == 1 && st.peek().equals("#");
    }
}
