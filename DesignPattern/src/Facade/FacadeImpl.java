package Facade;

public class FacadeImpl implements FacadeIntf{
    private SubsystemClassA subsystemClassA;
    private SubsystemClassB subsystemClassB;
    private SubsystemClassC subsystemClassC;
    public FacadeImpl(){
        subsystemClassA = new SubsystemClassA();
        subsystemClassB = new SubsystemClassB();
        subsystemClassC = new SubsystemClassC();
    }
    @Override
    public void doTask() {
        subsystemClassA.methodA();
        subsystemClassB.methodB();
        subsystemClassC.methodC();
    }
}
