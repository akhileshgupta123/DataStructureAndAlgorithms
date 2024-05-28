import jdk.nashorn.internal.objects.annotations.Getter;

import javax.annotation.PostConstruct;

public class MeetingManagement {




    @PostConstruct
            (meeting/{roomid}?startTime=&enfdTime&email=)
    createMeeting(List<String> emailList){


    }

    @Getter

            (meeting?startTime=&endTime=)
    List<MeetingRoom > getAvailableMeetingRoom(){

    }


    @PUT
            (meeting/{meetingId}?startTime=&endTime=)
    updateMeeting(List<String> emailList){

    }

    @DELETE
            (meeting/{meetingId})

    cancelMeeting(){

    }
}
