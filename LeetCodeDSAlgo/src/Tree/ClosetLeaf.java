package Tree;
import java.util.*;
//LeetCode 742. Closest Leaf in a Binary Tree
//Time Complexity: O(n).
//
//Space: O(n).
public class ClosetLeaf {
    private int kNodeLevel = -1;
     ClosetTreeNode root;
    private int closestLeafLevel = Integer.MAX_VALUE;
    int ans = 0;
    private Map<Integer, List<ClosetTreeNode>> graph = new HashMap<>();
    public static void main(String args[]){
        ClosetLeaf obj = new ClosetLeaf();


        obj.root = new ClosetTreeNode(1);
        obj.root.left = new ClosetTreeNode(2);
        obj.root.right = new ClosetTreeNode(3);
        obj.root.left.left = new ClosetTreeNode(4);
        obj.root.left.left.left = new ClosetTreeNode(5);
        obj.root.left.left.left.left = new ClosetTreeNode(6);



        int result = obj.findClosestLeaf(obj.root,2);

        System.out.println(result);
        System.out.println(obj.kNodeLevel);
    }

    public int findClosestLeaf(ClosetTreeNode root, int k) {
        if(root == null)
            return -1;
        //dfs create graph
        dfs(root, null);
        LinkedList<ClosetTreeNode> queue = new LinkedList<ClosetTreeNode>();
        HashSet<ClosetTreeNode> memo = new HashSet<ClosetTreeNode>();
        queue.add(graph.get(k).get(0));
        while(!queue.isEmpty()){
            ClosetTreeNode cur = queue.removeFirst();
            if(memo.contains(cur))
                continue;

            memo.add(cur);
            for(int i = 0; i < 4; i++){
                ClosetTreeNode tempt = graph.get(cur.val).get(i);
                if(tempt!=null){
                    System.out.println("val is:"+ tempt.val);
                }

                if(tempt == null)
                    continue;
                else if(tempt.left == null && tempt.right == null)
                    return tempt.val;
                else
                    queue.addLast(tempt);
            }

        }
        return -1;
    }

    private void dfs(ClosetTreeNode node, ClosetTreeNode parent){
        int value = node.val;
        if(!graph.containsKey(node.val)){
            graph.put(node.val, new ArrayList<ClosetTreeNode>());
        }

        List<ClosetTreeNode> matrix = graph.get(node.val);

        matrix.add(node);
        matrix.add(parent);
        matrix.add(node.left);
        matrix.add(node.right);

        if(node.left != null){
            dfs(node.left, node);
        }
        if(node.right != null){
            dfs(node.right, node);
        }
    }




}

class ClosetTreeNode{
    int val;
    ClosetTreeNode left,right;
    ClosetTreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

}
