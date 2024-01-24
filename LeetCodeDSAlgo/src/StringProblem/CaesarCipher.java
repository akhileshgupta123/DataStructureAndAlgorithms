package StringProblem;
//Rotational Cipher
public class CaesarCipher {

    public static void main(String args[]){

        String text = "Zebra-01493";
        int s=3;
/*
        String text = "abcdZXYzxy-999.@";
        int s = 200;*/


        CaesarCipher obj = new CaesarCipher();
        String result = obj.encrypt(text,s);

        System.out.println("The result is :"+result);

    }

    private String encrypt(String input, int rotationFactor){
        StringBuffer result = new StringBuffer();

        for(int i=0; i<input.length(); i++){

            //System.out.println("is digit func :"+Character.isDigit(text.charAt(i)));
            char ch =  input.charAt(i);
            System.out.println("The outer number is :"+(int)ch);
            if(Character.isDigit(ch)){
                int tempFactor = rotationFactor%10;
                int withRotetionFactor = ch + tempFactor;



                System.out.println("The number is :"+withRotetionFactor);

                if(withRotetionFactor <= 57){
                    result.append((char) withRotetionFactor);
                }else {
                    int looprotation =  (withRotetionFactor-10);
                    result.append((char) looprotation);
                }

            }else  if(ch < 91 && ch>64){


                int tempFactor = rotationFactor%26;

                //System.out.println("here"+ch);
                int withRotetionFactor = ch + tempFactor;
                //System.out.println("here"+withRotetionFactor);
                if(withRotetionFactor < 91){
                    result.append((char) withRotetionFactor);
                }else {
                    int looprotation =  (((withRotetionFactor-26)));
                    result.append((char) looprotation);
                }

            }
            else if(ch < 123 && ch>96){
                int tempFactor = rotationFactor%26;
                int withRotetionFactor = ch + tempFactor;
                if(withRotetionFactor < 123){
                    result.append((char) withRotetionFactor);

                }else {


                    int looprotation =  ((withRotetionFactor-26));
                    result.append((char) looprotation);
                }
            }else {
                result.append((char) ch);

            }


        }

        return result.toString();
    }
}
