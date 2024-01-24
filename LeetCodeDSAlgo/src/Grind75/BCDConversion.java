package Grind75;

public class BCDConversion {
    StringBuilder sb = new StringBuilder();
    public static void main(String args[]){
        int N = 123;

        BCDConversion obj = new BCDConversion();
        obj.BCD(N);

        System.out.println(obj.sb);
    }

    public void BCD(int n){
        if(n == 0)
        {
            sb.append("0000");

        }
        int rev = 0;

        while (n > 0)
        {
            rev = rev * 10 + (n % 10);
            //System.out.println(rev);
            n /= 10;

            //System.out.println(n);
        }

        //System.out.println(rev);

        while(rev > 0){
            String b = Integer.toBinaryString(rev % 10);

            System.out.println(b);


            b = String.format("%04d", Integer.parseInt(b));

            //System.out.println(b);

            sb.append(b);

            rev /= 10;
        }
    }
}
