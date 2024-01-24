package StringProblem;

public class CountAndSay {
    public static void main(String args[]){

        CountAndSay obj = new CountAndSay();
        String result = obj.countNumber(4);
        System.out.println("result is:"+result);

    }

    private String countNumber(int n){
        if(n==1){
            return "1";
        }
        String str=countNumber(n-1);
        System.out.println("string is :"+str);
        //After getting string from every function

        StringBuilder sb = new StringBuilder();

        int freq=1;  //initially frequency of every character is 1

        for(int i=0;i<str.length()-1;i++){ //when length=1 then this will not execute for ex-"1"

            if(str.charAt(i)==str.charAt(i+1)){
                freq++;    //it will run till the new character is not coming , it will count the freq of that character
            }else{  //when new character appeared -
                sb.append(freq); //first we store the freq of the old character
                sb.append(str.charAt(i)); // and then the character itself
                freq=1; // then we will set the freq 1

                System.out.println("sb inner"+sb.toString());
            }
        }
        // for length=1 it will run example- "1"
        sb.append(freq);
        System.out.println("freq"+freq);
        System.out.println("str"+str);
        System.out.println("sb"+sb.toString());
        sb.append(str.charAt(str.length()-1));

        return sb.toString(); // then we return the final string to all function from recursion tail
    }
}
