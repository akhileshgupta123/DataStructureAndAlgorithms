package DynamicProgramming;
//Time Complexity   :  O ( N)
//Space Complexity :  O ( N )
public class CountDecode {
    public static void main(String args[]){
        char digits[] = { '1', '2', '3', '4' };
        int n = digits.length;
        CountDecode obj = new CountDecode();
        int result = obj.countWays(digits,n);

        System.out.println("result:"+result);
    }

    int countWays(char[] digits, int n)
    {
        if (n == 0 || (n == 1 && digits[0] == '0'))
            return 0;
        return this.countDecoding(digits, n);
    }
    int countDecoding(char[] digits, int n){
        if (n == 0 || n == 1)
            return 1;
        if (digits[0] == '0')
            return 0;

        int count = 0;

        if (digits[n - 1] > '0')
            count = countDecoding(digits, n - 1);

        if (digits[n - 2] == '1'
                || (digits[n - 2] == '2'
                && digits[n - 1] < '7'))
            count += countDecoding(digits, n - 2);
        return count;
    }


}
