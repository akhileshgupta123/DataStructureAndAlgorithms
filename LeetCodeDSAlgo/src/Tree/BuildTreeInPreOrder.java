package Tree;
import java.util.*;
//105. Construct Binary Tree from Preorder and Inorder Traversal
public class BuildTreeInPreOrder {
    static int preIndex = 0;
    public static void main(String args[]){
        //int inorder[] = new int[]{4, 2, 1, 7, 5, 8, 3, 6 };
        //int preorder[] = new int[]{1, 2, 4, 3, 5, 7, 8, 6};

        int inorder[] = new int[]{9,3,15,20,7};
        int preorder[] = new int[]{3,9,20,15,7};



        BuildTreeInPreOrder obj = new BuildTreeInPreOrder();

        BuildTreeNode root = obj.constructTree(inorder,preorder);
        obj.preorderTraversal(root);
        System.out.println(" ");
        obj.inorderTraversal(root);
    }

    private BuildTreeNode constructTree(int inorder[], int preorder[]){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return construct(inorder,preorder,0, inorder.length - 1, map);
    }

    private BuildTreeNode construct(int inorder[], int preorder[], int start, int end,  Map<Integer, Integer> map){
        if(start>end)
            return null;


        BuildTreeNode root = new BuildTreeNode(preorder[preIndex]);
        //index++;

        preIndex++;


        int index1 = map.get(root.data);

        root.left = construct(inorder, preorder, start, index1 - 1, map);


        root.right = construct(inorder,preorder,index1 + 1, end, map);

        return root;

    }


    public  void inorderTraversal(BuildTreeNode root)
    {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }


    public void preorderTraversal(BuildTreeNode root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}

class BuildTreeNode{
    int data;
    BuildTreeNode left,right;
    BuildTreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
