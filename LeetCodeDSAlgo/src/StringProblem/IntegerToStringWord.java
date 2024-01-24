package StringProblem;

public class IntegerToStringWord {
    private static final String[] LESS_THAN_20 = new String[] {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] MULTIPLE_OF_TEN = new String[] {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    public static void main(String args[]){
        int num=1234179;
        IntegerToStringWord obj = new IntegerToStringWord();
        String result = obj.numberToWords(num);
        System.out.println("result is : "+result);

    }


    private String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        return helper(num);
    }

    private String helper(int num){
        String ans = "";
        if (num < 20)
            ans = LESS_THAN_20[num];
        else if (num < 100)
            ans = MULTIPLE_OF_TEN[num/10] + " " + helper(num%10);
        else if (num < 1000)
            ans = helper(num/100) + " Hundred " + helper(num%100);
        else if (num < 1000000)
            ans = helper(num/1000) + " Thousand " + helper(num%1000);
        else if (num < 1000000000)
            ans = helper(num/1000000) + " Million " + helper(num%1000000);
        else
            ans = helper(num/1000000000) + " Billion " + helper(num%1000000000);
        return ans.trim();
    }
}
