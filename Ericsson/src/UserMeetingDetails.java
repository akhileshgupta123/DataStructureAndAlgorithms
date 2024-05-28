public class UserMeetingDetails {
    int id;
    int meetingId;
    Date startTime;
    Date endTime;
    @User
    User meetingAuthor;



    List<User> inviteList ;
}
