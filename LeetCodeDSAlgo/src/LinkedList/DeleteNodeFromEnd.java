package LinkedList;

public class DeleteNodeFromEnd {
    DeleteListNode node;
    public static void main(String args[]){
        DeleteNodeFromEnd obj = new DeleteNodeFromEnd();
        obj.node = new DeleteListNode(1);
        obj.node.next = new DeleteListNode(2);
        obj.node.next.next = new DeleteListNode(3);
        obj.node.next.next.next = new DeleteListNode(4);
        obj.node.next.next.next.next = new DeleteListNode(5);
        obj.node.next.next.next.next.next = new DeleteListNode(6);

        obj.node = obj.removeNthFromEnd(obj.node, 3);
        obj.print(obj.node);
    }

    private DeleteListNode removeNthFromEnd(DeleteListNode head, int n){
        DeleteListNode first = head;

        // Second pointer will point to the
        // Nth node from the beginning
        DeleteListNode second = head;
        for (int i = 0; i < n; i++) {

            if (second.next == null) {
                if (i == n - 1)
                    head = head.next;
                return head;
            }
            second = second.next;
        }

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;
        return head;
    }

    private void print(DeleteListNode node){
        while(node!=null){
            System.out.print(node.data + "->");
            node = node.next;
        }
    }

}




class DeleteListNode{
    int data;
    DeleteListNode next;
    public DeleteListNode(int data){
        this.data = data;
        this.next = null;
    }
}
