package Tree;
import java.util.*;
//199. Binary Tree Right Side View
public class BinaryTreeRightSideView {
    public static void main(String args[]){
        BinaryTreeRightSideView obj = new BinaryTreeRightSideView();

        RightSideView root = new RightSideView(1);
        root.left = new RightSideView(2);
        root.right = new RightSideView(3);
        root.left.left = new RightSideView(4);
        root.right.left = new RightSideView(5);
        root.right.right = new RightSideView(6);
        root.right.left.left = new RightSideView(7);
        List<Integer> result = obj.rightSideView(root);
        System.out.println(result);
    }


    public List<Integer> rightSideView(RightSideView root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;

        Queue<RightSideView> queue = new LinkedList<RightSideView>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=1; i<= size; i++){
                RightSideView node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                if(i == size) res.add(node.data);
            }
        }

        return res;
    }
}


class RightSideView{
    int data;
    RightSideView left,right;
    RightSideView(int data){
        this.data = data;
        this.left = this.right = null;
    }
}