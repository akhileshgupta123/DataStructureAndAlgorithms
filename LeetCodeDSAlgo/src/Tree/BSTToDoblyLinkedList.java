package Tree;
import java.util.*;

public class BSTToDoblyLinkedList {
    BSTToList root;
    public static void main(String args[]){
        BSTToDoblyLinkedList obj = new BSTToDoblyLinkedList();
        obj.root = obj.createNode(10);
        obj.root.left = obj.createNode(12);
        obj.root.right = obj.createNode(15);
        obj.root.left.left = obj.createNode(25);
        obj.root.left.right = obj.createNode(30);
        obj.root.right.left = obj.createNode(36);
        BSTToList head = obj.BSTToCList(obj.root);
        obj.displayCList(head);

    }

    private BSTToList createNode(int data){
        BSTToList obj = new BSTToList(data);
        return obj;
    }

    private void displayCList(BSTToList head){
        System.out.println("Circular Doubly Linked List is :");

        BSTToList itr = head;
        do
        {
            System.out.print(itr.data + " ");
            itr = itr.right;
        } while (head != itr);

        //System.out.print(itr.data + " ");

        System.out.println();

    }

    private BSTToList BSTToCList(BSTToList root){
        BSTToList head = null;
        BSTToList prev = null;
        Stack<BSTToList> stack = new Stack<BSTToList>();
        while(root!=null || !stack.isEmpty()){
            if(root==null){
                System.out.println("it is null");
            }else{
                System.out.println(root.data);
            }

            while(root!=null){
                System.out.println("inner"+root.data);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            root.left = prev;
            if (prev != null)
                prev.right = root;
            else
                head = root;


            BSTToList right = root.right;

            head.left = root;
            System.out.println("head left is :"+root.data);
            System.out.println("head is :"+head.data);
            System.out.println("head right is :"+right);
            root.right = head;

            //displayCList(head);

            prev = root;
            root = right;


        }
        return head;
    }
}

class BSTToList{
    int data;
    BSTToList left,right;
    public BSTToList(int data){
        this.data = data;
        this.left=this.right=null;
    }

}
