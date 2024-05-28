import java.util.concurrent.*;
public class Producer extends Thread{

    private ArrayBlockingQueue blockingDeque;
    Producer(ArrayBlockingQueue blockingDeque){
        this.blockingDeque = blockingDeque;
    }
    public void run(){

        for(int i=0; i<20; i ++){
            this.blockingDeque.add(i);
            System.out.println("Producer adding  item is"+i);
            try{
                Thread.sleep(2000);
            }catch (InterruptedException ex){

            }
        }

    }
}
