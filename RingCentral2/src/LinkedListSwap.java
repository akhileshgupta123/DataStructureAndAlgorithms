public class LinkedListSwap {
    public static void main(String args[]){
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
       root =  swap(root);
       display(root);
    }

    private static void display(ListNode root){
        while(root!=null){
            System.out.print(root.val +"->");
            root = root.next;
        }
    }

    private static ListNode swap(ListNode root){
        ListNode prev = new ListNode(0);
        ListNode temp;
        ListNode curr = root;
        ListNode result = prev;
        while(curr!=null && curr.next!=null){
            ListNode second = curr.next;
            temp = second.next;
            curr.next = temp;
            second.next = curr;
            prev.next = second;
            prev = curr;
            curr = temp;
        }
        return result.next;
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
