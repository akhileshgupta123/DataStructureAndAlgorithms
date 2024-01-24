package Arrays;
import java.util.*;
//1630. Arithmetic Subarrays
public class ArithmeticSubarray {
    public static void main(String args[]){
        ArithmeticSubarray obj = new ArithmeticSubarray();
        int nums[] = new int[]{4,6,5,9,3,7};
        int l[] = new int[]{0,0,2};
        int r[] = new int[]{2,3,5};

        List<Boolean> resultList =  obj.checkArithmeticSubArray(nums,l,r);

        System.out.println(resultList);
    }

    private List<Boolean> checkArithmeticSubArray(int[] nums, int[] l, int[] r){
        List<Boolean> res = new ArrayList<Boolean>();
        for(int i=0; i<l.length; i++){
            res.add(this.check(nums, l[i], r[i]));
        }
        return res;
    }

    private boolean check(int nums[], int l, int r){
        if (r - l < 2) {
            return true;
        }

        Set<Integer> s = new HashSet<Integer>();
        int mx = Integer.MIN_VALUE;
        int mi = Integer.MAX_VALUE;

        for (int i = l; i <= r; ++i) {
            s.add(nums[i]);
            mx = Math.max(mx, nums[i]);
            mi = Math.min(mi, nums[i]);
        }

        if ((mx - mi) % (r - l) != 0) {
            return false;
        }

        int delta = (mx - mi) / (r - l);

        System.out.println("mi"+mi);
        System.out.println("delta"+delta);
        for(int i=l; i<=r-l; i++){

            if(!s.contains(mi+delta*i)){
                return false;
            }
        }

        return true;
    }
}
