package FileOperation;
import java.io.*;
public class LargeFileRead {
    public static void main(String args[]){
        String input ="fferen";
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/akhileshg/VMWARE/work/agoda"))){
            while(br.readLine()!=null){
                //System.out.println(br.readLine());
                if(br.readLine().contains(input)){
                    System.out.println("found");
                }
            }

        }catch(FileNotFoundException ex){

            System.out.println("first");
        }catch(IOException ex){
            System.out.println("second");
        }

    }
}
