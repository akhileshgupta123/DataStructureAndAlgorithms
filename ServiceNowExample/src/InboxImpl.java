public class InboxImpl implements EmailServerInterface{

    public void sendEmail();
    public void receiveEmail();
    public List getAllEmail();
    public void searchEmail();
    public void addEventkCalender(Calender);
    public void addTaskkCalender(Calender);
    public void addMeetingInvite(Calender);
    public void triggerAutoEmail(OutOfOffice);
    public scheduleMeeting(MeetingResources, List<Email>, Calender);
    public void addAttachment();
    public void forwardEmail();
}
