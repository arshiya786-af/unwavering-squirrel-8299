import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void mainMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("************************************");
        System.out.println("Course Managment System");
        System.out.println("************************************");
        int selectedOption = 0;
        System.out.println();
        System.out.println("What is your role?");
        System.out.println("--------------------------------------");
        System.out.println("          1. Student                   ");
        System.out.println("          2. Instructor                ");
        System.out.println("          3. Course Administrator      ");
        System.out.println("          4. Exit                      ");
        System.out.println("---------------------------------------");
        System.out.print("\nEnter Option: ");
        try{
            selectedOption = scan.nextInt();
            switch (selectedOption){
                case 1:
                    studentMenu();
                    break;

                case 2:
                    instructorMenu();
                    break;

                case 3:
                    adminMenu();
                    break;

                case 4:
                    System.out.println("Exiting the application...");
                    System.exit(0);

                default:
                    System.out.println("Error! Please input only the number options available above!!!");
                    mainMenu();
            }
        }catch(InputMismatchException e) {
            scan.next();
            System.out.println("Please input only the number options available above!!!");
            System.out.println();
            System.out.println();
            System.out.println();
            mainMenu();
        }
    }
    public static void studentMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("************************************");
        System.out.println("         Student Menu                ");
        System.out.println("************************************");
        int selectedOption = 0;
        System.out.println();
        System.out.println("Are you enrolled?");
        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("3. Return to Main menu");
        System.out.println("4. Exit");
        System.out.println("--------------------------------------");
        System.out.println();
        System.out.print("\nEnter Option: ");
        try{
            selectedOption = scan.nextInt();
            switch (selectedOption){
                case 1:
                    enrolledStudentMenu();
                    break;

                case 2:
                    Student st1 = new Student();
                    st1.enroll();
                    break;

                case 3:
                    mainMenu();
                    break;

                case 4:
                    System.out.println("Exiting the application...");
                    System.exit(0);

                default:
                    System.out.println("Error! Please input only the number options available above!!!");
                    studentMenu();
            }
        }catch(InputMismatchException e) {
            scan.next();
            System.out.println("Please input only the number options available above!!!");
            System.out.println();
            System.out.println();
            System.out.println();
            studentMenu();
        }

    }
    public static void enrolledStudentMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("************************************");
        System.out.println("     Enrolled Student Menu          ");
        System.out.println("************************************");
        int selectedOption = 0;
        System.out.println();
        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("        1. View Instructors           ");
        System.out.println("        2. Return to Student Menu     ");
        System.out.println("        3. Return to Main Menu        ");
        System.out.println("        4. Exit                       ");
        System.out.println("--------------------------------------");
        System.out.println();
        System.out.print("\nEnter Option: ");
        try{
            selectedOption = scan.nextInt();
            switch (selectedOption){
                case 1:
                    System.out.print("Enter student ID:");
                    Scanner sc = new Scanner(System.in);
                    int studentID=sc.nextInt();
                    Student st = new Student();
                    if(st.isInDatabase(studentID)){
                        System.out.println("              Instructor List          ");
                        st.displayInstructorsOnStudent();
                    }else{
                        System.out.println("Student ID doesn't exist!!");
                        studentMenu();
                    }
                    break;

                case 2:
                    studentMenu();
                    break;

                case 3:
                    mainMenu();
                    break;

                case 4:
                    System.out.println("Exiting the application...");
                    System.exit(0);

                default:
                    System.out.println("Error! Please input only the number options available above!!!");
                    enrolledStudentMenu();
            }
        }catch(InputMismatchException e) {
            scan.next();
            System.out.println("Please input only the number options available above!!!");
            System.out.println();
            System.out.println();
            System.out.println();
            enrolledStudentMenu();
        }
    }

    public static void instructorMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("************************************");
        System.out.println("          Instructor Menu           ");
        System.out.println("************************************");
        int selectedOption = 0;
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("          1. View Modules              ");
        System.out.println("          2. View Students             ");
        System.out.println("          3. Add Marks                 ");
        System.out.println("          4. Return to Main Menu       ");
        System.out.println("          5. Exit                      ");
        System.out.print("\nEnter Option: ");
        try{
            selectedOption = scan.nextInt();
            switch (selectedOption){
                case 1:
                    System.out.print("Enter Instructor ID: ");
                    Scanner sc = new Scanner(System.in);
                    int instructorID = Integer.parseInt(sc.nextLine());
                    Instructor ins = new Instructor();
                    if(ins.isInDatabase(instructorID)==true) {
                        System.out.println("          Modules List                 ");
                        ins.displayModules();
                    }
                    break;

                case 2:
                    System.out.print("Enter Instructor ID: ");
                    Scanner sc1 = new Scanner(System.in);
                    int instructorID1 = Integer.parseInt(sc1.nextLine());
                    Instructor ins1 = new Instructor();
                    if(ins1.isInDatabase(instructorID1)==true) {
                        System.out.println("          Students List                 ");
                        ins1.displayStudentFromInstructor();
                    }
                    break;

                case 3:
                    System.out.print("Enter Instructor ID: ");
                    Scanner sc2 = new Scanner(System.in);
                    int instructorID2 = Integer.parseInt(sc2.nextLine());
                    Instructor ins2 = new Instructor();
                    if(ins2.isInDatabase(instructorID2)==true) {
                        System.out.println("          Add Marks                 ");
                        ins2.addGrade();
                    }
                    break;

                case 4:
                    mainMenu();
                    break;

                case 5:
                    System.out.println("Exiting the application...");
                    System.exit(0);

                default:
                    System.out.println("Error! Please input only the number options available above!!!");

                    instructorMenu();
            }
        }catch(InputMismatchException e) {
            scan.next();
            System.out.println("Please input only the number options available above!!!");
            System.out.println();
            System.out.println();
            System.out.println();
            instructorMenu();
        }
    }

    public static void adminMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("************************************");
        System.out.println("          Admin Menu                ");
        System.out.println("************************************");
        int selectedOption = 0;
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("          1. Log In                   ");
        System.out.println("          2. Return to Main Menu       ");
        System.out.println("          3. Exit                      ");
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.print("\nEnter Option: ");
        try{
            selectedOption = scan.nextInt();
            switch (selectedOption){
                case 1:
                    System.out.println("          Admin Login                   ");
                    Scanner sc = new Scanner(System.in);
                    Administrator ad = new Administrator();
                    if(ad.adminLogin()==true){
                        System.out.println("login successful....");
                        adminLoggedInMenu();
                    }else{
                        adminMenu();
                    }
                    break;

                case 2:
                    mainMenu();
                    break;

                case 3:
                    System.out.println("Exiting the application...");
                    System.exit(0);

                default:
                    System.out.println("Error! Please input only the number options available above!!!");
                    adminMenu();
            }
        }catch(InputMismatchException e) {
            scan.next();
            System.out.println("Please input only the number options available above!!!");
            System.out.println();
            System.out.println();
            System.out.println();
            adminMenu();
        }
    }
    public static void adminLoggedInMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("************************************");
        System.out.println("          Admin Panel               ");
        System.out.println("************************************");
        int selectedOption = 0;
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("          1. Add Course               ");
        System.out.println("          2. Add module               ");
        System.out.println("          3. Delete Course            ");
        System.out.println("          4. Edit Course              ");
        System.out.println("          5. Edit Module              ");
        System.out.println("          6. Add New Instructor       ");
        System.out.println("          7. Assign Instructor"        );
        System.out.println("          8. Cancel Course            ");
        System.out.println("          9. Resume Course            ");
        System.out.println("          10. Update Instructor       ");
        System.out.println("          11. Generate Report Slip    ");
        System.out.println("          12. Log Out                 ");
        System.out.println("          13. Return to Main menu     ");
        System.out.println("          14. Exit                    ");
        System.out.println("");
        System.out.println("---------------------------------------");
        System.out.print("\nEnter Option: ");
        try{
            Administrator ad = new Administrator();
            selectedOption = scan.nextInt();
            switch (selectedOption){
                case 1:
                    System.out.println("        Add New Course                ");
                    Course co = new Course();
                    co.addCourse();
                    break;

                case 2:
                    System.out.println("          Add New Module              ");
                    ad.addModule();

                case 3:
                    System.out.println("           Delete Course              ");
                    Course co1 = new Course();
                    co1.deleteCourse();
                    break;

                case 4:
                    System.out.println("           Update Course              ");
                    ad.updateCourse();
                    break;

                case 5:
                    System.out.println("            Update Module             ");
                    ad.updateModule();
                    break;

                case 6:
                    System.out.println("       Add New Instructor             ");
                    ad.assignNewInstructor();

                    break;

                case 7:
                    System.out.println("        Assign Instructor             ");
                    ad.assignInstructorToCourse();
                    break;

                case 8:
                    System.out.println("            Cancel Course             ");
                    ad.cancelCourse();

                case 9:
                    System.out.println("          Resume Course               ");
                    ad.resumeCourse();
                    break;

                case 10:
                    System.out.println("       Update Instructor              ");
                    ad.updateInstructor();
                    break;

                case 11:
                    ad.resultSlip();
                    break;

                case 12:

                    adminMenu();
                    break;

                case 13:
                    mainMenu();
                    break;

                case 14:
                    System.out.println("Exiting the application...");
                    System.exit(0);

                default:
                    System.out.println("Error! Please input only the number options available above!!!");
                    adminLoggedInMenu();
            }
        }catch(InputMismatchException e) {
            scan.next();
            System.out.println("Please input only the number options available above!!!");
            adminLoggedInMenu();
        }
    }
    public static void main(String[] args) {
        mainMenu();
    }
}