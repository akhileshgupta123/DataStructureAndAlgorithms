package StackQueue;
import java.util.*;

public class LargestRectangleArea {
    public static void main(String args[]){
        //int heights[]=new int[] {2,1,5,6,2,3};
        int heights[]=new int[] {2,4,10};
        LargestRectangleArea obj = new LargestRectangleArea();
        int result = obj.rectangleArea(heights);
        System.out.println("The rectangle area is:"+result);
    }

    private int rectangleArea(int heights[]){
        int n = heights.length;
        if(n==0)
            return 0;
        int maxArea = 0;

        Stack<Integer> ms = new Stack<Integer>();

        for(int i=0; i<=n; i++){

            int height= i==n?0:heights[i];
            //int height=heights[i];
            System.out.println("<<<       i: " + i + " height: " + height);

            while(!ms.isEmpty()  && height < heights[ms.peek()]){
                int j= ms.pop();
                System.out.println("<<<       j: " + j);

                int width = ms.isEmpty()?i:i-ms.peek()-1;
                System.out.println("<<<   width: " + width);

                int area = heights[j] * width;

                System.out.println("<<<    area: " + area);

                maxArea = Math.max(maxArea,area);
                System.out.println("<<< maxArea: " + maxArea);

            }

            // **** push current index ****
            ms.push(i);

            // ???? ????
            System.out.println("<<<      ms: " + ms.toString());
            
        }

        return maxArea;


    }
}
