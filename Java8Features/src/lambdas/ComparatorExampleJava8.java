package lambdas;
import java.util.*;

/*
Lambdas
Same As Function
        Call it as Anonymous block
        Parameters
        Body
        Return Type
        Not tied with class
Can be assigned to a variable
                ()[Input] ->[Token] ()[Body]

*/
public class ComparatorExampleJava8 {
    public static void main(String args[]){
        //After Lambda

        Comparator<Integer> c1 = (Integer x, Integer y) -> x.compareTo(y);
        System.out.println("Comparator1 Java8: " + c1.compare(25, 15)); //1

        Comparator<Integer> c2 = (x, y) -> {
            return x.compareTo(y);
        };
        System.out.println("Comparator2 Java8: " + c2.compare(15, 25)); //-1
    }
}
