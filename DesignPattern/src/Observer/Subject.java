package Observer;

public interface Subject {
    public void attach(Observer observer);
    public void notifyAllObserver();
}
