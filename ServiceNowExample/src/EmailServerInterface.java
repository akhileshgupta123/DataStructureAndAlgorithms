public interface EmailServerInterface {
    public List<Email> searchEmail();
    public List<Email> getAllEmail();
    public void deleteEmail(Email);
    public void deletListEmail(List<Email>);
    public void archieveEmail();

}
