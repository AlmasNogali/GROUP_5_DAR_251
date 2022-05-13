/*
 * Almas- Mona - Dana-Jomanh-somaya 
 */


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
    Reservation[] planes = new Reservation[plancount];
    static int plancount;

    public static void main(String[] args) throws FileNotFoundException {

        File Cus_file_info = new File("New_Cus_info.txt");
        File Emp_file_info = new File("New_Emp_info.txt");
        File reservation_file_info = new File("C:\\Users\\moono\\Documents\\NetBeansProjects\\GROUP_5_DAR_251\\Reservation_info.txt");

        PrintWriter Writer_cus_info = new PrintWriter(Cus_file_info);
        PrintWriter Writer_emp_info = new PrintWriter(Emp_file_info);
        PrintWriter Writer_res_info = new PrintWriter(reservation_file_info);

//**************************************************************************************************
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("--------------- Welcome to TRAVGUIER System ---------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("1. SignUp Create A New Account.");
        System.out.println("2. Login To Your Account.");
        System.out.println("3. Add New Reservation.");
        System.out.println("4. Exit.");
        System.out.println("------------------------------------------------------------");
        System.out.println("Write The Number Of Process :");

        int user_choise = sc.nextInt();
        
        while (true) {
            //SignUp
            if (user_choise == 2) {

                Login(sc2, sc);
                break;
                //LogIn
            } else if (user_choise == 1) {

                System.out.println("Are you a customer(1) or an employee(2) ?");
                int user_choise2 = sc.nextInt();

                while (true) {
                    //if customer
                    if (user_choise2 == 1) {
                        SignUp(sc, Writer_cus_info, user_choise2);
                        break;
                        //if employee
                    } else if (user_choise2 == 2) {
                        SignUp(sc, Writer_emp_info, user_choise2);
                        break;
                    } else {
                        System.out.println("\nPlease choose Againe!\n Are you a customer(1) or an employee(2) ?");
                        user_choise2 = sc.nextInt();
                        continue;
                        
                    }
                }

               
            } else if (user_choise == 3) {

                System.out.println("Do you want to add reservation (Y/N) ?");
                String user_choise3 = "";

                while (true) {
                    user_choise3 = sc.nextLine();
                    //if customer add reservation
                    if (user_choise3.equalsIgnoreCase("y")) {
                        Add_plan(sc,Writer_res_info);

                    } else if (user_choise3.equalsIgnoreCase("n")) {
                        System.out.println("Thank you!\n");
                        System.exit(0);
                    }
//                    else  {
//                        System.out.println("\nPlease choose Againe!\n Do you want to add reservation (Y/N) ?");
//                        user_choise3 = sc.nextLine();
//
//                    }

                }

            } else if (user_choise == 4) {
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
        Writer_res_info.flush();
        Writer_res_info.close();
    }

    public static void Login(Scanner sc, Scanner sc2) {

        System.out.println("Are you a customer(1) or an employee(2) ?");
        int user_choise = sc.nextInt();

        System.out.println("Please enter your username :");

        String UserName = sc.next();

        System.out.println("Please enter your Password :");

        String Pword = sc.next();

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

    public static void Add_plan(Scanner sc,PrintWriter print_Writer) {
        String confirmation_msg = null;
        System.out.println("Please enter how many reservations per month?: ");
        plancount = sc.nextInt();

        System.out.println("Please enter your budget: ");
        int budget = sc.nextInt();

        System.out.println("Please enter the destination: ");
        String place = sc.next();

        System.out.println("Please enter the desired airline: ");
        String airline = sc.next();

        int plan_id = generatRamdomNum();

        Reservation plan = new Reservation(plan_id, place, budget, airline);

        Reservation[] p = new Reservation[plancount];
        if (plancount > 0) {
            for (int i = 0; i < p.length; i++) {
                p[i] = plan;
                System.out.println(p[i]);
            }
            System.out.println("\n Your resrvation is complete!\n");
             print_Writer.println(p);
            
        } else {
            System.out.println("you did not enter how mant reservation you want !! ");
        }
        
     
    }
}


