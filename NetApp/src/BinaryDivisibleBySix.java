//given a binary representation of very large number. find whether it is divisible by 6 or not
public class BinaryDivisibleBySix {
    public static void main(String args[]){
        String binaryNumber = "101010"; // Example binary number
        boolean divisibleBySix = isDivisibleBySix(binaryNumber);

        if (divisibleBySix) {
            System.out.println(binaryNumber + " is divisible by 6.");
        } else {
            System.out.println(binaryNumber + " is not divisible by 6.");
        }
    }

    public static boolean isDivisibleBySix(String binaryNumber) {
       /* if((binaryNumber.charAt(binaryNumber.length()-1)-'0')%2!=0){
            return false;
        }

        int sum = 0;
        for (int i = 0; i < binaryNumber.length(); i++) {
            sum += (binaryNumber.charAt(i) - '0');
        }*/

        int decimal = 0;
        int power = 0;
        for (int i = binaryNumber.length() - 1; i >= 0; i--) {
            int bit = binaryNumber.charAt(i) - '0';
            decimal += bit * Math.pow(2, power);
            power++;
        }

        return decimal % 6 == 0;
    }
}
