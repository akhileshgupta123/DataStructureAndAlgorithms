package StringProblem;
//880. Decoded String at Index
//O(N) Time O(1) Space
public class DecodeAtIndex {
    public static void main(String args[]){
        DecodeAtIndex obj = new DecodeAtIndex();
        String str = "leet2code3";
        int k = 10;

        /*String str = "ha22";
        int k = 5;*/

        /*String str = "a2345678999999999999999";
        int k = 1;*/




        String result = obj.decodeIndex(str,k);
        System.out.println(result);
    }

    private String decodeIndex(String str, int k){
        long size =0 ;
        for(int i=0;i<str.length(); i++){
            char ch=str.charAt(i);
            if(Character.isDigit(ch)){
                size*=ch-'0';
                System.out.println("size is :"+size);
            }else{
                size++;
            }
        }

        for (int i = str.length()-1; i >= 0; --i) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                size = size/(c - '0');
                System.out.println("size is:"+size);
                System.out.println("before K is:"+k);
                k = k % (int)size;
                System.out.println("after K is:"+k);
            }else{
                if(k==0 || k==size) {
                    return Character.toString(c);
                }
                size--;
            }
        }


        return "";
    }
}
