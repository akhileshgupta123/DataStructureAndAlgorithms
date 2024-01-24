package StringProblem;

public class AddBinary {

    public static void main(String args[]){
        //int t = 2;
        //System.out.println(t%2);
        AddBinary obj = new AddBinary();
        String a = "1101", b="100";
        String result = obj.addBinary(a,b);

        System.out.println("result is :"+result);
    }

    private String addBinary(String a, String b){
        StringBuilder result = new StringBuilder("");
        int s = 0;
        int i = a.length()-1;
        int j = b.length()-1;

        while(i >= 0 || j >= 0 || s == 1){


            if(i>=0){

                //System.out.println(a.charAt(i)-'1');
                s = s+ a.charAt(i)-'0';
            }else
            {
                s  = s+ 0;
            }

            if(j>=0){
                s = s+b.charAt(j)-'0';
            }else{
                s = s+0;
            }

            //s += ((i >= 0)? a.charAt(i) - '0': 0);
            //s += ((j >= 0)? b.charAt(j) - '0': 0);


            System.out.println("s is"+s );
            //System.out.println("s % isis"+(s % 2) );

            //result.append((char)(s % 2 + '0'));
            result.append((char)(s % 2 + '0'));

            System.out.println((char)(s % 2 + '0'));
            s /= 2;

            System.out.println("after s is"+s );
            i--; j--;

        }

        int start = result.length()-1;

        System.out.println("result"+result);
        while(start>0 && result.charAt(start) == '0'){
            start--;
        }

        if(start != result.length()-1) {
            result.delete(start+1,result.length());
        }
        return result.reverse().toString();

    }
}
