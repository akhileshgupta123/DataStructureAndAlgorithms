package StackQueue;
import java.util.*;
//84. Largest Rectangle in Histogram
public class LargestRectangleAreaEasy {
    public static void main(String args[]){
        LargestRectangleAreaEasy obj = new LargestRectangleAreaEasy();
        //int heights[]=new int[] {2,4,10};
        int heights[]=new int[] {2,1,5,6,2,3};
        int result = obj.getLargestRect(heights, heights.length);

        System.out.println("area is :"+result);
    }

    private int getLargestRect(int arr[], int size){
        if(size == 0)
            return 0;
        if(size == 1)
            return arr[0];

        Stack<Integer> st = new Stack<Integer>();
        int maxArea = 0;
        st.push(0);

        for(int i=1;i<size;i++){


            while(!st.isEmpty() && arr[st.peek()] > arr[i])
            {
                int curr = arr[st.pop()];

                if(st.isEmpty())
                    maxArea = Math.max(maxArea, curr*i);
                else
                {
                    System.out.println("curr:"+curr);
                    System.out.println("here:"+st.peek());
                    System.out.println("i:"+i);
                    maxArea = Math.max(maxArea, curr*(i-st.peek()-1));
                }
            }
            st.push(i);

        }

        if(!st.isEmpty())
        {
            int i = size;
            while(!st.isEmpty())
            {
                int curr = arr[st.pop()];
                if(st.isEmpty())
                    maxArea = Math.max(maxArea, curr*i);
                else {
                    int test = i-st.peek();

                    maxArea = Math.max(maxArea, curr * (i - st.peek() - 1));
                }
            }
        }

        return maxArea;

    }
}
