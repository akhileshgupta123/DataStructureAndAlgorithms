import java.util.*;
public class LargestNumber {
    public static void main(String args[]){
        int[] nums = new int[]{3,30,34,5,9};

        LargestNumber obj = new LargestNumber();
        String result = obj.largestNumber(nums);
        System.out.println(result);
    }

    public String largestNumber(int[] num) {
        if(num == null || num.length == 0)
            return "";

        String[] s_num = new String[num.length];

        for(int i = 0; i < num.length; i++)
            s_num[i] = String.valueOf(num[i]);

        Comparator<String> comp = new Comparator<String>(){
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }

        };

        Arrays.sort(s_num,comp);

        if(s_num[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s: s_num)
            sb.append(s);

        return sb.toString();
    }
}
