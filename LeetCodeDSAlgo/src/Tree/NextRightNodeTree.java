package Tree;
import java.util.*;
//1602. Find Nearest Right Node in Binary Tree
// Time Complexity o(n)
//space complexity o(n)
public class NextRightNodeTree {
    NextRightNode root;
    public static void main(String args[]){
        NextRightNodeTree obj = new NextRightNodeTree();
        obj.root = new NextRightNode(1);
        obj.root.left = new NextRightNode(2);
        obj.root.right = new NextRightNode(3);
        obj.root.left.right = new NextRightNode(4);
        obj.root.right.left = new NextRightNode(5);
        obj.root.right.right = new NextRightNode(6);

        NextRightNode result = obj.findNextRightNode(obj.root, 4);

        System.out.println("The result node is :"+result.data);
    }

    private NextRightNode findNextRightNode(NextRightNode root, int k){
        if (root == null)
            return null;

        Queue<NextRightNode> qn = new LinkedList<NextRightNode>();

        Queue<Integer> ql = new LinkedList<Integer>();

        int level = 0;

        qn.add(root);
        ql.add(level);

        while(!qn.isEmpty()){
            NextRightNode node = qn.peek();
            level = ql.peek();
            qn.remove();
            ql.remove();

            if(node.data == k){

                if (ql.size() == 0 || ql.peek() != level)
                    return null;

                return qn.peek();
            }



            if (node.left != null)
            {
                qn.add(node.left);
                ql.add(level + 1);
            }
            if (node.right != null)
            {
                qn.add(node.right);
                ql.add(level + 1);
            }
        }

        return null;

    }
}

class NextRightNode{
    int data;
    NextRightNode left, right;
    public NextRightNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
