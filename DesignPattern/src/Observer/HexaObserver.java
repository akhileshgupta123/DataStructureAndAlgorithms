package Observer;

public class HexaObserver implements Observer{
    private NumberConvertorImpl subject;

    public HexaObserver(NumberConvertorImpl subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
