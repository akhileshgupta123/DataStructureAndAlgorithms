package StringProblem;
import java.util.*;
public class MaxConsecutiveSubStringDiff {
    public static void main(String args[]){
        MaxConsecutiveSubStringDiff obj = new MaxConsecutiveSubStringDiff();
        String str = "abbcdebbbh";
        //String str = "aaaa";
        //MaxConsecutiveSubStringDiff obj = new MaxConsecutiveSubStringDiff();
        int result = obj.getSubStringDifference(str);
        System.out.println(result);
    }

    private int getSubStringDifference(String str){
        char ch[] = str.toCharArray();
        int max = 0;
        int current = 0;
        int prev = 0;
        Set<Character> itemSet = new HashSet<Character>();
        for(int i=0; i<ch.length;i++){
            if(itemSet.contains(ch[i])){
                current++;
            }else{
                prev = current;
                current =1;
                itemSet.clear();
                itemSet.add(ch[i]);
            }

            if(current>prev){
                max = Math.max(max,current-prev);
            }else{
                max = Math.max(max,prev-current);
            }

            if(max==str.length()){
                max = 0;
            }

        }

        return max;
    }
}
