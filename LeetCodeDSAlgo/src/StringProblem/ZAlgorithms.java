package StringProblem;

public class ZAlgorithms {
    public static void main(String args[]){
        String S = "ababa";
        String P = "ab";
        ZAlgorithms obj = new ZAlgorithms();
        int result = obj.findOccurance(S,P);

        System.out.println("result is :"+result);

    }

    private int findOccurance(String s1, String s2){

        if(s1.length()==0 && s2.length()==0)
            return 0;
        if(s2.length()==0)
            return 0;

        int i=0,j=0,p1=0,p2=0,count,res=0;
        for(i=0;i<=s1.length()-s2.length();i++){
            if(s1.charAt(i) == s2.charAt(j)){
                count=0;

                p1=i;
                p2=0;
                while(p1<s1.length() && p2<s2.length()){
                    if(s1.charAt(p1) == s2.charAt(p2)){
                        count++;
                        p1++;
                        p2++;
                    }else
                        break;

                }
                if(count==s2.length()){
                    res++;
                }

            }
        }

        return res;
    }
}
