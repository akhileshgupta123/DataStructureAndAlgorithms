package StackQueue;
import java.util.*;
//42. Trapping Rain Water
public class RainWaterTrap {

    public static void main(String args[]){
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        RainWaterTrap obj = new RainWaterTrap();
        System.out.print(obj.maxWater(arr));

    }

    private int maxWater(int height[]){
        Stack<Integer> stack = new Stack<Integer>();
        int n = height.length;
        int ans=0;

        for(int i=0; i<n; i++){

            while((!stack.isEmpty())
            && (height[stack.peek()] < height[i]) ){
                System.out.println("#######the current index is"+i);

                System.out.println("#######the stack is"+stack);
                int pop_height = height[stack.peek()];

                System.out.println("#######height"+pop_height);
                stack.pop();

                if(stack.isEmpty())
                    break;

                int distance = i-stack.peek()-1;

                System.out.println("#######distance"+distance);


                int min_height
                        = Math.min(height[stack.peek()],
                        height[i])
                        - pop_height;
                ans += distance * min_height;

            }
            stack.push(i);

        }
        return ans;
    }
}
