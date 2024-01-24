package Tree;
import java.util.*;
//98. Validate Binary Search Tree
public class BinarySearchTreeCheck {


    public static void main(String args[]){
        BinarySearchTreeCheck obj = new BinarySearchTreeCheck();

        /*int pre[] = new int[]{40, 30, 35, 80, 100};
        int n = pre.length;

        if (obj.isBSTTree(pre, n) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }*/

        //int[] pre2 = new int[]{40, 30, 35, 20, 80, 100};
       // int[] pre2 = new int[]{20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40};

       // int[] pre2 = new int[]{25,1,4,0,2,3,6};
        int[] pre2 = new int[]{2,1,3};

        int n2 = pre2.length;
        if (obj.isBSTTree(pre2, n2) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    boolean isBSTTree(int pre[], int n){
        Stack<Integer> st = new Stack<Integer>();
        int root = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){


            System.out.println("the outside root is:"+root);
            System.out.println("the outside pre is:"+pre[i]);
            if(pre[i] < root){

                return false;
            }


            while(!st.empty() && st.peek() < pre[i]){
                root = st.peek();
                System.out.println("root :"+root);
                System.out.println("curr :"+pre[i]);
                st.pop();
            }

            st.push(pre[i]);

        }

        return true;
    }
}
