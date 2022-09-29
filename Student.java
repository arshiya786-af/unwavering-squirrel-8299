import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student implements Project{
    DbMysql db = new DbMysql();

    public void fileWriter(String filename, String content){
        try {
            Writer write = new BufferedWriter(new FileWriter(filename,true));
            write.write(content);
            write.close();
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public void mainApp(){
        try {
            System.out.println("COURSES!!");
            viewCourses();
            System.out.println("ENTER YOUR NAME: ");
            Scanner sc1 = new Scanner(System.in);
            String stName = sc1.nextLine();
            System.out.println("ENTER COURSE ID: ");
            Scanner sc2 = new Scanner(System.in);
            String courseId = sc2.nextLine();
            System.out.println("ENTER LEVEL: ");
            Scanner sc3 = new Scanner(System.in);
            int stdLevel = sc3.nextInt();
            System.out.println("ENTER LEVEL: ");
            db.studentRegistration(stName, courseId, stdLevel);
            getStdID(stName);
            viewModulesAlongwithFaculty(courseId, stdLevel);

        }catch (InputMismatchException e){
            System.out.println("Error!! Please enter valid option");
        }
    }

    private void viewModulesAlongwithFaculty(String courseId, int stdLevel) {
        try {
            ResultSet result = db.getModulesAlongwithFaculty();
            String content = "";
            while (result.next()) {
                String courseID = result.getString("courseID");
                int ModuleID = result.getInt("ModuleID");
                String  moduleName = result.getString("modulename");
                int level = result.getInt("modulelevel");
                int sem = result.getInt("semester");

                String FacultyName = result.getString("FacultyName");

                if(courseId.equals(courseID) && level == stdLevel) {
                    System.out.println("Module ID : "+ ModuleID +"\nmoduleName :"+ moduleName +"\nCourse Level : " + level + "\nsemester : " + sem + "\nFaculty Name: "+ FacultyName +"\n");
                    String routine =  courseID + level +"Routine.txt";
                    content = "Module ID : "+ ModuleID +"\nmoduleName :"+ moduleName +"\nCourse Level : " + level + "\nsemester : " + sem + "\nFaculty Name: "+ FacultyName +"\n";
                    fileWriter(routine, content);
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    private void getStdID(String stName) {
        try {
            ResultSet result = db.getStudent();
            while (result.next()) {
                int id = result.getInt("id");
                String name =  result.getString("studentname");

                if(name.equals(stName)) {
                    System.out.println("STUDENT ID:" + id);
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    private void viewCourses() {
        try {
            ResultSet result = db.getCourses();
            while (result.next()) {
                String id = result.getString("id");
                String name = result.getString("coursename");
                boolean cStats = result.getBoolean("coursestatus");

                System.out.println("Course ID : "+ id + "\nCourse Name : " + name + "\nCourse Status : " + cStats +"\n");
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}