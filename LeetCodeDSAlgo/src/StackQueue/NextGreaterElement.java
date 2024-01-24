package StackQueue;
import java.util.*;
//503. Next Greater Element II
public class NextGreaterElement {

    public static void main(String args[]){

        NextGreaterElement obj = new NextGreaterElement();
        //int nums[] = new int[]{1,2,1};

        int nums1[] = new int[]{1,2,3,4,3};

        int result[] = obj.nextGeneratedElement(nums1);

        System.out.println("the final result is:");
        for(int m:result){
            System.out.println("arr element is:"+m);
        }
    }

    private int[] nextGeneratedElement(int nums[]){
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }

        Stack<Integer> sk = new Stack<Integer>();

        for (int i = 0; i < 2 * n - 1; i++) {
            System.out.println("inside loop");
            while (!sk.isEmpty() && nums[sk.peek()] < nums[i % n]) {
                System.out.println("element is:"+(i%n));
                System.out.println("setting element is:"+(sk.peek()));
                res[sk.pop()] = nums[i % n];
            }
            System.out.println("pushed element "+(i%n));
            sk.push(i % n);
        }

        System.out.println("stack size is "+sk.size());

        return res;
    }
}
