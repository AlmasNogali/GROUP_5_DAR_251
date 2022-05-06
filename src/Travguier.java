
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Travguier {

    static File Emp_file_info;
    static File Cus_file_info;
    static ArrayList<Integer> ranMum = new ArrayList<Integer>();
    static int count_ran;

    public static void main(String[] args) throws FileNotFoundException {

        File Cus_file_info = new File("New_Cus_info.txt");
        File Emp_file_info = new File("New_Emp_info.txt");

        PrintWriter Writer_cus_info = new PrintWriter(Cus_file_info);
        PrintWriter Writer_emp_info = new PrintWriter(Emp_file_info);

//**************************************************************************************************
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("--------------- Welcome to TRAVGUIER System ---------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("1. SignUp Create A New Account.");
        System.out.println("2. Login To Your Account.");
        System.out.println("3. Exit.");
        System.out.println("------------------------------------------------------------");
        System.out.println("Write The Number Of Process :");

        int user_choise = sc.nextInt();

        while (true) {
            //SignUp
            if (user_choise == 2) {

                Login(sc2 , sc);

                break;
            //LogIn
            } else if (user_choise == 1) {

                System.out.println("Are you a customer(1) or an employee(2) ?");
                int user_choise2 = sc.nextInt();

                while (true) {
                    //if customer
                    if (user_choise2 == 1) {
                        SignUp(sc, Writer_cus_info, user_choise2);
                    //if employee
                    } else if (user_choise2 == 2) {
                        SignUp(sc, Writer_emp_info, user_choise2);
                        
                    } else {
                        System.out.println("\nPlease choose Againe!\n Are you a customer(1) or an employee(2) ?");
                        user_choise2 = sc.nextInt();
                    }
                }

            } else if (user_choise == 3) {
                break;
            } else {
                System.out.println("Please Try Againe : ");
                user_choise = sc.nextInt();
                continue;
            }

        }
        
        
        
        

        Writer_cus_info.flush();
        Writer_cus_info.close();
        Writer_emp_info.flush();
        Writer_emp_info.close();
    }

    public static void Login(Scanner sc, Scanner sc2) {

        System.out.println("Are you a customer(1) or an employee(2) ?");
        int user_choise = sc.nextInt();

        System.out.println("Please enter your username :");
        
        String UserName = sc.nextLine();

        System.out.println("Please enter your Password :");
        
        String Pword = sc.nextLine();

        while (true) {
            if (user_choise == 1) {
                
            } else if (user_choise == 2) {
                
            } else {
                System.out.println("\nPlease choose Againe!\n Are you a customer(1) or an employee(2) ?");
                user_choise = sc.nextInt();

            }

        }

    }

    public static void SignUp(Scanner sc, PrintWriter print_Writer, int cho) {

        System.out.println("Please enter username :");
        String u_name = sc.nextLine();

        System.out.println("Please enter Password :");
        String Pword = sc.nextLine();

        System.out.println("Please enter your First name :");
        String Fname = sc.nextLine();

        System.out.println("Please enter your Last name :");
        String Lname = sc.nextLine();

        System.out.println("Please enter your Nationality Number:");
        String nationality = sc.nextLine();

        System.out.println("Please enter your Gender (M for Male, F for Female):");
        char gen = sc.nextLine().charAt(0);

        System.out.println("Please enter your Phone number :");
        int phone = sc.nextInt();

        int ran = generatRamdomNum();

        if (cho == 1) {

            Customer cu = new Customer(u_name, Pword, Fname, Lname, nationality, gen, phone, ran, print_Writer);

        } else if (cho == 2) {

            Employee em = new Employee(u_name, Pword, Fname, Lname, nationality, gen, phone, ran, print_Writer);
        }

    }

    public static int generatRamdomNum() {
        //000000
        int id;
        int random_int = (int) Math.floor(Math.random() * (999999 - 100000 + 1) + 100000);

        for (int i = 0; i < count_ran; i++) {
            if (ranMum.get(i) == random_int) {
                random_int = (int) Math.floor(Math.random() * (999999 - 100000 + 1) + 100000);
                i = 0;
            }
        }
        ranMum.add(count_ran++, random_int);
        return id = random_int;
    }
}
