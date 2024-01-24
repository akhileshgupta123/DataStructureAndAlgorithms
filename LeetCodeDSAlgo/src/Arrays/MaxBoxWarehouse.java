package Arrays;
import java.util.*;
//1564. Put Boxes Into the Warehouse I
public class MaxBoxWarehouse {
    public static void main(String args[]){
        MaxBoxWarehouse obj = new MaxBoxWarehouse();
        int boxes[] = new int[]{4,3,4,1};
        int warehouse[] = new int[]{5,3,3,4,1};

        int result = obj.maxBoxInWarehouse(boxes,warehouse);
        System.out.println(result);
    }

    private int maxBoxInWarehouse(int[] boxes, int[] warehouse){
        int roomsCount = warehouse.length;
        int[] validWarehouse = new int[roomsCount];
        validWarehouse[0] = warehouse[0];
        for (int i = 1; i < roomsCount; i++) {
            validWarehouse[i] = Math.min(validWarehouse[i - 1], warehouse[i]);
            System.out.println(validWarehouse[i]);
        }


        int maxBoxes = 0;
        Arrays.sort(boxes);
        int boxesCount = boxes.length;
        //System.out.println(boxes[0]);

        for (int i = 0, j = roomsCount - 1; i < boxesCount && j >= 0; i++) {
            while (j >= 0 && boxes[i] > validWarehouse[j])
                j--;
            if (j >= 0 && boxes[i] <= validWarehouse[j]) {
                maxBoxes++;
                j--;
            }
        }
        return maxBoxes;
    }
}
