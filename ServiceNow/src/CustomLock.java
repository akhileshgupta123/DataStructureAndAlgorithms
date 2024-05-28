//code to implement custom Lock api
public class CustomLock {
    private boolean isLocked = false;
    public synchronized void lock() throws InterruptedException{
        while(isLocked){
            wait();
        }
        this.isLocked = true;
    }

    public synchronized void unlock(){
        this.isLocked = false;
        notify();
    }
}
