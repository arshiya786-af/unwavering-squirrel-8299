import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin implements Project {
    DbMysql db = new DbMysql();
    public void mainApp(){
        try {
            System.out.println("1. Add Course");
            System.out.println("2. Add Module");
            System.out.println("3. Cancel Course");
            System.out.println("4. Resume Course");
            System.out.println("5. Delete Course");
            System.out.println("6. Delete Module");
            System.out.println("7. Assign Faculty");
            System.out.println("8. Remove Faculty");
            System.out.println("9. Change Course Name");
            System.out.println("10. Print Result Slip");
            System.out.println("ENTER ANY NUMBER :- ");
            Scanner sc1 = new Scanner(System.in);
            int option = sc1.nextInt();
            switch (option) {
                case 1:
                    addCourse();
                    mainApp();
                    break;
                case 2:
                    addModule();
                    mainApp();
                    break;
                case 3:
                    cancelCourse();
                    mainApp();
                    break;
                case 4:
                    resumeCourse();
                    mainApp();
                    break;
                case 5:
                    deleteCourse();
                    mainApp();
                    break;
                case 6:
                    deleteModule();
                    mainApp();
                    break;
                case 7:
                    assignFaculty();
                    mainApp();
                    break;
                case 8:
                    removeFaculty();
                    mainApp();
                    break;
                case 9:
                    changeCourseName();
                    mainApp();
                    break;
                case 10:
                    resultSlip();
                    mainApp();
                    break;
                default:
                    System.out.println("Error!! Please enter valid number");
            }
        }catch(InputMismatchException exc ){
            System.out.println("Error!! Please enter valid option");
        }
    }
    int sum=0,Module=0;
    private void printmark(int stID){
        try {
            ResultSet result = db.getMarks();
            while (result.next()) {
                int studentID = result.getInt("stdID");
                String moduleID = result.getString("moduleID");
                int moduleMark = result.getInt("Mark");
                if (studentID == stID) {
                    System.out.println("moduleID : "+moduleID+ " moduleMark : "+moduleMark+"\n");
                    sum +=moduleMark;
                    Module++;
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    private void resultSlip() {
        try {
            System.out.println("Enter Student ID: ");
            Scanner sc1 = new Scanner(System.in);
            int stID = sc1.nextInt();
            printmark(stID);
            int gradePercentage = sum / Module;
            Module = 0;
            sum = 0;
            System.out.println("Percentage: " + gradePercentage + "%");
            if (gradePercentage > 40) {
                System.out.println("\nStudent Can proceed to Next Level of Study\n");
            } else {
                System.out.println("\nStudent Cannot proceed to Next Level of Study\n");
            }
        }catch (ArithmeticException a){
            System.out.println("Marks not added yet");
        }

    }

    private void removeFaculty() {
        try {
            System.out.println("Enter Faculty ID:");
            Scanner sc1 = new Scanner(System.in);
            int id = sc1.nextInt();
            db.removeFaculty(id);
        }catch(InputMismatchException exe){
            System.out.println("Error!!");
        }
    }

    private void assignFaculty() {
        try{
            System.out.println("Enter Faculty Name: ");
            Scanner sc2 = new Scanner(System.in);
            String FacultyName = sc2.nextLine();
            System.out.println("Module ID: ");
            Scanner sc3 = new Scanner(System.in);
            String moduleId = sc3.nextLine();
            db.addAssignFaculty(FacultyName,moduleId);
        }catch (InputMismatchException ex){
            System.out.println("Error!! Enter valid detail");
        }
    }

    private void changeCourseName() {
        System.out.println("Enter Course ID: ");
        Scanner sc1 = new Scanner(System.in);
        String courseID = sc1.nextLine();
        System.out.println("Enter New Course Name: ");
        Scanner sc2 = new Scanner(System.in);
        String courseName = sc2.nextLine();
        db.changeCourseName(courseID, courseName);
    }

    private void deleteModule() {
        try{
            System.out.println("Enter Module ID: ");
            Scanner sc1 = new Scanner(System.in);
            int moduleID = sc1.nextInt();
            db.deleteModule(moduleID);
        }catch (InputMismatchException ex){
            System.out.println("Error!! Please enter valid option");
        }
    }

    private void deleteCourse() {
        System.out.println("Enter Course ID: ");
        Scanner sc1 = new Scanner(System.in);
        String courseID = sc1.nextLine();
        db.deleteCourse(courseID);
    }

    private void resumeCourse() {
        System.out.println("Enter Course ID: ");
        Scanner sc1 = new Scanner(System.in);
        String id = sc1.nextLine();
        db.updateCourseStatus(id,true);
    }

    private void cancelCourse() {
        System.out.println("Enter Course ID: ");
        Scanner sc1 = new Scanner(System.in);
        String id = sc1.nextLine();
        db.updateCourseStatus(id,false);
    }

    private void addModule() {
        try {
            System.out.println("Enter Module ID: ");
            Scanner sc1 = new Scanner(System.in);
            int moduleID = sc1.nextInt();
            System.out.println("Enter Module Name: ");
            Scanner sc2 = new Scanner(System.in);
            String moduleName = sc2.nextLine();
            System.out.println("Enter Module Level: ");
            Scanner sc3 = new Scanner(System.in);
            int level = sc3.nextInt();
            System.out.println("Enter semester: ");
            Scanner sc5 = new Scanner(System.in);
            int semester = sc5.nextInt();
            System.out.println("Enter course ID: ");
            Scanner sc4 = new Scanner(System.in);
            String courseID = sc4.nextLine();
            db.addModules(moduleID, moduleName, level, semester,courseID);
        }catch (InputMismatchException ex){
            System.out.println("Error!! Please enter valid option");
        }
    }

    private void addCourse() {
        System.out.println("Enter Course ID: ");
        Scanner sc2 = new Scanner(System.in);
        String id = sc2.nextLine();
        System.out.println("Enter Course Name: ");
        Scanner sc3 = new Scanner(System.in);
        String name = sc3.nextLine();
        db.addCourse(id, name, true);
    }
}