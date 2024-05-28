import java.util.*;
public class Consumer1 extends Thread{
    Boolean flag;
    List<Integer> item;

    public Consumer1(Boolean flag,  List<Integer> item){
        this.flag = flag;
        this.item = item;
    }

    public void run(){
        synchronized (this.flag){
            if(!flag){
                Thread.wait();
            }
            this.
        }


    }

}
