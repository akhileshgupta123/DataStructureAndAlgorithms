package Tree;
import java.util.*;
//102. Binary Tree Level Order Traversal
public class LevelOrderTraversal {
    LevelOrderTree root;
    public static void main(String args[]){
        LevelOrderTraversal obj = new LevelOrderTraversal();
        obj.root = obj.createNode(100);
        obj.root.left = obj.createNode(50);
        obj.root.right = obj.createNode(200);

        obj.root.left.left = obj.createNode(25);
        obj.root.left.right = obj.createNode(75);
        obj.root.right.right = obj.createNode(350);
        List<List<Integer>> result = obj.levelOrder(obj.root);

        System.out.println(result);

    }

    LevelOrderTree createNode(int data){
        LevelOrderTree obj = new LevelOrderTree(data);
        return obj;
    }


    private List<List<Integer>> levelOrder(LevelOrderTree root){
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if(root==null)
            return levels;

        Queue<LevelOrderTree> queue = new LinkedList<LevelOrderTree>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                LevelOrderTree node = queue.poll();
                list.add(node.data);

                if(node.left!=null){
                    queue.add(node.left);
                }

                if(node.right!=null){
                    queue.add(node.right);
                }

            }
            levels.add(list);
        }


        return levels;

    }

}

class LevelOrderTree{
    int data;
    LevelOrderTree left,right;
    LevelOrderTree(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
