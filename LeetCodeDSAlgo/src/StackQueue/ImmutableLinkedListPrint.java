package StackQueue;
import java.util.*;
//1265. Print Immutable Linked List in Reverse
interface ImmutableListNode {
      public void printValue(); // print the value of this node.
      public ImmutableListNode getNext(); // return the next node.
 }
public class ImmutableLinkedListPrint {

    public void printLinkedListInReverse(ImmutableListNode head) {
        Stack<ImmutableListNode> stack = new Stack();
        ImmutableListNode current = head;
        while(current!=null){
            stack.push(current);
            current = current.getNext();
        }
        while(!stack.isEmpty())
            stack.pop().printValue();
    }
}
