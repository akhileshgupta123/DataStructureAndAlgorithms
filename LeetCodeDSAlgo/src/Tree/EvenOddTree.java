package Tree;
import java.util.*;
//1609. Even Odd Tree
public class EvenOddTree {
    EvenOddNode root;
    public static void main(String args[]){
        EvenOddTree obj = new EvenOddTree();
        obj.root = new EvenOddNode(1);
        obj.root.left = new EvenOddNode(10);
        obj.root.right = new EvenOddNode(4);
        obj.root.left.left = new EvenOddNode(3);
        obj.root.right.left = new EvenOddNode(7);
        obj.root.right.right = new EvenOddNode(9);

        obj.root.left.left.left = new EvenOddNode(12);
        obj.root.left.left.right = new EvenOddNode(8);
        obj.root.right.left.left = new EvenOddNode(6);
        obj.root.right.right.right = new EvenOddNode(2);

        boolean result = obj.isEvenOddTree(obj.root);

        System.out.println("The status is :"+result);

    }

    private boolean isEvenOddTree(EvenOddNode root){
        if(root == null) { return false; }
        int level = -1;
        Queue<EvenOddNode> queue = new LinkedList<EvenOddNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            level++;
            boolean isEvenIndexLevel = level%2==0;
            int size = queue.size();
            for(int i = 0; i< size; i++) {
                EvenOddNode removeNode = queue.poll();
                boolean isEvenValue = removeNode.data % 2 == 0;
                EvenOddNode nextNode = queue.peek();

                boolean isNotLastNodeOnLevel = i != size -1;

                if(isEvenIndexLevel){
                    if(isEvenValue){
                        return false;
                    }

                    if(isNotLastNodeOnLevel && removeNode.data>=nextNode.data){
                        return false;
                    }


                }else{

                    if(!isEvenValue){
                        return false;
                    }

                    if(isNotLastNodeOnLevel && removeNode.data<=nextNode.data){
                        return false;
                    }

                }

                if(removeNode.left!=null){
                    queue.add(removeNode.left);
                }

                if(removeNode.right!=null){
                    queue.add(removeNode.right);
                }

            }

        }
        return true;
    }
}

class EvenOddNode{
    int data;
    EvenOddNode left,right;
    public EvenOddNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
