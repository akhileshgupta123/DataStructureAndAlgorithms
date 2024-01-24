package StringProblem;
import java.util.*;
//1573. Number of Ways to Split a String
public class SplitStringWay {
    public static void main(String args[]){
        SplitStringWay obj = new SplitStringWay();
        //String s = "10101";
        String s = "0000";

        int result = obj.numberOfWays(s);
        System.out.println("result is:"+result);
    }

    private int numberOfWays(String str){

        ArrayList<Integer> list = new ArrayList<Integer>();
        long len = str.length();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='1'){
                list.add(i);
            }
        }
        System.out.println("list"+list.size());
        System.out.println("list"+list.size()%3);
        if(list.size()%3!=0){
            return 0;
        }
        long mod=1_000_000_007;
        if(list.size()==0){
            System.out.println("first is"+(len-1));
            System.out.println("first is"+(len-2));
            return (int)((((len-1)*(len-2))/2)%mod);
        }
        int k = list.size()/3;
        System.out.println("k:"+k);
        long ways = 1;
        for(int i=k-1; i<list.size()-1; i+=k){
            System.out.println(list.get(i));
            System.out.println(list.get(i+1));
            ways*=list.get(i+1)-list.get(i);
        }

        System.out.println("ways:"+ways);
        return (int)((ways)%mod);

    }
}
