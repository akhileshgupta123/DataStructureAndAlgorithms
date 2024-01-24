package Tree;
import java.util.*;
public class CousineTree {
    CousineTreeNode root;
    public static void main(String args[]){
        CousineTree obj = new CousineTree();
        obj.root = new CousineTreeNode(1);
        obj.root.left = new CousineTreeNode(2);
        obj.root.right = new CousineTreeNode(3);
        obj.root.left.left = new CousineTreeNode(4);
        obj.root.left.right = new CousineTreeNode(5);

        obj.root.right.left = new CousineTreeNode(6);
        obj.root.right.right = new CousineTreeNode(7);

        obj.printAllCousine(obj.root, obj.root.right.left);

        //int level = obj.findLevelUsingQueue(obj.root,obj.root.left);

        //System.out.println("#######the level is :"+level);
    }

    private int findLevelUsingQueue(CousineTreeNode root, CousineTreeNode x){
        int level = 1;

        Queue<CousineTreeNode> levelQueue = new LinkedList<CousineTreeNode>();
        levelQueue.add(root);

        while(!levelQueue.isEmpty()){
            int size = levelQueue.size();
            for(int i=0; i<size;i++){
                CousineTreeNode temp = levelQueue.poll();
                if(temp!=null && temp==x){
                    return level;
                }
                if(temp!=null && temp.left!=null){
                    levelQueue.add(temp.left);
                }

                if(temp!=null && temp.right!=null){
                    levelQueue.add(temp.right);
                }

            }

            level++;
        }

        return level;

    }


    private void printAllCousine(CousineTreeNode root, CousineTreeNode node){
        if (root == null || root == node) {
            return;
        }

        int level = findLevel(root, node, 1, 0);

        System.out.println("the level is :"+level);

        printLevel(root,node,level);
    }

    private int findLevel(CousineTreeNode root, CousineTreeNode x, int index, int level){
        if (root == null || level != 0) {
            return level;
        }

        // if the given node is found, update its level
        if (root == x) {
            level = index;
        }

        // recur for the left and right subtree
        level = findLevel(root.left, x, index + 1, level);
        System.out.println("level left"+level);
        level = findLevel(root.right, x, index + 1, level);
        System.out.println("level right"+level);

        return level;
    }


    public static void printLevel(CousineTreeNode root, CousineTreeNode node, int level)
    {
        // base case
        if (root == null) {
            return;
        }

        System.out.print("level is : "+level);
        // print cousins
        if (level == 1)
        {
            System.out.print("  data is : "+root.data + " ");
            return;
        }

        // recur for the left and right subtree if the given node
        // is not a child of the root
        if (!(root.left != null && root.left == node ||
                root.right != null && root.right == node))
        {
            printLevel(root.left, node, level - 1);
            printLevel(root.right, node, level - 1);
        }
    }
}

class CousineTreeNode{
    int data;
    CousineTreeNode left, right;
    public CousineTreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
