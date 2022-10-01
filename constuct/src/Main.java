import java.io.*;
import java.util.Scanner;

public class Main {
    String pass = "";
    int flag = 0;
    private void login(){
        try {
            File ob = new File("adminpassword.txt");
            Scanner sc = new Scanner(ob);
            while (sc.hasNextLine()) {
                pass = sc.nextLine();
            }
            System.out.println("Enter Password: ");
            Scanner sc1 = new Scanner(System.in);
            String password = sc1.nextLine();

            if(!password.equals(pass)){
                System.out.println("Incorrect Password");
                login();
            }
            flag = 1;
        } catch (IOException ex) {
            System.out.println("Error!!!");
        }
    }

    public Main(){

        Admin admin = new Admin();
        Student student = new Student();
        Instructor instructor = new Instructor();
        System.out.println("================================");
        System.out.println("    COURSE MANAGEMENT SYSTEM    ");
        System.out.println("================================");
        System.out.println("1. STUDENT");
        System.out.println("2. ADMIN");
        System.out.println("3. INSTRUCTOR");
        System.out.println("--------------------------------");
        System.out.println("ENTER NUMBER - ");
        Scanner option1 = new Scanner(System.in);
        int option = option1.nextInt();
        switch (option) {
            case 1:
                student.mainApp();
                break;
            case 2:
//                if(flag == 0){
//                    login();
//                }
                admin.mainApp();
                break;
            case 3:
                instructor.mainApp();
                break;
            default:
                System.out.println("Error!! Please enter valid option");
        }
    }
    public static void main(String[] args){
        new Main();
    }
}