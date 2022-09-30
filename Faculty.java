import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Faculty implements Project{
    DbMysql db = new DbMysql();

    public void mainApp(){
        try {
            System.out.println("ENTER ID: ");
            Scanner sc1 = new Scanner(System.in);
            int id = sc1.nextInt();
            viewFacultyAssignedModule(id);
            System.out.println("1. VIEW STUDENT");
            System.out.println("2. MARK STUDENT");
            System.out.println("ENTER ANY NUMBER :- ");

            Scanner sc2 = new Scanner(System.in);
            int option = sc2.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter Module ID: ");
                    Scanner sc3 = new Scanner(System.in);
                    int moduleid = sc3.nextInt();
                    viewStudents(moduleid);
                    mainApp();
                    break;
                case 2:
                    markStudent();
                    mainApp();
                default:
                    System.out.println("Error!! Please enter valid option");
            }
        }catch(InputMismatchException ex){
            System.out.println("Error!! Please enter valid option");
        }
    }

    private void markStudent() {
        try {
            System.out.println("Enter Module ID: ");
            Scanner sc1 = new Scanner(System.in);
            int mID = sc1.nextInt();

            System.out.println("Enter Student ID: ");
            Scanner sc2 = new Scanner(System.in);
            int stdID = sc2.nextInt();

            System.out.println("Enter Mark: ");
            Scanner sc3 = new Scanner(System.in);
            int Mark = sc3.nextInt();
            db.markStudent(mID, stdID, Mark);
        }catch (InputMismatchException exe){
            System.out.println("Error!!!");
        }
    }

    private void viewStudents(int moduleid) {
        try {
            ResultSet result = db.getStudentsInModules();
            while (result.next()) {
                int studentID = result.getInt("StudentID");
                String studentName = result.getString("studentname");
                int  moduleID = result.getInt("moduleid");
                if (moduleID == moduleid) {
                    System.out.println("studentID: "+studentID+", studentName : "+studentName+"\n" );
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    private void viewFacultyAssignedModule(int id) {
        try {
            ResultSet result = db.getFacultyAssignedModule();
            while (result.next()) {
                int FacultyID = result.getInt("instructorID");
                String ModuleID = result.getString("ModuleID");
                String  modulename = result.getString("modulename");
                if (id == FacultyID) {
                    System.out.println("ModuleID:" +ModuleID+ "\nModule Name: " + modulename + "\n");
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}