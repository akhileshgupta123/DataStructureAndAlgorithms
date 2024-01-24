package Tree;

public class ConvertTreeToLinkedList {

    ConvertNode root;
    ConvertNode head;

     ConvertNode prev = null;
    public static void main(String args[]){
        ConvertTreeToLinkedList obj = new ConvertTreeToLinkedList();
        obj.root = new ConvertNode(10);
        obj.root.left = new ConvertNode(12);
        obj.root.right = new ConvertNode(15);
        obj.root.left.left = new ConvertNode(25);
        obj.root.left.right = new ConvertNode(30);
        obj.root.right.left = new ConvertNode(36);

        obj.BinaryTreeToDoublyLinkedList(obj.root);
        obj.printNode(obj.head);
    }


    private void BinaryTreeToDoublyLinkedList(ConvertNode innerRoot){
        if (innerRoot == null)
            return;

        this.BinaryTreeToDoublyLinkedList(innerRoot.left);
        if (prev == null)
            head = innerRoot;
        else
        {
            innerRoot.left = prev;
            prev.right=innerRoot;

        }

        prev = innerRoot;

        this.BinaryTreeToDoublyLinkedList(innerRoot.right);

    }
    private void printNode(ConvertNode node){
        while(node!=null){
            System.out.println(node.data+ " ");
            node = node.right;
        }
    }
}


class ConvertNode{
    int data;
    ConvertNode left, right;

    ConvertNode(int item)
    {
        this.data = item;
        this.left = this.right = null;
    }
}



