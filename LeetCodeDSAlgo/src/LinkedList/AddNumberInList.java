package LinkedList;
//2. Add Two Numbers
class NumberListNode{
    int val;
    NumberListNode next;

    NumberListNode(int x){
        this.val = x;
    }
}
public class AddNumberInList {

    public NumberListNode addTwoNumber(NumberListNode l1, NumberListNode l2){
        NumberListNode res = new NumberListNode(-1);
        NumberListNode tail = res;
        int carry =0;

        while(l1!=null || l2!=null || carry!=0){
            int x1 = l1==null ?0:l1.val;
            int x2 = l2==null ?0:l2.val;
            tail.next = new NumberListNode((x1+x2+carry)%10);
            System.out.println("mod"+(x1+x2+carry)%10);
            carry = (x1+x2+carry)/10;
            System.out.println("carry"+carry);
            tail =tail.next;
            if(l1!=null)
                l1=l1.next;

            if(l2!=null)
                l2=l2.next;
        }

        return res.next;
    }

    public static void main(String args[]){
        AddNumberInList obj = new AddNumberInList();

        NumberListNode l1 = new NumberListNode(2);
        l1.next = new NumberListNode(4);
        l1.next.next = new NumberListNode(3);


        NumberListNode l2 = new NumberListNode(5);
        l2.next = new NumberListNode(6);
        l2.next.next = new NumberListNode(4);
        NumberListNode result = obj.addTwoNumber(l1,l2);

        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}
