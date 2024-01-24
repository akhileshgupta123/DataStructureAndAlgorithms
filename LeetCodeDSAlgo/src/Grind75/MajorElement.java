package Grind75;
//169. Majority Element
public class MajorElement {
    public static void main(String args[]){
        int[] nums = new int[]{2,2,1,2,2,1,1};

        MajorElement obj =  new MajorElement();
        int result = obj.maxElement(nums);

        System.out.println(result);

    }

    private int maxElement(int[] num){
        int count = 0;
        int majority = 0;
        for(int i=0; i<num.length; i++){

            if(count==0 && majority!=num[i]){
                majority = num[i];
                count = 1;
            }else if(majority == num[i]){
                count++;
            }else{
                count--;
            }

        }
        return majority;
    }
}
