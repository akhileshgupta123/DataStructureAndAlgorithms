package Arrays;

public class DuplicateSinglePass {

    public static void main(String args[]){
        //int[] arr = { 1, 2, 3, 5, 4 , 1};
        int[] arr = {  3, 4, 1, 4, 1};

        int dup = findDuplicate(arr);

        System.out.println("the duplicate is :"+dup);
    }

    static int findDuplicate(int arr[]){
        int slow = arr[0];
        int fast = arr[arr[0]];

        System.out.println("initial slow ptr :"+slow);
        System.out.println("initial fast ptr :"+fast);
        while(slow!= fast){
            slow = arr[slow];
            fast = arr[arr[fast]];

            System.out.println("inside slow :"+slow);
            System.out.println("inside fast :"+fast);
        }


        fast = 0;
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];

            System.out.println("inside second slow :"+slow);
            System.out.println("inside second fast :"+fast);
        }

        System.out.println("final slow ptr :"+slow);
        System.out.println("final fast ptr :"+fast);

        if(slow==0) return -1;
        return slow;
    }
}
