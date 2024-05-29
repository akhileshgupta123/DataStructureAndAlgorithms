package StringProblem;

public class StringLetterShift {
    public static void main(String args[]){
        String str = "xyz";
        int[] shifts = new int[]{3,5,9};

        int n = shifts.length;

        for(int i=n-2; i >=0; i--){
            shifts[i] =  shifts[i]  + shifts[i+1];
            //System.out.println(shifts[i]);
            if(shifts[i] >= 26){
                shifts[i] = shifts[i] % 26;
            }
        }


        char[] CH = str.toCharArray();
        for(int i = 0; i < n; i++){
            int c = CH[i] + shifts[i];
            if(c<123){
                CH[i] = (char)c;
            }else{
                int looprotation =  (c-26);
                CH[i] = (char)looprotation;
            }

        }





        System.out.println( String.valueOf(CH));
    }
}
