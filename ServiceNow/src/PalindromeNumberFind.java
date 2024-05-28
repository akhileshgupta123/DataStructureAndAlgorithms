import java.util.*;
//code to find the palindrome numbers in given array
public class PalindromeNumberFind {
    public static void main(String args[]){
        int[] numbers = new int[]{121, 123, 1331, 1001, 1234, 1221};
        PalindromeNumberFind obj = new PalindromeNumberFind();
        List<Integer> palindromeList = obj.findPalindromes(numbers);
        System.out.println(palindromeList);
    }

    private List<Integer>  findPalindromes(int[] numbers ){
        List<Integer> palindromes = new ArrayList<Integer>();
        for (int num : numbers) {
            if(isPalindrome(num)){
                palindromes.add(num);
            }

        }
        return palindromes;
    }

    private boolean isPalindrome(int num){
        int reversedNum = 0;
        int originalNum = num;
        while (num != 0) {
            int digit = num%10;
            reversedNum = reversedNum * 10 + digit;
            num = num/10;
        }
        return originalNum == reversedNum;
    }
}
