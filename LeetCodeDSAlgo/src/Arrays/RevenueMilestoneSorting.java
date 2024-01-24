package Arrays;
import java.util.*;

public class RevenueMilestoneSorting {

    public static void main(String args[]){
        RevenueMilestoneSorting obj = new RevenueMilestoneSorting();
        int revenues[] =  new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int milestones[] = new int[] {100, 200, 500};

        System.out.println(revenues.length);
        int result[] = obj.getMileStoneDay(revenues, milestones);

        System.out.println(Arrays.toString(result));

    }

    private int[] getMileStoneDay(int revenues[], int milestones[]){
        int sum = 0;

        int ans[] = new int[milestones.length];



        HashMap<Integer,Integer> idx = new HashMap<Integer,Integer>();
        for(int i=0; i<milestones.length; i++){
            idx.put(milestones[i], i);
        }

        Arrays.sort(milestones);

        int m=0;
        for(int d=0; d<revenues.length; d++){
            sum += revenues[d];

            while((m<milestones.length) && (sum>=milestones[m])){

                ans[idx.get(milestones[m])] = d + 1;
                m++;
            }

        }
        return ans;

    }
}
