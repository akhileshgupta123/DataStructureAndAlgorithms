package StackQueue;
import java.util.*;
//difficult question
public class MinimizePermutations {

    public static void main(String args[]){
        MinimizePermutations obj = new MinimizePermutations();
        //int arr[] = {3,1,2};
        //int arr[] = {1,2,4,3};
        int arr[] = {4,3,5,1,2};
        int result = obj.minOperations(arr);

        System.out.println("result"+result);
    }

    private int minOperations(int arr[]){
        int result = 0;
        int n = arr.length;
        String start = "";
        String destination = "";
        String original = "";
        String modified = "";
        Node temp = null;
        for (int i = 0; i < n; i++)
            start += arr[i];

        System.out.println("the start is:"+start);

        Arrays.sort(arr);

        for (int i = 0; i < n; i++)
            destination += arr[i];

        System.out.println("the destination is:"+destination);
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0));



        while(!queue.isEmpty()){
            temp = queue.poll();
            System.out.println("start size:"+queue.size());

            // store the original string at this step
            original = temp.string;

            for (int j = 2; j <= n; j++){
                modified = original;

                // generate the permutation by reversing
                modified = reverse (modified , j);

                System.out.println("modified:"+modified);
                System.out.println("curr step:"+temp.steps);


                if (modified.equals(destination))
                {
                    // if string match then return
                    // the height of the current node
                    return temp.steps+1;
                }

                queue.add(new Node(modified,temp.steps + 1));

            }

            System.out.println("end size:"+queue.size());

        }

        return result;
    }



    public  String reverse (String s , int index)
    {
        char temp []= s.toCharArray();
        int i = 0;
        while (i < index)
        {
            char c = temp[i];
            temp[i] = temp[index-1];
            temp[index-1] = c;
            i++;index--;
        }
        return String.valueOf(temp);
    }

    class Node{
        public String string ;
        public int steps;

        public Node(String string,int steps) {
            this.string = string;
            this.steps = steps;
        }
    }
}
