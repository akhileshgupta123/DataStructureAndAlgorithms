public class SMSNotify implements MeetingNotifyObserver{
    Subject subject;

    EmailNotify(subject){
        this.subject = subject;
        this.subject
    }
    public void notify(){
        this.subject.notify("sms");;
    }
}
