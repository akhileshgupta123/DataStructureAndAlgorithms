import java.math.BigInteger;

public class WayFairTest {
    int carry = 0;
    StringBuffer result1 = new StringBuffer();
    public static void main(String args[]){
        WayFairTest obj = new WayFairTest();
        //obj.processString("222232244629420445529739893461909967206666939096499764990979600","1");
        obj.result1 = new StringBuffer();
        System.out.println(obj.testRunner("301", "5", "306"));
        obj.result1 = new StringBuffer();
        System.out.println(obj.testRunner("144", "89", "233"));
        obj.result1 = new StringBuffer();
        System.out.println(obj.testRunner("1", "999", "1000"));
    }
    public void processString(String str1, String str2){
        int length1 = str1.length();
        int length2 = str2.length();
        char str1arr1[] = str1.toCharArray();
        char str1arr2[] = str2.toCharArray();
        while(length1>0 && length2>0){
            char  item1 = str1arr1[length1-1];
            char  item2 = str1arr2[length2-1];
            addNumber(Integer.parseInt(String.valueOf(item1)), Integer.parseInt(String.valueOf(item2)));
            length1--;
            length2--;
        }
        while(length1>0){
            char  item1 = str1arr1[length1-1];
            addNumber(Integer.parseInt(String.valueOf(item1)), 0);
            length1--;
        }
        while(length2>0){
            char  item2 = str1arr2[length2-1];
            addNumber(0, Integer.parseInt(String.valueOf(item2)));
            length2--;
        }
        if(carry!=0){
            result1.append(carry);
        }
    }
    public void addNumber(int a, int b){
        int result = carry+a+b;
        carry = result/10;
        result = result%10;
        result1.append(result);
    }
    public boolean testRunner(String input1, String input2, String result){
        processString(input1,input2);
        return result.equals(this.result1.reverse().toString());
    }
}
