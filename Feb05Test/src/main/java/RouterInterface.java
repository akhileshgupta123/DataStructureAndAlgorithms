public interface RouterInterface {

     public void registerRoute(String  key, String result) throws Exception;

    public String lookupRoute(String key) throws Exception;


}
