package lambdas;

/*
Lambdas
Same As Function
        Call it as Anonymous block
        Parameters
        Body
        Return Type
        Not tied with class
Can be assigned to a variable
                ()[Input] ->[Token] ()[Body]

*/
public class RunnableThreadExampleJava8 {
    public static void main(String args[]){
        //After Lambda

        Runnable t1 = () -> { System.out.println("Java 8 Runnable Thread");};

        new Thread(t1).start();

        Runnable t2 = () -> {
            System.out.println("Java8 Runnable Thread 2");
            System.out.println("Java8 Runnable Thread 2.1");
        };

        new Thread(t2).start();


        new Thread(new Runnable(){
            public void run(){
                System.out.println("Java8 Runnable Thread 3");
            }
        }).start();


        new Thread(()->{
            System.out.println("Java8 Runnable Thread 4");
            System.out.println("Java8 Runnable Thread 4.1");
        }).start();
    }
}
