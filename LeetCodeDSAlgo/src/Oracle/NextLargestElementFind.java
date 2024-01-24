package Oracle;
import java.util.*;
//https://www.geeksforgeeks.org/next-greater-element/
//Time Complexity: O(N)
//        Auxiliary Space: O(N)
public class NextLargestElementFind {
    public static void main(String args[]){
        int[] arr = { 6, 8, 0, 1, 3 };
        int n = 5;

        NextLargestElementFind obj = new NextLargestElementFind();
        obj.nextLargestElement(arr,n);
        //for (int i = 0; i < n; i++)
          //  System.out.print(arr[i] + " ");
    }

    public void nextLargestElement(int[] arr, int n){

        Stack<Integer> item = new Stack<Integer>();

        item.push(arr[0]);

        int element, next;


        for (int i = 1; i < n; i++) {
            next = arr[i];
            if(!item.isEmpty()){
                element = item.pop();

                while (element < next){
                    System.out.println(element + " --> "
                            + next);

                    if (item.isEmpty() == true)
                        break;


                    element = item.pop();

                }

                if (element > next)
                    item.push(element);

            }



            item.push(next);

        }

        while (!item.isEmpty()) {
            element = item.pop();
            next = -1;
            System.out.println(element + " -- " + next);
        }

    }
}
