package Agoda;

public class LinkedListPalindrome {
    public static void main(String args[]){
        LinkedListPalindrome obj = new LinkedListPalindrome();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        boolean result = obj.isPalindrome(head);

        System.out.println(result);

    }


    public boolean isPalindrome(ListNode head){
        if( head.next==null){
            return true;
        }

        ListNode midNode= middleNode ( head);
        ListNode prev = null;
        ListNode curr= midNode;
        ListNode next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode left = head;
        ListNode right = prev;

        while(right!= null){
            if (right.val != left.val){
                return false;
            }
            left= left.next;
            right= right.next;
        }
        return true;

    }

    public ListNode middleNode(ListNode head){
        ListNode slow= head;
        ListNode fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

class ListNode{
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
