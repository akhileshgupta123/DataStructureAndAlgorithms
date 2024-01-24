package LinkedList;

public class ReverseLinkedList {
    ReverseLinkedListNode head;
    public static void main(String args[]){
        ReverseLinkedList obj = new ReverseLinkedList();
        obj.head = new ReverseLinkedListNode(1);
        obj.head.next = new ReverseLinkedListNode(2);
        obj.head.next.next = new ReverseLinkedListNode(3);
        obj.head.next.next.next = new ReverseLinkedListNode(4);
        obj.head.next.next.next.next = new ReverseLinkedListNode(5);

        System.out.println("Given Linked list");
        obj.printList(obj.head);

        obj.head = obj.reverseList(obj.head);
        System.out.println("Reverse Linked list");
        obj.printList(obj.head);
    }

    private ReverseLinkedListNode reverseList(ReverseLinkedListNode node){
        if(node==null || node.next == null){
            return node;
        }

        ReverseLinkedListNode slownode = null;
        ReverseLinkedListNode fastnode = node;

        ReverseLinkedListNode tempnode;

        while(fastnode!=null){
            tempnode = fastnode.next;
            fastnode.next = slownode;
            slownode = fastnode;
            fastnode = tempnode;
        }

        return slownode;

    }

    private void printList(ReverseLinkedListNode node){
        while(node!=null){
            System.out.print(node.data+" -> ");
            node = node.next;
        }
    }
}

class ReverseLinkedListNode{
    int data;
    ReverseLinkedListNode next;
    public ReverseLinkedListNode(int data){
        this.data = data;
    }
}
