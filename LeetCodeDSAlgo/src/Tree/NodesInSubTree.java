package Tree;
import java.util.*;
public class NodesInSubTree {
    ChildSubTreeNode root;

    public static void main(String args[]){
        NodesInSubTree obj = new NodesInSubTree();
        obj.root = new ChildSubTreeNode(1);
        obj.root.children.add(new ChildSubTreeNode(2));
        obj.root.children.add(new ChildSubTreeNode(3));
        /*obj.root.children.add(new ChildSubTreeNode(7));
        obj.root.children.get(0).children.add(new ChildSubTreeNode(4));
        obj.root.children.get(0).children.add(new ChildSubTreeNode(5));
        obj.root.children.get(1).children.add(new ChildSubTreeNode(6));*/

        //String s_2 = "abaacab";
        String s_2 = "aba";
        ArrayList<Query> queries_2 = new ArrayList<Query>();
        queries_2.add(new Query(1, 'a'));
        //queries_2.add(new Query(2, 'b'));
        //queries_2.add(new Query(3, 'a'));

        int result[] = obj.countOfNodes(obj.root,queries_2,s_2);
        System.out.println(result[0]);
    }

    private int[] countOfNodes(ChildSubTreeNode root, ArrayList<Query> queries, String str){
        if (root == null) return new int[] { 0 };
        List<Integer> ans = new ArrayList<Integer>();

        HashMap<Character, Integer> hm;
        for (Query value : queries) {

            char c = value.c;
            int v = value.v;
            ChildSubTreeNode curr = null;
            hm = new HashMap<Character, Integer>();
            if (root.val != v) { //
                for (ChildSubTreeNode val : root.children) {
                    if (val.val == v) {
                        curr = val;
                    }
                }
            }else{
                curr = root;
            }


            if (curr != null) {
                traverse(curr, c, v, str, hm);
            }

            if (!hm.isEmpty()) {
                ans.add(hm.get(c));
            }
        }


        int[] ret = new int[ans.size()];
        for(int i = 0;i < ans.size();i++)
            ret[i] = ans.get(i);
        return ret;
    }

    private void traverse(ChildSubTreeNode root, char ch, int val, String str, HashMap<Character, Integer> hm){
        if(root == null)
            return;

        if( str.charAt(root.val-1) == ch){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for (ChildSubTreeNode value : root.children) { // Traverse the tree
            traverse(value, ch, val, str, hm);
        }
        return;
    }
}

class Query{
    int v;
    char c;
    Query(int v, char c) {
        this.v = v;
        this.c = c;
    }
}

class ChildSubTreeNode{
    public int val;
    public List<ChildSubTreeNode> children;

    public ChildSubTreeNode() {
        val = 0;
        children = new ArrayList<ChildSubTreeNode>();
    }

    public ChildSubTreeNode(int _val) {
        val = _val;
        children = new ArrayList<ChildSubTreeNode>();
    }

    public ChildSubTreeNode(int _val, ArrayList<ChildSubTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
