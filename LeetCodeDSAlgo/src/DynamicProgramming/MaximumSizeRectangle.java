package DynamicProgramming;
import java.util.*;
//Max Rectangle in Binary Matrix
/*
Time Complexity: O(R x C).
        Only one traversal of the matrix is required, so the time complexity is O(R X C)
        Space Complexity: O(C).
        Stack is required to store the columns, so so space complexity is O(C)*/
public class MaximumSizeRectangle {
    public static void main(String args[]){
        int R = 4;
        int C = 4;
        int A[][] = new int[][]{{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};

        MaximumSizeRectangle obj = new MaximumSizeRectangle();
        obj.maxRectangle(R,C,A);

    }

    private int maxRectangle(int R, int C, int A[][]){
        int result = maxHist(R, C, A[0]);
        System.out.println("the max area result is :"+result);

        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++){
                if (A[i][j] == 1)
                    A[i][j] = A[i][j] + A[i - 1][j];

            }
            System.out.println("@@@@@@@@@the array is :"+ A[i][0]+ " "+ A[i][1] + " "+A[i][2]+ "  "+A[i][3]);
            int temp = maxHist(R, C, A[i]);
            System.out.println("#########max area for row "+ i + "is :"+temp);
            result = Math.max(result,temp);

        }
        return result;
    }

    private int maxHist(int R, int C, int row[]){
        Stack<Integer> result = new Stack<Integer>();
        int top_val;
        int max_area = 0;
        int area = 0;
        int i = 0;
        while(i<C){
            if(result.isEmpty() || row[result.peek()] <= row[i]){
                System.out.println("when:"+i);
                result.push(i);
                i++;
            }else{
                System.out.println("else:"+i);
                top_val = row[result.peek()];
                result.pop();
                area = top_val*i;
                System.out.println("inside else area before if :"+area);
                if(!result.isEmpty()){
                    area = top_val * (i - result.peek() - 1);
                    System.out.println("inside else area after if :"+area);
                }
                max_area = Math.max(area, max_area);
            }
        }
        /*
        System.out.println("value of i:"+i);
        while(!result.isEmpty()){
            System.out.println("inside while max_area:"+max_area);
            System.out.println("inside while:"+result.peek());
            top_val = row[result.peek()];
            result.pop();
            area = top_val*i;
            System.out.println("inside while area:"+area);
            if(!result.isEmpty()){
                area = top_val * (i-result.peek()-1);
            }
            max_area = Math.max(area, max_area);
        }*/

        return max_area;
    }
}
