public class EmailConfiguration {
    public void createFolderGroup(String name);
    public void moveEmail(String toGroup, List<SEmail> listOfEmail );
    public void moveEmailIndividual(String toGroup,Email email );
}
