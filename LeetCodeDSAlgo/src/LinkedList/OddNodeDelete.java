package LinkedList;

public class OddNodeDelete {
    OddDeleteListNode node;
    public static void main(String args[]){
        OddNodeDelete obj = new OddNodeDelete();
        obj.node = new OddDeleteListNode(1);
        obj.node.next = new OddDeleteListNode(2);
        obj.node.next.next = new OddDeleteListNode(3);
        obj.node.next.next.next = new OddDeleteListNode(4);
        obj.node.next.next.next.next = new OddDeleteListNode(5);
        obj.node.next.next.next.next.next = new OddDeleteListNode(6);

        obj.deleteOddNode(obj.node);
        obj.display(obj.node);

    }

    public void display(OddDeleteListNode head){
        while(head!=null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    public void deleteOddNode(OddDeleteListNode head){
        if(head != null) {

            OddDeleteListNode temp = head;
            head = head.next;
            temp = null;
            this.node  =head;

            if(head != null) {
                OddDeleteListNode evenNode = head;
                OddDeleteListNode oddNode = head.next;
                while(evenNode != null && oddNode != null) {
                    evenNode.next = oddNode.next;
                    oddNode = null;
                    evenNode = evenNode.next;
                    if(evenNode != null)
                        oddNode = evenNode.next;
                }

            }

        }

    }
}


class OddDeleteListNode{
    int data;
    OddDeleteListNode next;
    public OddDeleteListNode(int data){
        this.data = data;
        this.next = null;
    }
}
