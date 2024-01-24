package BinarySearch;
//1011. Capacity To Ship Packages Within D Days
public class CapacityShipPackage {
    public static void main(String args[]){
        CapacityShipPackage obj = new CapacityShipPackage();
        int weights[] = new int[]{1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int result = obj.shipWithInDays(weights,days);
        System.out.println("resuklt is:"+result);
    }

    private int shipWithInDays(int weight[], int days){
        int start =0;
        int end = 0;
        for(int x : weight){
            start = Math.max(start,x);
            end = end+x;
        }

        System.out.println("start is"+start);
        System.out.println("end is"+end);

        int mid = (start + end)/2;
        while(start<end){

            mid = (start + end)/2;
            System.out.println("inside mid"+mid);

            int sum =0;
            int pices =1;
            for(int num : weight){
                if(sum+num>mid){
                    sum = num;
                    pices++;
                }else{
                    sum = sum+num;
                }

            }

            if(pices>days){
                start = mid+1;
            }
            else{
                end = mid;
            }

            System.out.println("inside start"+start);
            System.out.println("inside end"+end);

            System.out.println("inside peice"+pices);
        }
        return end;
    }
}
