import java.util.*;
//103. Binary Tree Zigzag Level Order Traversal
public class ZigZagTreeTraversal {
    public static void main(String args[]){
        ZigZagTreeTraversal obj = new ZigZagTreeTraversal();
        ZigZagTree root = new ZigZagTree(1);
        root.left = new ZigZagTree(2);
        root.right = new ZigZagTree(3);
        root.left.left = new ZigZagTree(7);
        root.left.right = new ZigZagTree(6);
        root.right.left = new ZigZagTree(5);
        root.right.right = new ZigZagTree(4);

        ArrayList<Integer> result = obj.zigZagTraversal(root);
        System.out.println(result);
    }

    public ArrayList<Integer> zigZagTraversal(ZigZagTree root){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null)
            return ans;

        Queue<ZigZagTree> q = new LinkedList<ZigZagTree>();
        q.add(root);
        boolean leftToRight = true;
        while (q.size() > 0) {
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                ZigZagTree curr = q.poll();
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if (curr.right != null)
                    q.add(curr.right);
                temp.add(curr.data);
            }

            if (leftToRight){

            }else{
                Collections.reverse(temp);
            }

            for(int i=0;i<temp.size(); i++){
                ans.add(temp.get(i));
            }

            leftToRight = !leftToRight;
        }

        return ans;
    }
}

class ZigZagTree{
    int data;
    ZigZagTree left, right;
    ZigZagTree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
