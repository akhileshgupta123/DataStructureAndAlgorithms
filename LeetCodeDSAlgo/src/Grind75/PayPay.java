package Grind75;

public class PayPay {
    public static void main(String args[]){
        String[] item = {"* 1 2","^ 2 3","< 3 3", "> 2 4"};

        int[][] result = new int[5][2];

        int index = 0;

        for(String item1 : item){
            String arr[] = item1.split(" ");
            if(arr[0].equalsIgnoreCase("*")){
                result[index][0] = 1;
                result[index][1] = 2;
            }

            if(arr[0].equalsIgnoreCase("^")){
                result[index][0] = 3;
                result[index][1] = 4;
            }

            if(arr[0].equalsIgnoreCase("<")){
                result[index][0] = 5;
                result[index][1] = 6;
            }

            if(arr[0].equalsIgnoreCase(">")){
                result[index][0] = 7;
                result[index][1] = 8;
            }
            index++;
        }

        for(int[] test : result){
            System.out.println(test[0]);
            System.out.println(test[1]);
        }

    }
}
