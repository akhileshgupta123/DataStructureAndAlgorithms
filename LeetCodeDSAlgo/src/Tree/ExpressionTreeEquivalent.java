package Tree;
import java.util.*;
//1612. Check If Two Expression Trees are Equivalent
public class ExpressionTreeEquivalent {
    ExpressionTreeNode tree1, tree2;
    public static void main(String args[]){
        ExpressionTreeEquivalent obj = new ExpressionTreeEquivalent();
        obj.tree1 = new ExpressionTreeNode('+');
        obj.tree1.left = new ExpressionTreeNode('a');
        obj.tree1.right = new ExpressionTreeNode('+');
        obj.tree1.right.left = new ExpressionTreeNode('b');
        obj.tree1.right.right = new ExpressionTreeNode('c');


        obj.tree2 = new ExpressionTreeNode('+');
        obj.tree2.left = new ExpressionTreeNode('+');
        obj.tree2.right = new ExpressionTreeNode('a');
        obj.tree2.left.left = new ExpressionTreeNode('b');
        obj.tree2.left.right = new ExpressionTreeNode('c');

        boolean result = obj.isEquivalent(obj.tree1, obj.tree2);
    }

    private boolean isEquivalent(ExpressionTreeNode tree1, ExpressionTreeNode tree2){
        Map<Character,Integer> treeMap = new HashMap<Character,Integer>();
        dfs(tree1, treeMap, 1);
        System.out.println("size is :"+treeMap.size());
        dfs(tree2, treeMap, -1);

        for(Map.Entry<Character,Integer> it: treeMap.entrySet()){
            if(it.getValue()!=0){
                return false;
            }

            System.out.println("########the value is :"+it.getValue());
        }


        return true;

    }

    private void dfs(ExpressionTreeNode node, Map treeMap, int diff){
        if (node == null) {
            return;
        }

        if(node.data != '+'){
            if(treeMap.containsKey(node.data)){
                treeMap.put(node.data, ((Integer)treeMap.get(node.data)+diff));
            }else{
                System.out.println("here");
                treeMap.put(node.data,diff);
            }

        }

        dfs(node.left, treeMap, diff);
        dfs(node.right, treeMap, diff);

    }
}

class ExpressionTreeNode{
    char data;
    ExpressionTreeNode left,right;
    public ExpressionTreeNode(char data){
        this.data = data;
        this.left = this.right = null;
    }
}
