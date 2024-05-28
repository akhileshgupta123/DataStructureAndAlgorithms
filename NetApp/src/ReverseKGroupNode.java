//25. Reverse Nodes in k-Group
public class ReverseKGroupNode {
    public static void main(String args[]){
        int k=2;
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        ReverseKGroupNode obj = new ReverseKGroupNode();
        ListNode result = obj.reverseKGroup(root,2);

        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }



    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;


        ListNode curr = dummy,nex = dummy,pre = dummy;

        int count=0;

        while(curr.next!=null){
            curr = curr.next;
            count++;
        }

        int reverseCount = count / k;

        ListNode node = dummy;

        while (reverseCount > 0) {
            node = reverse(node, k);
            reverseCount--;
        }


        return dummy.next;
    }

    public ListNode reverse(ListNode node, int k) {
        ListNode curr = node.next;
        ListNode tail = null;
        ListNode reversed = null;

        while (k > 0 && curr != null) {
            ListNode newNode = curr.next;
            curr.next = reversed;
            reversed = curr;
            curr = newNode;
            if (reversed.next == null) {
                System.out.println("############here"+reversed.val);
                tail = reversed;
            }
            k--;
        }

        System.out.println("#######tail value"+tail.val);
        tail.next = curr;
        node.next = reversed;

        System.out.println("#######tail next value"+tail.next.val);
        return tail;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
