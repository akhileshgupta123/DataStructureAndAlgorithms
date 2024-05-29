package Singleton;
/*
It ensures that a class has only one instance and provides a global point of access to that instance.
It can be used to control access to resources that are shared across the system, such as a database connection or a configuration object.
It can be used to implement caching, logging, and other system-wide services.*/
public class Singleton {
    private static Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(instance==null){
            synchronized(Singleton.class){
                if(instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
