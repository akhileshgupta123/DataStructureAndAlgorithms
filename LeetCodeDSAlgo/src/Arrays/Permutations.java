package Arrays;
import java.util.*;

public class Permutations {
    public static void main(String args[]){

        Permutations obj = new Permutations();
        String result = obj.getPermutations(4, 17);

        System.out.println("the result is:"+result);
    }

    public String getPermutations(int n, int k){

        ArrayList<Integer> numberList = new ArrayList<Integer>();

        for(int i=1; i<=n; i++){
            numberList.add(i);
        }

        // set factorial of n
        int mod = 1;
        for (int i = 1; i <= n; i++) {
            mod = mod * i;
        }

        System.out.println("mod is:"+mod);
        System.out.println(numberList);

        String result = "";

        k--;
        // find sequence
        for (int i = 0; i < n; i++) {

            System.out.println("+++++++++++++++++++++++++++++="+(n-i));
            mod = mod / (n - i);

            System.out.println(" the mod is:"+mod);
            // find the right number(curIndex) of
            int curIndex = k / mod;
            // update k
            k = k % mod;

            System.out.println(" the k is:"+k);

            System.out.println(" the cur index is:"+curIndex);

            // get number according to curIndex
            result += numberList.get(curIndex);
            // remove from list
            numberList.remove(curIndex);

            System.out.println("final list: "+numberList);
        }

        return result.toString();

    }
}
