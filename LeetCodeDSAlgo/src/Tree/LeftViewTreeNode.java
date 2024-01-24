package Tree;
import java.util.*;
public class LeftViewTreeNode {
    public static void main(String args[]){
        LeftViewTreeNode obj = new LeftViewTreeNode();
        LeftViewNode root = obj.createNode(10);
        root.left = obj.createNode(2);
        root.right = obj.createNode(3);
        root.left.left = obj.createNode(7);
        root.left.right = obj.createNode(8);
        root.right.right = obj.createNode(15);
        root.right.left = obj.createNode(12);
        root.right.right.left = obj.createNode(14);
        obj.printLeftView(root);
        int count = obj.countLeftView(root);
        System.out.println("count is :"+count);
        obj.printRightView(root);

    }

    private LeftViewNode createNode(int data){
        LeftViewNode obj = new LeftViewNode(data);
        return obj;
    }

    private void printLeftView(LeftViewNode root){
        if(root==null)
            return;

        Queue<LeftViewNode> queue = new LinkedList<LeftViewNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=1; i<=n;i++){
                LeftViewNode temp = queue.poll();

                if (i == 1)
                    System.out.print(temp.data + " ");

                if (temp.left != null)
                    queue.add(temp.left);

                // Add right node to queue
                if (temp.right != null)
                    queue.add(temp.right);
            }

        }
    }

    private void printRightView(LeftViewNode root){
        if(root==null)
            return;

        Queue<LeftViewNode> queue = new LinkedList<LeftViewNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=1; i<=n;i++){
                LeftViewNode temp = queue.poll();

                if (i == 1)
                    System.out.print(temp.data + " ");

                if (temp.right != null)
                    queue.add(temp.right);

                // Add right node to queue
                if (temp.left != null)
                    queue.add(temp.left);
            }

        }
    }

    private int countLeftView(LeftViewNode root){
        if(root==null)
            return 0 ;

        int count = 0;

        Queue<LeftViewNode> queue = new LinkedList<LeftViewNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=1; i<=n;i++){
                LeftViewNode temp = queue.poll();
                if(i==1){
                    count++;
                }
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return count;
    }
}



class LeftViewNode{
    int data;
    LeftViewNode left, right;
    public LeftViewNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
