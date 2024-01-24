package LinkedList;
//234. Palindrome Linked List
public class PalindromeLinkedList {
    public static void main(String args[]){
        PalindromeLinkedList obj = new PalindromeLinkedList();



        PalindromeNode l1 = new PalindromeNode(1);
        l1.next = new PalindromeNode(2);
        l1.next.next = new PalindromeNode(5);
        l1.next.next.next = new PalindromeNode(2);
        l1.next.next.next.next = new PalindromeNode(1);

        boolean result = obj.isPalindrome(l1);

        System.out.println(result);
    }

    public boolean isPalindrome(PalindromeNode head){
        PalindromeNode fast = head.next;
        PalindromeNode slow = head;
        PalindromeNode first = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        PalindromeNode second = reverse(slow.next);
        slow.next = null;

        while(first!=null && second!=null){
            if(first.val!=second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public PalindromeNode reverse(PalindromeNode head){
        PalindromeNode prev = null;

        while(head!=null){
            PalindromeNode temp = head.next;
            head.next=prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}


class PalindromeNode{
    int val;
    PalindromeNode next;

    PalindromeNode() {}
    PalindromeNode(int val) { this.val = val; }
    PalindromeNode(int val, PalindromeNode next) { this.val = val; this.next = next; }
}
