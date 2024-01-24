package Arrays;
import java.util.*;
public class GenerateLargestNumber {

    public static void main(String args[]){
        List<String> arr = new ArrayList<String>();
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargest(arr);
    }

    private static void printLargest(List<String> arr){
        Collections.sort(arr , new Comparator<String>()
                {


                    public int compare(String x, String y){


                        String XY = x+y;
                        String YX = y+x;



                        /*
                        String XY = x;
                        String YX = y;
                        */



                        System.out.println("XY is :"+XY);
                        System.out.println("YX is :"+YX);


                        //return XY.compareTo(YX) >0 ? -1 : 1;
                        if(Integer.parseInt(XY) > Integer.parseInt(YX))
                            return -1;
                        else
                            return 1;

                        //return XY.compareTo(YX) >0 ? -1 : 1;



                    }

                }
        );

        System.out.println(arr);
        for(String str: arr){
            System.out.print(str);
        }
    }
}
