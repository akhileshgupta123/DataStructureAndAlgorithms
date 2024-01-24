package Arrays;

public class NumberToWords {

    public static void main(String args[]){
        int num = 123;
        NumberToWords obj = new NumberToWords();
        String result = obj.converter(123);

        System.out.println("result is"+result);

    }

    private String converter(int num){
        if(num==0){
            return "Zero";
        }

        String words[][] = new String[4][];

        words[0] = new String[]{"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
        words[1] = new String[]{"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        words[2] = new String[]{"","","Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        words[3] = new String[]{"","Thousand ","Million ","Billion "};

        StringBuilder res=new StringBuilder();

        int level=0;
        while(num>0){
            StringBuilder add = new StringBuilder();
            int h = num%1000; //h<- last three digits of num
            if(h/100!=0) {
                //If hundreds' position digit is different from 0, translate to corresponding word
                add.append(words[0][h / 100] + "Hundred ");
            }

            h = h%100; //h<-last 2 digits of h
            if(h/10==1){
                h = h%10;
                add.append(words[1][h]);
            }else {
                add.append(words[2][h/10]);
                h = h%10; //h<-last digit of h
                add.append(words[0][h]);
            }

            if(!add.toString().isEmpty()) {
                add.append(words[3][level]);
                //Append add to beginning of result
                add.append(res);
                res = add;
            }
            num = num/1000; //remove last 3 digits processed
            level++; //Increase level, to move on to next 3 digits
        }



        return res.toString().trim();

    }
}
