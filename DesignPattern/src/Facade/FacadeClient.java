package Facade;

/*
Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system.
The facade defines a simplified interface that can be used to access the functionality provided by the underlying system.
The facade hides the complexity of the underlying system and makes it easier to use.
The facade can be used to decouple the other parts of the system from the details of the underlying system.
*/

public class FacadeClient {
    public static void main(String args[]){
        FacadeIntf facadeIntf = new FacadeImpl();
        facadeIntf.doTask();
    }
}
