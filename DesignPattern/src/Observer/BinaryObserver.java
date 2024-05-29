package Observer;

public class BinaryObserver implements Observer{
    private NumberConvertorImpl subject;

    public BinaryObserver(NumberConvertorImpl subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println(" Binary String :" + Integer.toBinaryString(this.subject.getState()));
    }
}
