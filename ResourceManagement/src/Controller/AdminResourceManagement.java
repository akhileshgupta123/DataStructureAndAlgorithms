package Controller;
@PATH("api/v1/adminResource")
public class AdminResourceManagement {


    @path("admin/{adminId}?userId={userId}")
    @GET
    @Consumes(Application.json)
    public Response getUserResourceConsumedByUserId(@Path adminId String, @Query userId String)){

    }


    @path("admin/{adminId}")
    @GET
    @Consumes(Application.json)
    public Response getResourceConfiguration(@Path adminId String,)){

    }


}
