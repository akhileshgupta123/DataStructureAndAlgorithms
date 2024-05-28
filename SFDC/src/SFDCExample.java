import java.util.*;
public class SFDCExample {
    public static void main(String args[]){
        int K= 4;

        int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};

        int max = arr[arr.length-1];
        int start = arr.length-1;
        while(start>=0){
            /*int curr = 0;
            curr = curr + arr[start];*/
            int temp = 0;
            int curr = 0;
            while(temp<K && start-temp>=0){

                curr = curr + arr[start-temp];
                max = Math.max(curr,max);
                temp++;
            }
            start--;
            //max = Math.max(curr,max);

        }

        System.out.println(max);


        String str1 = "abc";
        System.out.println(str1);

        SFDCExample obj = new SFDCExample();
        obj.modify(str1);
        System.out.println(str1);


    }

    public void modify(String str1){
        System.out.println(str1);
        //str1 = "test";
        str1 = str1.replace('a','z');
        System.out.println(str1);
    }

    public static void calcMissing(List<String> readings){
        int n = readings.size();
        double[] times = new double[n];
        double[] prices = new double[n];
        double sum = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            String[] parts = readings.get(i).split("\t");
            times[i] = i;
            if(parts[1].startsWith("Missing")){
                prices[i] = Double.NaN;
            }else{
                prices[i] = Double.parseDouble(parts[1]);
                sum = sum + prices[i];
                count++;
            }
        }

        double average = sum/count;
        double[] interpolatedPrices = interpolatedMissing(times,prices)

    }

    public static double[] interpolatedMissing(double[] times, double[] prices){
        double[] interpolatedPrices = new double[prices.length];
        for(int i=0; i<prices.length; i++){
            
        }

    }
}
