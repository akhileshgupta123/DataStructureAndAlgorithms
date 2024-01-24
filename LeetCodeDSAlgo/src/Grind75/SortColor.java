package Grind75;
//75. Sort Colors
public class SortColor {
    public static void main(String args[]){
        int[] nums = new int[]{2,0,2,1,1,0};

        SortColor obj = new SortColor();
        obj.sortcolor(nums);

        for(int i : nums){
            System.out.println(i);
        }

    }

    public void sortcolor(int[] nums){
        int p = -1; // last index of 0;
        int q = nums.length; // first index of 2.
        int k = p + 1;
        while(k < q){
            switch(nums[k]){
                case 0:
                    swap(nums, ++p, k);
                    k++;
                    break;
                case 1:
                    k++;
                    break;
                case 2:
                    swap(nums, k, --q);
                    k++;
                    break;

            }
        }

    }

    private void swap(int[] nums, int x, int y){
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
