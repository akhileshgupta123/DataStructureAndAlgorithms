package StackQueue;
import java.util.*;
public class QueueRemoval {
    public static void main(String args[]){
        QueueRemoval obj = new QueueRemoval();
        int arr[] = new int[]{1, 2, 2, 3, 4, 5};
        int x = 5;

        int result[] = obj.findPositions(arr, x);

        for(int i =0; i<result.length; i++){
            System.out.println(result[i]);
        }

    }

    private int[] findPositions(int[] arr, int x){
        int[] result = new int[x];
        Queue<Position> positions = new LinkedList<Position>();
        for (int i = 0; i < arr.length; i++) {
            positions.add(new Position(i + 1, arr[i]));
        }

        List<Position> popped = new ArrayList<Position>();
        int pass = 0;
        for (int i = 0; i < x; i++) {

            popped = new ArrayList<Position>();
            for (int j = 0; j < x && !positions.isEmpty(); j++) {
                popped.add(positions.poll());
            }


            int max = 0;
            int maxIdx = Integer.MAX_VALUE;
            for (Position p: popped) {
                if (p.val == max) {
                    maxIdx = Math.min(maxIdx, p.index);
                } else if (p.val > max) {
                    max = p.val;
                    maxIdx = p.index;
                }
            }

            result[pass++] = maxIdx;
            for (Position p: popped) {
                if (p.index != maxIdx){
                    Position next = p;
                    if(next.val!=0){
                        next.val = next.val -1;
                    }
                    positions.add(next);
                }
            }
        }
        return result;
    }
}

class Position{
    int index;
    int val;
    Position(int index, int val) {
        this.index = index;
        this.val = val;
    }
}
