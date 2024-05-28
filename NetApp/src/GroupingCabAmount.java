//number of student in each group. the cab capacity is <=4 student. each cab charge 500/-. how many cab and money earn by cab.
import java.util.*;
public class GroupingCabAmount {
    public static void main(String args[]){
        //int group[] = new int[]{3,3,2,1,4};
        int group[] = new int[]{3,3,2,1,4,1,1,1,1};
        Arrays.sort(group);
        int left = 0;
        int right = group.length-1;
        int count = 0;
        while(left<=right){
            if(group[right]>4){
                right--;
            }else if(group[right]==4){
                count++;
                right--;
            }else if(group[right]+group[left]==4){
                count++;
                right--;
                left++;
            }else if(group[right]+group[left]>4){
                count++;
                right--;
            }else{
                int delta = 4-group[right];

                while(delta-group[left]>=0 && left<=right){
                    delta = delta = delta-group[left];
                    left++;
                }
                right--;
                count++;
            }
        }

        System.out.println("cab count is:"+count);

    }
}
