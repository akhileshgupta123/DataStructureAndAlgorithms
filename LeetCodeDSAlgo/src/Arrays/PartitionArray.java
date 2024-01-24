package Arrays;
import java.util.*;
public class PartitionArray {

    public static void main(String args[]){
        int n = 5;
        int item[] = {1,2,3,0,3};
        //int n = 4;
        //int item[] = {0, 1, -1, 0};


        PartitionArray obj =  new PartitionArray();
        obj.countway(item,n);
    }

    private int countway(int item[], int size){
        int cnt[] = new int[size];
        int sum = 0;

        for(int i=0; i<size; i++){
            sum += item[i];
        }

        System.out.println("sum is:"+sum);
        if(sum % 3 !=0)
            return 0;

        sum /= 3;

        System.out.println("final sum is:"+sum);

        int ss = 0;

        for(int i = size-1; i>=0; i--){
            ss += item[i];
            if(ss == sum){
                cnt[i] = 1;
            }

            System.out.println("each item:"+ss);
        }

        System.out.println("each item:"+Arrays.toString(cnt));


        for(int i=size-2;i>=0;i--){
            cnt[i] += cnt[i + 1];
        }

        System.out.println("each item:"+Arrays.toString(cnt));

        int ans = 0;
        ss = 0;

        for (int i = 0 ; i< size-2 ; i++)
        {
            ss += item[i];
            if (ss == sum)
                ans += cnt[i + 2];
        }

        System.out.println("#######the ans is :"+ans);
        return ans;

    }
}
