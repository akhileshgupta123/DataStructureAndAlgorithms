package Arrays;
import java.util.*;

public class CountingTriangle {

    public static void main(String args[]){
        CountingTriangle obj = new CountingTriangle();
        List<Sides> sideList = new ArrayList<Sides>();

        sideList.add(new Sides(2,2,3));
        sideList.add(new Sides(3,2,2));
        sideList.add(new Sides(2,5,6));
        int result = obj.countDistinctTriangle(sideList);

        System.out.println("the result is :"+result);
    }

    int countDistinctTriangle(List<Sides> arr){
        int count = 0;
        int n = arr.size();

        Set<String> uniqueSet = new HashSet<String>();

        for(int i=0; i<arr.size(); i++){
            Sides t = arr.get(i);
            int sideArr[] = new int[]{t.a, t.b, t.c};
            Arrays.sort(sideArr);
            String key = Arrays.toString(sideArr);

            System.out.println("the key is :"+key);
            uniqueSet.add(key);

        }
        return uniqueSet.size();
    }



}

class Sides{
    int a;
    int b;
    int c;
    Sides(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
