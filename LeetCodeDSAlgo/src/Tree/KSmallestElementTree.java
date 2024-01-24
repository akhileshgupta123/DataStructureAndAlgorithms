package Tree;
import java.util.*;
class SmallElementTreeNode{
    int data;
    SmallElementTreeNode left,right;
    SmallElementTreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class KSmallestElementTree {

    static int count = 0;
    public static void main(String args[]){

        KSmallestElementTree obj = new KSmallestElementTree();
        SmallElementTreeNode root = null;
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
        //int keys[] = { 5, 3, 6, 2, 4, 1 };


        for(int x : keys){
            root = obj.insertNode(root, x);

            System.out.println("the root element is :"+root.data);
        }

        int k = 3;


        SmallElementTreeNode res = obj.kthSmallestElement(root, k);

        System.out.println("res is :"+res.data);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer x, Integer y){
                return y-x;
            }
        });


        obj.kthSmallestElementSecond(root,k,pq);
        System.out.println("pq:"+pq.peek());
    }


    private SmallElementTreeNode insertNode(SmallElementTreeNode root, int x){

        if(root==null)
            return new SmallElementTreeNode(x);

        if(x<root.data)
            root.left = insertNode(root.left, x);
        else if(x>root.data)
            root.right = insertNode(root.right, x);


        return root;


    }

    private SmallElementTreeNode kthSmallestElementSecond(SmallElementTreeNode root, int k, PriorityQueue<Integer> pq){
        if(root==null)
            return null;

        SmallElementTreeNode left = kthSmallestElementSecond(root.left, k,pq);

        if (left != null)
            return left;

        System.out.println(root.data);
        //count++;
       // System.out.println("count:"+count);
        if(pq.size()==k){

            if(pq.peek()>root.data){
                pq.remove();
                pq.add(root.data);
            }
        }else{
            pq.add(root.data);
        }


        return this. kthSmallestElementSecond(root.right, k,pq);

    }


    private SmallElementTreeNode kthSmallestElement(SmallElementTreeNode root, int k){
        if(root==null)
            return null;

        SmallElementTreeNode left = kthSmallestElement(root.left, k);

        if (left != null)
            return left;

        System.out.println(root.data);
        count++;
        System.out.println("count:"+count);
        if (count == k)
            return root;

        return kthSmallestElement(root.right, k);

    }

}
