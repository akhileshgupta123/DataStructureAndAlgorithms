package Grind75;

public class MergeList {
    int val;
    MergeList next;
    MergeList(){

    }
    MergeList(int val){
        this.val = val;
    }
    MergeList(int val,MergeList next){
        this.val = val;
        this.next = next;
    }
}
