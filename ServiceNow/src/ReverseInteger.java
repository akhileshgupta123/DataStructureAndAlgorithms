public class ReverseInteger {

    public static void main(String args[]){
        int number = 12345;
        int reversedNumber = reverse(number);
        System.out.println("Original number: " + number);
        System.out.println("Reversed number: " + reversedNumber);
    }

    public static int reverse(int num) {
        int reversedNum = 0;
        while(num!=0){
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;

            num = num/10;
        }

        return reversedNum;
    }
}
