package LinkedList;
import java.util.*;
//1291. Sequential Digits
public class SequentialDigit {
    public static void main(String args[]){
        SequentialDigit obj = new SequentialDigit();
        //int low = 100, high = 300;
        int low = 1000, high = 13000;
        List<Integer> result = obj.sequentialDigits(low,high);
        System.out.println(result);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> res = new ArrayList<>();
        int nl = String.valueOf(low).length();
        int nh = String.valueOf(high).length();

        for(int i = nl; i <= nh; i++){
            System.out.println("i is:"+i);
            for(int j = 0; j < 10 - i; j++){
                int num = Integer.parseInt(digits.substring(j, j + i));
                System.out.println(num);
                if(num >= low && num <= high) res.add(num);
            }
        }
        return res;
    }
}
