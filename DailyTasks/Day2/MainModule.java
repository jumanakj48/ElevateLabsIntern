import java.util.*;

public class MainModule {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("\n----Student Management System------\n");
            System.out.println("1. Add Student");
            System.out.println("2. View all Students");
            System.out.println("3. Update Student Name");
            System.out.println("4. Update Student marks");
            System.out.println("5. Delete a Student");
            System.out.println("6. exit");
            System.out.print("\nEnter your choice: ");


            int choice = sc.nextInt();
            

            switch(choice){
                case 1 : 
                sc.nextLine();
                    System.out.print("Enter Student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Student marks: ");
                    int marks = sc.nextInt();
                    StudentManagement.add(name, marks);
                    break;

                case 2:
                    StudentManagement.view();
                    break;
                case 3:
                    System.out.print("Enter Student id to update: ");
                    int delid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student name to update: ");
                    String delname = sc.nextLine();
                    StudentManagement.updateName(delid, delname);
                    break;
                case 4:
                    System.out.print("Enter Student id to update: ");
                    int updid = sc.nextInt();
                    System.out.print("Enter Student mark to update: ");
                    int updmark = sc.nextInt();
                    StudentManagement.updateMark(updid, updmark);   
                    break;
                case 5:
                    System.out.print("Enter Student id to delete: ");
                    int ipdel = sc.nextInt();
                    StudentManagement.delete(ipdel);
                    break;
                case 6 : 
                    sc.close();
                    System.exit(0);
                    break;
                default: System.out.println("Invalid Choice..");
                
            }
        }
    }
}
