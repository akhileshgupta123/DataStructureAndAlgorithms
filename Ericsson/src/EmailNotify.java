public class EmailNotify implements MeetingNotifyObserver{

    Subject subject;

    EmailNotify(subject){
        this.subject = subject;
        this.subject
    }
    public void notify(){
        this.subject.notify("email");;
    }
}
