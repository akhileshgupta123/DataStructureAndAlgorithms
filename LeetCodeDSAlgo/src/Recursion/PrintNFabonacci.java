package Recursion;
import java.util.*;
public class PrintNFabonacci {
    List<Integer> resultList = new ArrayList<Integer>();
    public static void main(String args[]){
        PrintNFabonacci obj = new PrintNFabonacci();

        for(int i=1; i<=3; i++){
            int result = obj.NFabonacci(i);
            obj.resultList.add(result);
        }

        System.out.println(obj.resultList);
    }

    private int NFabonacci(int n){
        if(n==2) {
            //System.out.print(" here 1 ,");
            return 1;
        }
        else if(n==1) {
            //System.out.print("here 0 ,");
            return 0;
        }
        else {
            //int result = NFabonacci(n - 1) + NFabonacci(n - 2);
            //this.resultList.add(result);
            //System.out.print(result + " ,");
            return NFabonacci(n - 1) + NFabonacci(n - 2);
        }
    }
}
