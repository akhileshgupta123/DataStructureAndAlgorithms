import java.util.*;
class StudentInformation{
    int desk_no;
    boolean is_occupied;
    int index;
    StudentInformation(int desk_no, boolean is_occupied){
        this.desk_no = desk_no;
        this.is_occupied = is_occupied;

    }
}
public class StudentArrangement {

    public static void main(String args[]){
        //int occupied_student[] = new int[] {12,2,6,7,11};

        //int occupied_student[] = new int[] {8,1,8};

        int occupied_student[] = new int[] {6,4};


        int size_array = occupied_student[0];
        int array_row = size_array/2;
        StudentInformation student_desk[][] = new StudentInformation[array_row][2];
        populateStudentDesk(array_row, occupied_student, student_desk);
        displayArrayElement(student_desk,array_row);

        int result = findMatchingResult(student_desk,array_row);
        System.out.println("The final result is :"+result);
    }

    private  static void populateStudentDesk(int array_row, int occupied_student[], StudentInformation student_desk[][]){
        Set<Integer> occupied_set = new HashSet<Integer>();
        for(int i=1; i<occupied_student.length; i++){
            occupied_set.add(occupied_student[i]);
        }
        int desk_start_counter = 0;
        for(int i=0; i<array_row; i++){
            desk_start_counter++;
            populateRowElement(occupied_set,desk_start_counter,student_desk,i, 0);
            desk_start_counter++;
            populateRowElement(occupied_set,desk_start_counter,student_desk, i,1);
        }
        //displayArrayElement(student_desk,array_row);
    }

    private static void populateRowElement(Set<Integer> occupied_set, int desk_start_counter, StudentInformation student_desk[][], int i, int col_index){
        if(occupied_set.contains(desk_start_counter)){
            student_desk[i][col_index] = new StudentInformation(desk_start_counter, true);
        }else{
            student_desk[i][col_index] = new StudentInformation(desk_start_counter, false);
        }
    }

    private static int findMatchingResult(StudentInformation student_desk[][], int array_row){
        int count = 0 ;
        for(int i=0;i<array_row;i++){

            StudentInformation sd1 = student_desk[i][0];
            StudentInformation sd2 = student_desk[i][1];
            if(sd1.is_occupied == false && sd2.is_occupied == false){
                count++;
            }

            if(i+1<array_row){
                StudentInformation sd3 = student_desk[i+1][0];
                StudentInformation sd4 = student_desk[i+1][1];

                if(sd1.is_occupied == false && sd3.is_occupied == false){
                    count++;
                }

                if(sd2.is_occupied == false && sd4.is_occupied == false){
                    count++;
                }
            }
        }

        return count;
    }

    private static void displayArrayElement(StudentInformation student_desk[][], int array_row){
        for(int i=0;i<array_row;i++){
            System.out.print(student_desk[i][0].desk_no);
            System.out.print("  ");
            System.out.println(student_desk[i][1].desk_no);
        }
    }
}
