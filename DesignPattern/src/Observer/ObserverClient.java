package Observer;

/*
Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified,
its depenedent objects are to be notified automatically. Observer pattern falls under behavioral pattern category.
The observer pattern allows objects to be notified of changes in the state of other objects, without the objects being tightly coupled to one another.
The observer pattern is based on the publish-subscribe model, where objects "publish" notifications of changes in their state, and other objects "subscribe" to receive those notifications.
The observer pattern uses interfaces to define the "publish" and "subscribe" methods, allowing different classes to implement them in different ways.
*/
public class ObserverClient {
    public static void main(String args[]){
        NumberConvertorImpl subject = new NumberConvertorImpl();

        new HexaObserver(subject);
        new OctaneObserver(subject);
        new BinaryObserver(subject);

        subject.setState(7);
        subject.setState(77);
    }
}
