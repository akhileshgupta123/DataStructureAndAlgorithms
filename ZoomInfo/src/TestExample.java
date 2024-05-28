import java.util.*;

public class TestExample {

    public static void main(String args[]){
        String str1 = "ohms";
        String str2 = "ms";

        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
                public int compare(String item1, String item2){
                   return item1.compareTo(item2);
        }
        });

        pq.add(str1);
        pq.add(str2);

        System.out.println(pq.poll());

    }
}
