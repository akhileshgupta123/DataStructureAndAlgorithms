import java.util.*;
//228. Summary Ranges
public class SummaryRange {
    public static void main(String args[]){
        int[] nums = new int[]{0,2,3,4,6,8,9};
        SummaryRange obj = new SummaryRange();
        List<String>  result = obj.summaryRanges(nums);
        System.out.println(result);
    }

    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> al=new ArrayList<String>();
        for(int i=0;i<nums.length;i++){
            int start=nums[i];
            while(i+1<nums.length && nums[i]+1==nums[i+1])
                i++;

            if(start!=nums[i]){
                al.add(""+start+"->"+nums[i]);
            }else{
                al.add(""+start);
            }

        }
        return al;
    }
}
