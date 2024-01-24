package StringProblem;
import java.util.*;

public class ZigZagExample {

    public static void main(String args[]){

        ZigZagExample obj = new ZigZagExample();
        //String mytest = obj.convert("GEEKSFORGEEKS", 3);
        String mytest = obj.convert("PAYPALISHIRING", 3);
        //String mytest = obj.convert("ABCD", 2);

        System.out.println("mytest is:"+mytest);
    }

    public String convert(String str, int numRows){
        StringBuilder sb = new StringBuilder();
        List<Character> rows[] = new ArrayList[numRows];
        int k=0;
        int direction = numRows == 1 ? 0 : -1;
        for (int i = 0; i < numRows; ++i)
            rows[i] = new ArrayList<>();

        for (final char c : str.toCharArray()) {
            System.out.println("K is:"+k);
            rows[k].add(c);

            if (k == 0 || k == numRows - 1)
                direction *= -1;

            System.out.println("direction is:"+direction);
            k += direction;
        }


        for (final List<Character> row : rows)
            for (final char c : row)
                sb.append(c);
        return sb.toString();

    }
}
