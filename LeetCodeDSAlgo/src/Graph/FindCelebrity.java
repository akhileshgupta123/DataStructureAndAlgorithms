package Graph;
//LeetCode 277. Find the Celebrity
import java.util.*;
public class FindCelebrity {
    public static void main(String args[]){
        //int[3][3] array = new int[3][3]{{0,1,0}{0,0,0}{0,1,0}};
        //int[][] array = new int[][]{{0,1,0},{0,0,0},{0,1,0}};
        int[][] array = new int[][]{{1,1,0},{0,1,0},{1,1,1}};
        //int[][] array = new int[][]{{1,0,1},{1,1,0},{0,1,1}};



        int n = 3;

        FindCelebrity  obj = new FindCelebrity();
        int result = obj.getId(array,n);
        System.out.println(result);

    }

    public int getId(int[][] array, int n){
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i<n; i++){
            s.push(i);
        }

        while(s.size()>1){
            int a = s.pop();
            int b = s.pop();
            System.out.println("a:"+a);
            System.out.println("b:"+b);
            System.out.println(array[a][b]);
            if(array[a][b]==0){
                s.push(a);
            }else{
                s.push(b);
            }

        }

        int x = s.pop();
        System.out.println("alast element:"+x);
        boolean flag = true;
        for(int i=0; i<n; i++){
            if(i==x)
                continue;
            if(array[x][i]==1 || array[i][x]==0)
                flag = false;
        }

        if(!flag)
            return -1;

        return x;
    }
}
