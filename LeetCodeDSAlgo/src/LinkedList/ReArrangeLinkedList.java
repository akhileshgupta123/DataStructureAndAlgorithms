package LinkedList;

public class ReArrangeLinkedList {
    public static void main(String args[]){

        ReArrangeList head = new ReArrangeList(1);
        head.next = new ReArrangeList(2);
        head.next.next = new ReArrangeList(3);
        head.next.next.next = new ReArrangeList(4);
        head.next.next.next.next = new ReArrangeList(5);

        ReArrangeLinkedList obj = new ReArrangeLinkedList();

        obj.printList(head);


        obj.reArrange(head);
        obj.printList(head);
    }

    public void printList(ReArrangeList head){
        while(head!=null){
            System.out.print(head.data + " ");
            if (head.next != null) {
                System.out.print("->");
            }

            head = head.next;
        }
        System.out.println();
    }

    public void reArrange(ReArrangeList head){
        ReArrangeList slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }

        ReArrangeList node1 = head;
        ReArrangeList node2 = slow.next;
        slow.next = null;

        node2 = this.reverseList(node2);

        head = new ReArrangeList(0);

        ReArrangeList curr = head;

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


        head = head.next;

    }

    public ReArrangeList reverseList(ReArrangeList head){
        ReArrangeList prev = null;
        ReArrangeList curr = head;
        ReArrangeList next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

class ReArrangeList{
    int data;
    ReArrangeList next;

    ReArrangeList(int data){
        this.data = data;
        this.next = null;
    }

}

