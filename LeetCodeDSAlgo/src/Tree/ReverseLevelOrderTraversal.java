package Tree;
import java.util.*;
public class ReverseLevelOrderTraversal {
    ReverseTreeNode root;
    public static void main(String args[]){
        ReverseLevelOrderTraversal obj = new ReverseLevelOrderTraversal();
        obj.root = new ReverseTreeNode(1);
        obj.root.left = new ReverseTreeNode(2);
        obj.root.right = new ReverseTreeNode(3);
        obj.root.left.left = new ReverseTreeNode(4);
        obj.root.left.right = new ReverseTreeNode(5);
        obj.root.right.left = new ReverseTreeNode(6);
        obj.root.right.right = new ReverseTreeNode(7);
        obj.levelOrderTraversal(obj.root);
    }

    private void levelOrderTraversal(ReverseTreeNode root){
        Map<Integer, List<Integer>> map = new HashMap<Integer,List<Integer>>();

        preorder(root, 1, map);
        for(int i = map.size(); i>0; i--){
            System.out.println("Level " + i + ": " + map.get(i));
        }
    }

    private void preorder(ReverseTreeNode root, int level, Map<Integer, List<Integer>> map){
        if (root == null) {
            return;
        }

        if(map.containsKey(level)){
            List<Integer> item = map.get(level);
            item.add(root.data);
        }else{
            List<Integer> item = new ArrayList<Integer>();
            item.add(root.data);
            map.put(level,item);
        }
        preorder(root.left, level + 1, map);
        preorder(root.right, level + 1, map);
    }
}

class ReverseTreeNode{
    int data;
    ReverseTreeNode left,right;
    public ReverseTreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
