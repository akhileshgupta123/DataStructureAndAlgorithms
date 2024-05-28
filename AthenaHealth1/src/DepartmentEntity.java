@(Table="Department")
public class DepartmentEntity {


    id;


    @one-to-many(early)
    List<Employee> employeelIST;


    //10 million
    //1 kb 



}
