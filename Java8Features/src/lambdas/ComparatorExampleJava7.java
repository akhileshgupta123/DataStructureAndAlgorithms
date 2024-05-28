package lambdas;
import java.util.*;
public class ComparatorExampleJava7 {
    public static void main(String[] args){
        //Before Lambda

        Comparator<Integer> c1 = new Comparator<Integer>(){
            public int compare(Integer x, Integer y){
                return x.compareTo(y);
            }
        };

        System.out.println("Comparator Java7: " + c1.compare(7, 7));
    }
}
