import java.util.ArrayList;

public class StudentManagement {

    private static ArrayList<Student> students = new ArrayList<>();
    private static int idGenerator = 1;

    public static void add(String name, int marks) {
        Student student = new Student(idGenerator++, name, marks);
        students.add(student);
        System.out.println("Student Added Successfully");
    }

    public static void view(){

        if(students.isEmpty()){
            System.out.println("No Student Data available");
            return ;
        }

        System.out.printf("%-10s %-15s %-10s%n", "ID", "Name", "Marks");
        System.out.println("-----------------------------------------");

        for(Student s : students){
            System.out.printf("%-10s %-15s %-10s%n", s.getId(), s.getName(), s.getMarks());
        }
    }
    
    public static void updateName(int id, String name){
        for(Student s : students){
            if(s.getId() == id){
                s.setName(name);
                System.out.println("Updated Student name Successfully");
                return;
            }
        }
        System.out.println("No such ID..");
    }

    public static void updateMark(int id, int marks){
        for(Student s : students){
            if(s.getId() == id){
                s.setMarks(marks);
                System.out.println("Updated Student mark Successfully");
                return;
            }
        }
        System.out.println("No such ID..");
    }

    public static void delete(int id){
        for(Student s : students){
            if(s.getId() == id){
                students.remove(s);
                System.out.println("Deleted Successfully");
                return;
            }
        }
        System.out.println("No such ID...");
    }
}
