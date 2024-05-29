public interface Cache {

    public void set(String key, int data) throws Exception;
    public int  get(String key);
    public void remove(String key);
}
