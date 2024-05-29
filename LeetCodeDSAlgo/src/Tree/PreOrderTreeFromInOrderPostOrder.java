package Tree;
import java.util.*;
//Preorder from Inorder and Postorder traversals
//Time Complexity: O(n).
//        Auxiliary Space: O(N),
public class PreOrderTreeFromInOrderPostOrder {

    static int postIndex;
    public static void main(String args[]){
        int[] in = new int[]{4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90};
        int[] post = new int[]{4, 12, 10, 18, 24, 22, 15, 31, 44, 35, 66, 90, 70, 50, 25};

        PreOrderTreeFromInOrderPostOrder obj = new PreOrderTreeFromInOrderPostOrder();
        obj.printPreOrder(in,post);
    }

    public void printPreOrder(int[] in , int[] post){
        int len = in.length;
        postIndex = len - 1;

        Stack<Integer> s = new Stack<Integer>();
        HashMap<Integer, Integer> hm =
                new HashMap<Integer, Integer>();

        for(int i=0;i<in.length; i++){
            hm.put(in[i], i);
        }

        fillPre(in, post, 0, len - 1, s, hm);

        while (s.empty() == false)
            System.out.print(s.pop() + " ");

    }


    public void fillPre(int[] in, int[] post, int inStart, int inEnd, Stack<Integer> s, HashMap<Integer, Integer> hm){
        if(inStart>inEnd){
            return;
        }

        int val = post[postIndex];
        int inIndex = hm.get(val);
        postIndex--;



        System.out.println("here postIndex"+postIndex);
        fillPre(in, post,inIndex+1, inEnd,s,hm);

        fillPre(in,post,inStart, inIndex-1, s, hm);

        System.out.println("postIndex"+postIndex);
        s.push(val);

    }
}
