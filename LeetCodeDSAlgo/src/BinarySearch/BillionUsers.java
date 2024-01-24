package BinarySearch;

public class BillionUsers {
    public static void main(String args[]){
        BillionUsers obj = new BillionUsers();
        //float growthRate[] = new float[]{1.5f};
        float growthRate[] = new float[]{1.01f, 1.02f};

        int result = obj.getBillionUsersPerDay(growthRate);
        System.out.println("the result:"+result);
    }

    private int getBillionUsersPerDay(float growthRate[]){

        int low = 1;
        //int high = Integer.MAX_VALUE;
        int high = 2000;
        int mid = 0;
        while(low<high){

             mid = ( low + high)/2;

            if(growthRateHelper(mid,growthRate)){
                high = mid;
                System.out.println("inside if"+high);
            }else{
                low = mid+1;
            }
        }

        return mid;
    }

    private boolean growthRateHelper(int mid, float[] growthRates){
        double totalUsers = 0;
        int billion = 1000000000;
        for(int i = 0 ; i < growthRates.length; i++){
            totalUsers +=  Math.pow(growthRates[i], mid);
        }
        System.out.println("the totsl users:"+totalUsers);
        return (int)totalUsers >= billion;
    }
}
