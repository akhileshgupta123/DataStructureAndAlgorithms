import java.util.*;
public class TestExample {
    public static void main(String args[]){
        int[] array = new int[] {2,3,3,5,6,8,9,15};
        HashSet<Integer> missingNumberSet = new HashSet<Integer>();
        for(int i=0; i<array.length-1; i++){
            if(array[i]!= array[i+1] && array[i+1] != array[i]+1){
                int counter = 1;
                while(array[i]+counter<array[i+1]){
                    missingNumberSet.add(array[i]+counter);
                    counter++;
                }
            }
        }

        System.out.println(missingNumberSet);
    }
}
