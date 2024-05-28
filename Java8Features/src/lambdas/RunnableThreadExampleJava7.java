package lambdas;

public class RunnableThreadExampleJava7 {
    public static void main(String args[]){
        //Before Lambda

        Runnable t1 = new Runnable(){
            public void run(){
                System.out.println("Java 7 Runnable Thread");
            }
        };

        new Thread(t1).start();
    }
}
