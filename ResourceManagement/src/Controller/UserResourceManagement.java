package Controller;

@PATH("api/v1/userResource")
public class UserResourceManagement {
    @path("user/{userId}")
    @POST
    @Produces(Application.json)
    @Consumes(Application.json)
    public Response addUserResourceProvision(Resource reqource , @Path userId String){

    }
    @path("user/{userId}")
    @GET
    @Consumes(Application.json)
    public Response getUserResourceById(@Path userId String)){

    }
}
