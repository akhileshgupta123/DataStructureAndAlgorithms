//Linked List finding middle element
public class LinkedListMiddleElement {
    public static void main(String args[]){
        MiddleNodeList head = new MiddleNodeList(1);
        head.next = new MiddleNodeList(2);
        head.next.next = new MiddleNodeList(3);
        head.next.next.next = new MiddleNodeList(4);
        head.next.next.next.next = new MiddleNodeList(5);

        LinkedListMiddleElement obj = new LinkedListMiddleElement();
        int result = obj.findMiddleElement(head);
        System.out.println("result is :"+result);
    }

    private int findMiddleElement(MiddleNodeList head){
        if (head == null)
            return -1;

        MiddleNodeList slowPtr = head;
        MiddleNodeList fastPtr = head;

        while(fastPtr!=null && fastPtr.next!=null){

            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr.data;
    }
}

class MiddleNodeList{
    int data;
    MiddleNodeList next;
    MiddleNodeList(int data){
        this.data = data;
    }

}
