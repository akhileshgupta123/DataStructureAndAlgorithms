package Observer;
import java.util.*;
public class NumberConvertorImpl implements Subject{
    private int state;
    private List<Observer> observers = new ArrayList<Observer>();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        this.notifyAllObserver();
    }

    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyAllObserver() {
        for(Observer observer: observers){
            observer.update();
        }
    }
}
