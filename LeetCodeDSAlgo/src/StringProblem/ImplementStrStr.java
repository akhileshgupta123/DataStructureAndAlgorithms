package StringProblem;
//28. Implement strStr()
public class ImplementStrStr {
    public static void main(String args[]){

        ImplementStrStr obj = new ImplementStrStr();
        int result = obj.StrStr("hello","ll");
        System.out.println("the result is:"+result);
    }


    private int StrStr(String haystack, String needle){
        if(haystack==null || needle == null)
            return -1;
        if(haystack.equals(needle)){
            return 0;
        }

        int neeleLength = needle.length();
        for(int i=0;i<haystack.length()-neeleLength+1; i++){

            if (haystack.substring(i, i + neeleLength).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
