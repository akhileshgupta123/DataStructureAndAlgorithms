package LinkedList;

public class ReverseEvenNumber {
    public static void main(String args[]){
        //int arr[] = {1, 2, 3, 3, 4, 6, 8, 5};
        int arr[] = {1, 2, 8, 9, 7, 12, 16, 20};
        int n = arr.length;
        ReverseEvenNumber obj = new ReverseEvenNumber();

        ReverseNode head = null;
        ReverseNode p = null;
        for (int i = 0; i < n; i++){
            if(head==null){
                p = new ReverseNode(arr[i]);
                head = p;
                continue;
            }else{

                p.next = new ReverseNode(arr[i]);
                p = p.next;
            }
        }

        System.out.println("before start node");
        obj.printList(head);
        System.out.println("after start node");
        //ReverseEvenNumber obj = new ReverseEvenNumber();
        head = obj.reverse(head);
        obj.printList(head);

    }

    ReverseNode reverse(ReverseNode head){
        ReverseNode dummy = new ReverseNode(0);
        dummy.next = head;
        ReverseNode prev = dummy;
        ReverseNode curr = head;
        while (curr != null) {

            if (curr.data % 2 == 0) {
                prev.next = reverseOdd(curr);
            }

            prev = curr;
            curr = curr.next;
            if(curr!=null){
                System.out.println("inner"+curr.data);
            }
        }
        return dummy.next;
    }

    ReverseNode reverseOdd(ReverseNode head){
        ReverseNode prev = null;
        ReverseNode curr = head;
        while (curr != null && curr.data % 2 == 0) {
            ReverseNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        //System.out.println("####"+curr.data);
        head.next = curr;
        return prev;
    }



    private void printList(ReverseNode head){
        while (head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }


    }




}

class ReverseNode {
    int data;
    ReverseNode next;

    ReverseNode(int data){
        this.data = data;
        this.next = null;
    }
}
