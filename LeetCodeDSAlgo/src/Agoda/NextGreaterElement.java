package Agoda;
import java.util.*;
public class NextGreaterElement {

    public static void main(String args[]){
        NextGreaterElement obj  = new NextGreaterElement();

        int nums1[] = new int[]{4,1,2};
        int nums2[] = new int[]{1,3,4,2};
        int[] result = obj.nextElement(nums1, nums2);

        System.out.println(result);
        for(int i = 0; i<result.length ; i++){
            System.out.println(result[i]);
        }
    }

    public int[] nextElement(int num1[], int num2[]){

        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = num2.length-1; i>=0; i--){

            if(stack.isEmpty()) {
                // arr[i] = -1;
                map.put(num2[i], -1);
            }else if(!stack.isEmpty() && num2[i]< stack.peek()){
                // arr[i]= stack.peek();
                map.put(num2[i], stack.peek());
            }else{
                while(!stack.isEmpty() && num2[i]>= stack.peek()){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    // arr[i]= -1;
                    map.put(num2[i], -1);
                }
                else{
                    // arr[i] = stack.peek();
                    map.put(num2[i], stack.peek());
                }
            }

            stack.push(num2[i]);

        }

        int ans[] = new int[num1.length];
        for(int i=0; i<num1.length; i++){
            ans[i] = map.get(num1[i]);
        }
        return ans;

    }
}
