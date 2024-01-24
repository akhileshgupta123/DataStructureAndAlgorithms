package Recursion;

public class NFabonacci {
    public static void main(String args[]){
        NFabonacci obj = new NFabonacci();

        int result = obj.NthFib(5);

        System.out.println("the result is :"+result);


    }

    private int NthFib(int n){
        if(n==2)
            return 1;
        else if(n==1)
            return 0;
        else
            return NthFib(n-1) + NthFib(n-2);

    }
}
