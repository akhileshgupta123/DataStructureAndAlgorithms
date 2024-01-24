package LinkedList;

public class LinkedListCycleDetect {
    LinkedListCycle head;
    public static void main(String args[]){
        LinkedListCycleDetect obj = new LinkedListCycleDetect();
        obj.head = new LinkedListCycle(1);
        obj.head.next = new LinkedListCycle(2);
        obj.head.next.next = new LinkedListCycle(3);
        obj.head.next.next.next = new LinkedListCycle(4);
        obj.head.next.next.next.next = new LinkedListCycle(5);
        obj.head.next.next.next.next.next = obj.head.next;
        boolean result = obj.hasCycle(obj.head);

        System.out.println("result is :"+result);

    }

    private boolean hasCycle(LinkedListCycle head){
        if(head==null)
            return false;

        LinkedListCycle slow = head;
        LinkedListCycle fast = head.next;
        while(fast!=null && fast.next!=null){
            if(slow==fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}

class LinkedListCycle{
    int data;
    LinkedListCycle next;

    public LinkedListCycle(int data){
        this.data = data;
        this.next = null;
    }
}