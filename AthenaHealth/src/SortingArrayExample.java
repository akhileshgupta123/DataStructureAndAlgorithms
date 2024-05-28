import java.util.PriorityQueue;
import java.util.*;
//[-1]
public class SortingArrayExample {

    public static void main(String args[]){
        int[] array = new int[]{10,5,2,1,6,7,9,100};
        //second and third highest element//  10, 9

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a-b;
            }
        });

        //size = 3

        for(int i=0; i<array.length; i++){
            if(pq.size()==3){
                int top = pq.peek();
                if(top<array[i]){
                    pq.remove();
                    pq.add(array[i]);
                }
            }else{
                pq.add(array[i]);
            }

        }

        //System.out.println("element pq size is:" + pq.size());\\



        System.out.println(pq);

        int result = findElement(1, pq);

        System.out.println("element second highest is:" + result);
    }

    public static int findElement(int indexElement, PriorityQueue<Integer> pq ){
        int result = -1;

        int top = pq.size()-indexElement;


        while(!pq.isEmpty() && top>=0){
            result = pq.poll();
            System.out.println(result);
            top--;
        }

        return result;

    }
}
