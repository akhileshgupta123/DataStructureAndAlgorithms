import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class HPEExample {
    public static void main(String args[]) throws IOException{
        URL url = new URL("https://en.wikipedia.org/wiki/India#References");
        //Retrieving the contents of the specified page
        Scanner sc = new Scanner(url.openStream());
        //Instantiating the StringBuffer class to hold the result
        StringBuffer sb = new StringBuffer();
        boolean flag = false;
        while(sc.hasNext()) {
            String content = sc.next();

            if(content.indexOf("References</span>")!=-1 || flag){
                sb.append(sc.next());
                flag = true;
            }

            if(content.indexOf("Bibliography</span>")!=-1){
                flag = false;
            }



            //System.out.println(sc.next());
        }
        //Retrieving the String from the String Buffer object
        String result = sb.toString();
        System.out.println(result);
        //Removing the HTML tags
        result = result.replaceAll("<[^>]*>", "");
        System.out.println("Contents of the web page: "+result);
    }
}
