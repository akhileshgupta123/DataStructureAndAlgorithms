package StackQueue;
import java.util.*;
//1942. The Number of the Smallest Unoccupied Chair
public class SmallestChair {
    public static void main(String args[]){
        /*int[][] times = new int[][]{{1,4},{2,3},{4,6}};


        int targetFriend = 1;*/

        int[][] times = new int[][]{{3,10},{1,5},{2,6}};


        int targetFriend = 0;




        SmallestChair obj = new SmallestChair();
        int chair = obj.findSmallChair(times,targetFriend);
        System.out.println("chair is:"+chair);
    }

    private int findSmallChair(int[][] times, int targetFriend){
        int targetStart = times[targetFriend][0];
        //Arrays.sort(times,(a,b)-> a[0]-b[0]);
        Arrays.sort(times,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return (a[0] - b[0]);
            }
        });

        /*for(int a[]:times){
            System.out.println(a[0]);
            System.out.println(a[1]);
        }*/

        PriorityQueue<Integer> available = new PriorityQueue<Integer>();
        for (int i = 0; i < times.length; ++ i) {
            available.offer(i);
        }

        /*System.out.println(available.poll());
        System.out.println(available.poll());
        System.out.println(available.poll());*/

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return (a[0] - b[0]);
            }
        });

        for (int i = 0; i < times.length; ++ i) {
            while (!pq.isEmpty() && pq.peek()[0] <= times[i][0]) {
                System.out.println("here");
                available.offer(pq.poll()[1]);
            }

            if (times[i][0] == targetStart) {
                break;
            }

            pq.offer(new int[]{times[i][1], available.poll()});
        }
        System.out.println(available.size());
        return available.peek();
    }
}
