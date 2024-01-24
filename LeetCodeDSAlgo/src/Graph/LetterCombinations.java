package Graph;
import java.util.*;
//17. Letter Combinations of a Phone Number
//Suppose n is the length of the input digits, and m is the maximum number of letters that can correspond to a single digit (e.g., m is 4 for the digits 7 and 9). I.e. Time Complexity O(m ^ n)
//Time Complexity (m*n)
//Space Complexity
//Time Complexity — O(m ^ n);
//        Space Complexity — O(m ^ n);
public class LetterCombinations {

    public static void main(String args[]){
        int number[] = {2,3};
        int n = number.length;

        LetterCombinations obj = new LetterCombinations();
        obj.letterCombinations(number,n);

    }

    private void letterCombinations(int number[], int n){
        String table[] = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        ArrayList<String> list = this.letterCombinationsUtil(number, n, table);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i)+" ");
        }
    }

    private ArrayList<String> letterCombinationsUtil(int number[], int n, String table[]){
        ArrayList<String> list = new ArrayList<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add("");


        while (!queue.isEmpty()) {
            String s = queue.remove();

            // If complete word is generated
            // push it in the list
            System.out.println("the string is:"+s);
            System.out.println("s length is:"+s.length());
            if (s.length() == n)
                list.add(s);
            else {
                String val = table[number[s.length()]];

                System.out.println("the value is:"+val);
                for (int i = 0; i < val.length(); i++)
                {
                    queue.add(s + val.charAt(i));
                }
            }
        }
        return list;

    }
}
