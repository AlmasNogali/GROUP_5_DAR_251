
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Travguier {

    static File Emp_file_info;
    static File Cus_file_info;
    static ArrayList ranMum;
    static int count_ran;

    public static void main(String[] args) throws FileNotFoundException {

        File Cus_file_info = new File("Cus_info.txt");
        File Emp_file_info = new File("Emp_info.txt");

        PrintWriter Writer_cus_info = new PrintWriter(Cus_file_info);
        PrintWriter Writer_emp_info = new PrintWriter(Emp_file_info);

        System.out.println("--------------- Welcome to TRAVGUIER System ---------------");
        System.out.println("Do you have an account?" + "\n Yes or No ?");

        Scanner sc = new Scanner(System.in);
        String user_choise = sc.nextLine();
        String user = "yes";
        String user2 = "no";

        while (true) {

            if (user_choise == "y" || user_choise == "Y" || user_choise.equalsIgnoreCase(user)) {

                Login(sc);

                break;

            } else if (user_choise.equalsIgnoreCase(user2) || user_choise == "n" || user_choise == "N") {

                System.out.println("Are you a customer(1) or an employee(2) ?");
                int user_choise2 = sc.nextInt();

                while (true) {
                    if (user_choise2 == 1) {
                        SignUp(sc, Writer_cus_info, user_choise2);
                    } else if (user_choise2 == 2) {
                        SignUp(sc, Writer_emp_info, user_choise2);
                    } else {
                        System.out.println("\nPlease choose Againe!\n Are you a customer(1) or an employee(2) ?");
                        user_choise2 = sc.nextInt();
                    }
                }

            } else {
                System.out.println("Please Try Againe : ");
                user_choise = sc.nextLine();
                continue;
            }

        }

        Writer_cus_info.flush();
        Writer_cus_info.close();
        Writer_emp_info.flush();
        Writer_emp_info.close();
    }

    public static void Login(Scanner sc) {

        System.out.println("Are you a customer(1) or an employee(2) ?");
        int user_choise = sc.nextInt();

        System.out.println("Please enter your username :");
        String u_name = sc.nextLine();

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
        while (true) {
            if (ranMum.equals(random_int)) {
                random_int = (int) Math.floor(Math.random() * (999999 - 100000 + 1) + 100000);
            } else {
                ranMum.add(count_ran++, random_int);
                break;
            }

        }
        return id = random_int;
    }
}
