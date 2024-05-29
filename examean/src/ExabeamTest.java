//gfg
//g, f, fg, gf, gg, gfg
//not-> fgg
//input abcde
//ea
//ggggg
//g,gg,ggg,gggg
//

//abcd
//acd
//ac
//acd
//bc
//bd
//ad
import java.util.*;
public class ExabeamTest {

    public static void main(String args[]){


        //String input = "gfg";
        String input = "abcd";
        ExabeamTest obj = new ExabeamTest();
        int count = obj.getSubSequence(input);
        System.out.println(count);
    }

    public int getSubSequence(String input){
        char strArr[] = input.toCharArray();
        Set uniqueSeq = new HashSet<String>();

        for(int i=0; i<strArr.length-1; i++){
            this.process(uniqueSeq,input,i,input.substring(i,i));
            /*for(int j=i+1; j<=strArr.length; j++){
                uniqueSeq.add(input.substring(i,j));
            }*/
        }
        System.out.println(uniqueSeq);
        return uniqueSeq.size();
    }


    private void process(Set uniqueSeq , String input, int i, String initial){

        //System.out.println("here:"+initial);
        for(int j=i+1; j<=input.length(); j++){
            uniqueSeq.add(input.substring(i,j));
        }
    }
}
