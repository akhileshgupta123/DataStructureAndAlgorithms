package LinkedList;

public class RearrangeList {
    ArrangeListNode node;
    public static void main(String args[]){
        RearrangeList obj = new RearrangeList();
        obj.node = new ArrangeListNode(1);
        obj.node.next = new ArrangeListNode(2);
        obj.node.next.next = new ArrangeListNode(3);
        obj.node.next.next.next = new ArrangeListNode(4);
        obj.node.next.next.next.next = new ArrangeListNode(5);

        obj.node = obj.rearrangeList(obj.node);
        obj.print(obj.node);
    }

    private ArrangeListNode rearrangeList(ArrangeListNode node){
        ArrangeListNode slow = node;
        ArrangeListNode fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ArrangeListNode node1 = node;
        ArrangeListNode node2 = slow.next;
        slow.next = null;


        node2 = reverseList(node2);

         node = new ArrangeListNode(0);
        ArrangeListNode curr = node;
        while (node1 != null || node2 != null) {
            if (node1 != null) {

                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }

            if (node2 != null) {

                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }
        return node.next;

    }
    private ArrangeListNode reverseList(ArrangeListNode node){
        ArrangeListNode prev = null;
        ArrangeListNode curr = node;
        ArrangeListNode temp;
        while(curr!=null){

            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private void print(ArrangeListNode node){
        while(node!=null){
            System.out.print(node.data+"->");
            node = node.next;
        }
    }
}

class ArrangeListNode{
    int data;
    ArrangeListNode next;
    public ArrangeListNode(int data){
        this.data = data;
        this.next = null;
    }
}
