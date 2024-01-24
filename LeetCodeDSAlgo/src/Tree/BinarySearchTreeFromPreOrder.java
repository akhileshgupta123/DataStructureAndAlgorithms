package Tree;
import java.util.*;
//1008. Construct Binary Search Tree from Preorder Traversal
public class BinarySearchTreeFromPreOrder {
    public static void main(String args[]){
        BinarySearchTreeFromPreOrder obj = new BinarySearchTreeFromPreOrder();
        int preorder[] = new int[]{8,5,1,7,10,12};
        PreOrderTree root = obj.bstFromPreOrder(preorder);
        obj.inorder(root);
    }

    private PreOrderTree bstFromPreOrder(int preOrder[]){
        Stack<PreOrderTree> st = new Stack<PreOrderTree>();
        PreOrderTree root = new PreOrderTree(preOrder[0]);
        st.push(root);
        for (int i = 1; i < preOrder.length; i++) {
            PreOrderTree cur = new PreOrderTree(preOrder[i]);
            if(st.peek().data>preOrder[i]){
                st.peek().left = cur;
            }else{
                PreOrderTree temp = st.pop();

                while(!st.isEmpty() &&  st.peek().data < preOrder[i]){
                    temp = st.pop();
                }
                temp.right = cur;

            }
            st.push(cur);

        }
        return root;
    }

    private void inorder(PreOrderTree root){
        if(root.left!=null)
            inorder(root.left);

        System.out.println(root.data);

        if(root.right!=null)
            inorder(root.right);
    }
}

class PreOrderTree{
    int data;
    PreOrderTree left,right;
    public PreOrderTree(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
