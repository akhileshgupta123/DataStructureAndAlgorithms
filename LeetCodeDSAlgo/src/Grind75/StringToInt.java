package Grind75;
//8. String to Integer (atoi)
public class StringToInt {
    public static void main(String args[]){
        //String s = "   -42";
        String s = "4193 with words";
        StringToInt obj = new StringToInt();

        int result = obj.StrToInteger(s);
        System.out.println(result);
    }

    public int StrToInteger(String str){
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }

        int multiplier = 1;
        int index = 0;
        char firstChar = str.charAt(0);

        if (firstChar == '-' || firstChar == '+') {
            if (firstChar == '-') {
                multiplier = -1;
            }
            index++;
        }

        int num = 0;

        while(index<str.length() && Character.isDigit(str.charAt(index))){

            int digit = str.charAt(index) - '0';

            System.out.println("digit"+digit);
            num = num * 10 + digit * multiplier;
            System.out.println(num);
            index++;

        }

        return num;
    }
}
