package DynamicProgramming;
import java.util.*;

public class GenerateParentheses {

    List<String> res = new ArrayList<String>();
    public static void main(String args[]){
        GenerateParentheses obj = new GenerateParentheses();
        obj.generateParenthesis(3);

        System.out.println(obj.res);


    }

    private List<String> generateParenthesis(int n){
        this.generate("",n,n);
        return res;
    }

    private void generate(String s, int left, int right){
        System.out.println("sample:"+s);
        if(left==0 && right ==0){
            res.add(s);
        }

        if(left < 0 || right < 0 || left > right )
            return ;


        this.generate(s+'(', left-1, right);
        this.generate(s+')', left, right-1);

    }
}
