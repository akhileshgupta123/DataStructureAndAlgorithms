package Recursion;
//10. Regular Expression Matching
//Time complexity is 2^n
public class RegularExpression {
    public static void main(String args[]){

        RegularExpression obj = new RegularExpression();
        //String s = "aa", p = "a*b";
        //String s = "aabb", p = "a*b*";
        String s = "aaaaa", p = "a*b*a";



        boolean result = obj.isMatch(s,p);
        System.out.println(result);
    }

    public boolean isMatch(String s, String p){
        System.out.println("pattern:"+p);
        System.out.println("string is :"+s);
        if(p.length()==0){
            System.out.println("first");
            return s.length()==0;
        }

        if(p.length()>1 && p.charAt(1)=='*'){
            System.out.println("inside first if");
            if(isMatch(s,p.substring(2))){
                System.out.println("second");
                return true;
            }
            if(s.length()>0 && (p.charAt(0)=='.' || s.charAt(0) == p.charAt(0))){
                System.out.println("third :"+s.substring(1));
                return isMatch(s.substring(1),p);
            }

            return false;

        }else{

            System.out.println("inside first else");
            if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))){
                System.out.println("inside inner if");

                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        }

    }
}
