package StackQueue;
import java.util.*;

public class SimplifyPath {

    public static void main(String args[]){
        SimplifyPath obj = new SimplifyPath();
        String path = "/a/./b/../../c/";
        //String path ="/../";
        //String path ="/home//foo/";

        String result = obj.simplifyPath(path);

        System.out.println("the final path:"+result);

    }


    public String simplifyPath(String path){
        Stack<String> stack = new Stack<String>();

        while(path.length()>0 && path.charAt(path.length()-1)=='/'){
            path = path.substring(0, path.length()-1);

            System.out.println("the path is :"+path);
        }


        int start = 0;
        for(int i=1; i<path.length(); i++){
            if(path.charAt(i) == '/'){
                stack.push(path.substring(start, i));
                System.out.println("mid element is :"+path.substring(start,i));
                start = i;

            }else if(i==path.length()-1){
                stack.push(path.substring(start));

                System.out.println("last element is :"+path.substring(start));
            }
        }

        LinkedList<String> result = new LinkedList<String>();


        int back = 0;
        while(!stack.isEmpty()){
            String top = stack.pop();
            if(top.equals("/.") || top.equals("/")){

            }else if(top.equals("/..")){
                back++;
            }
            else{
                if(back > 0){
                    back--;
                }else{
                    result.push(top);
                }
            }
        }

        //System.out.println("first element is :"+result.get(0));
        //System.out.println("second element is :"+result.get(1));
        //if empty, return "/"
        if(result.isEmpty()){
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty()){
            String s = result.pop();
            System.out.println("pop element is :"+s);
            sb.append(s);
        }

        return sb.toString();


    }
}
