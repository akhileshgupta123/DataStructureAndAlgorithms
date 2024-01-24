package Grind75;

public class MergeLinkedList {
    public static void main(String args[]){
        MergeList l1 = new MergeList(1);
        l1.next = new MergeList(2);
        l1.next.next = new MergeList(4);
        MergeList l2 = new MergeList(1);
        l2.next = new MergeList(3);
        l2.next.next = new MergeList(4);

        MergeLinkedList obj = new MergeLinkedList();
        //MergeList result = obj.usingVariableMergeTwoList(l1,l2);

        MergeList result = obj.mergeTwoList(l1,l2);
        while(l2!=null){
            System.out.println(l2.val);
            l2 = l2.next;
        }

    }


    public MergeList mergeTwoList(MergeList l1 , MergeList l2 ){

        if(l1 == null) return l2;
        if(l2 == null) return l1;


        //if(l1!=null && l2!=null){
            if(l1.val<l2.val){
                l1.next = mergeTwoList(l1.next, l2);
                return l1;
            }else{
                l2.next = mergeTwoList(l1, l2.next);
                return l2;
            }
        //}
       /* if(l1==null)
            return l2;

        return l1;*/

    }

    public MergeList usingVariableMergeTwoList(MergeList l1 , MergeList l2){
        MergeList list3 = new MergeList(-1);
        MergeList temp =  list3;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }


        while(l1!=null){
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }

        while(l2!=null){
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }

        return list3.next;

    }
}
