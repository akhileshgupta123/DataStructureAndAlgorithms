package Observer;

public class OctaneObserver implements Observer{

    private NumberConvertorImpl subject;

    public OctaneObserver(NumberConvertorImpl subject){
        this.subject = subject;
        this.subject.attach(this);
    }


    @Override
    public void update() {
        System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) );
    }
}
