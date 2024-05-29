package Tree;
import java.util.*;
//Time Complexity: O(n) where n is the number of nodes in the Binary Tree.
//Auxiliary Space: O(n).
public class CornerNodeBinaryTree {
    CornerNodeTree root;
    public static void main(String args[]){
        CornerNodeBinaryTree tree = new CornerNodeBinaryTree();
        tree.root = new CornerNodeTree(15);
        tree.root.left = new CornerNodeTree(10);
        tree.root.right = new CornerNodeTree(20);
        tree.root.left.left = new CornerNodeTree(8);
        tree.root.left.right = new CornerNodeTree(12);
        tree.root.right.left = new CornerNodeTree(16);
        tree.root.right.right = new CornerNodeTree(25);

        tree.printCorner(tree.root);
    }


    public void printCorner(CornerNodeTree root){
        Queue<CornerNodeTree> q = new LinkedList<CornerNodeTree>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0 ; i < n ; i++){
                CornerNodeTree temp = q.poll();
                if(i==0 || i==n-1){
                    System.out.print(temp.data + "  ");
                }

                if(temp.left!=null){
                    q.add(temp.left);
                }

                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
    }
}

class CornerNodeTree{
    int data;
    CornerNodeTree left, right;
    public CornerNodeTree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
