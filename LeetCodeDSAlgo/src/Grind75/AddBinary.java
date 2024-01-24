package Grind75;
//67. Add Binary
public class AddBinary {
    public static void main(String args[]){
        String a = "1010";
        String b = "1011";
        AddBinary obj = new AddBinary();
        String result = obj.addBinary(a,b);

        System.out.println(result);
    }

    public String addBinary(String a, String b){
        StringBuilder res = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry=0;

        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0){
                sum += a.charAt(i--) - '0';
            }
            if(j>=0){
                sum += b.charAt(j--) - '0';
            }

            carry = sum > 1 ? 1 : 0;
            res.append(sum%2);
        }

        if(carry!=0){
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
