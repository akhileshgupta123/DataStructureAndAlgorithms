package Agoda;

public class UniaryBinarySearchTree {
    public static void main(String args[]){
        int n = 3;
        UniaryBinarySearchTree obj = new UniaryBinarySearchTree();
        int result = obj.numTrees(n);
        System.out.println("the result is:"+result);

    }

    public int numTrees(int n){
        int[] sol = new int[n+1];
        sol[0] = 1;

        for(int i=1; i<=n; i++){
            System.out.println("i is"+i);
            for(int j = 0; j < i; j++) {
                System.out.println("first:"+sol[j]);
                System.out.println("second:"+sol[i-j-1]);
                sol[i] += sol[j] * sol[i-j-1];
            }
        }
        return sol[n];
    }
}
