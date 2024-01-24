package Recursion;

public class CurrencyChange {

    public static void main(String args[]){

        CurrencyChange obj = new CurrencyChange();

        //int denominations[] = {5, 10, 25, 100, 200};
        //int targetMoney = 94;

        int denominations[] = {4, 17, 29};
        int targetMoney = 75;
        boolean status = obj.canGetExactChange(targetMoney,denominations);

        System.out.println("the status is :"+status);
    }

    boolean canGetExactChange(int targetMoney, int denominations[]){
        if(targetMoney<0)
            return false;
        if(targetMoney==0)
            return true;

        for(int i=0; i<denominations.length; i++){
            if(canGetExactChange(targetMoney - denominations[i], denominations)){
                return true;
            }

        }

        return false;

    }
}
