package Arrays;
import java.util.*;
public class TripletsArray {

    public static void main(String args[]){

        TripletsArray obj = new TripletsArray();

        ArrayList<String> arrList = new ArrayList<String>();
        arrList.add("0.6");
        arrList.add("0.7");
        arrList.add("0.8");
        arrList.add("1.2");
        arrList.add("0.4");


        int result = obj.solve(arrList);
        System.out.println("The result is :"+result);
    }

    public int solve(ArrayList<String> arrList){
        if(arrList.size()<3)
            return 0;

        double a = Double.parseDouble(arrList.get(0));
        double b = Double.parseDouble(arrList.get(1));
        double c = Double.parseDouble(arrList.get(2));


        for(int i=3; i<arrList.size(); i++){
            if((a+b+c)>1 && (a+b+c)<2){
                return 1;
            }

            double n = Double.parseDouble(arrList.get(i));

            if((a+b+c)>=2){

                if(a>b && a>c){
                    a=n;
                }else if(b>c){
                    b = n;
                }else{
                    c = n;
                }
            }else{
                if(a<b && a<c){
                    a=n;
                }else if(b<c){
                    b = n;
                }else{
                    c = n;
                }

            }
        }

        System.out.println("a : "+a);
        System.out.println("b : "+b);
        System.out.println("c : "+c);
        if((a+b+c) > 1 && (a+b+c) < 2){
            return 1;
        }

        return 0;
    }
}
