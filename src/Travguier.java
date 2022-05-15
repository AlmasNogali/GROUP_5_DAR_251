
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Travguier {

    static File Emp_file_info;
    static File Cus_file_info;
    static ArrayList<Integer> ranMum = new ArrayList<Integer>();
    static int count_ran;
    static String Name;
    static String Pass;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File Cus_file_info = new File("New_Cus_info.txt");
        File Emp_file_info = new File("New_Emp_info.txt");
        File Log_cus = new File("Cus_info.txt");
        File Log_emp = new File("Emp_info.txt");

        Scanner Read_Log_cus = new Scanner(Log_cus);
        Scanner Read_Log_emp = new Scanner(Log_emp);
        Scanner rs = new Scanner(Log_emp);
        Scanner sc = new Scanner(System.in);
        PrintWriter Writer_cus_info = new PrintWriter(Cus_file_info);
        PrintWriter Writer_emp_info = new PrintWriter(Emp_file_info);

        BufferedWriter wr = new BufferedWriter(new FileWriter("Reservation_info.txt", true));

//**************************************************************************************************
        Customer custm = new Customer();
        Employee employ = new Employee();

        //boolean m = true;
        while (true) {

            initialMenu();

            int user_choise = sc.nextInt();

            switch (user_choise) {

                case 1: {

                    System.out.print("Please enter username : ");
                    String u_name = sc.next();

                    System.out.print("Please enter Password : ");
                    String Pword = sc.next();

                    System.out.print("Please enter your First name : ");
                    String Fname = sc.next();

                    System.out.print("Please enter your Last name : ");
                    String Lname = sc.next();

                    System.out.print("Please enter your Nationality Number: ");
                    String nationality = sc.next();

                    System.out.print("Please enter your Gender (M for Male, F for Female): ");
                    char gen = sc.next().charAt(0);

                    System.out.print("Please enter your Phone number : ");
                    String phone = sc.next();

                    int ran = generatRamdomNum();

                    Scanner Read_Log_cus3 = new Scanner(Log_cus);
                    Scanner Read_Log_cus5 = new Scanner(Log_cus);

                    custm.SignUp(sc, Read_Log_cus5, Read_Log_cus3, Writer_cus_info, ran, u_name, Pword, Fname, Lname, nationality, gen, phone);
                    System.out.print(" adding is done !");
                    break;
                }
                case 2: {

                    System.out.print("Are you a customer(1) or an employee(2) ? ");
                    int userType = sc.nextInt();

                    System.out.print("Please enter your username : ");
                    String UserName = sc.next();
                    System.out.print("Please enter your Password : ");
                    String Pword = sc.next();

                    while (true) {

                        if (userType == 1) {

                            Scanner Read_Log_cus1 = new Scanner(Log_cus);
                            Scanner Read_Log_cus2 = new Scanner(Log_cus);
                            int val = custm.Login(UserName, Pword, Read_Log_cus1, Read_Log_cus2);
                            if (val == 0) {
                                System.out.print("Please enter your username : ");
                                UserName = sc.next();
                                System.out.print("Please enter your Password : ");
                                Pword = sc.next();
                                continue;
                            }

                            while (true) {
                                processMenu();
                                int user_choise2 = sc.nextInt();

                                switch (user_choise2) {

                                    case 3: {
                                        //Add reservations
                                        Add_plan(sc, wr, custm);

                                        break;
                                    }
                                    case 4: {
                                        //View reservations
                                        Scanner Read_Log_cus7 = new Scanner(Log_cus);
                                        Scanner Read_Log_cus8 = new Scanner(Log_cus);
                                        custm.viewCusReserv(Read_Log_cus7, Read_Log_cus8);
                                        break;
                                    }
                                    case 5: {
                                        //Edit reservations
                                        Scanner Read_Log_cus7 = new Scanner(Log_cus);
                                        Scanner Read_Log_cus8 = new Scanner(Log_cus);
                                        custm.viewCusReserv(Read_Log_cus7, Read_Log_cus8);

                                        System.out.println("1. Edit Destination.");
                                        System.out.println("2. Edit Budget.");
                                        System.out.println("3. Edit Airline.");
                                        System.out.println("Please choose from 1 to 3: ");


                                        break;
                                    }
                                    case 6: {
                                        //Delete reservations
                                        Scanner Read_Log_cus9 = new Scanner( new File("Cus_info2.txt"));
                                        Scanner Read_Log_cus0 = new Scanner( new File("Cus_info2.txt"));
                                        int res_num = custm.viewCusReserv(Read_Log_cus9, Read_Log_cus0);


                                        while (true) {

                                            if (res_num > 0) {
                                                System.out.print("Enter the reservation number that do you want to delete it: ");
                                                String planID = sc.next();
                                                Delete("Cus_info2.txt", planID, 9, ",");
                                                System.out.println("The deletion is done !");

                                                res_num --;
                                                
                                                System.out.println("\n\n1. Redisplay.");
                                                System.out.println("2. Delete reservation.");
                                                System.out.println("3. Exit.\n\n");
                                                System.out.println("Please choose from 1 to 3: ");
                                                int choose = sc.nextInt();
                                                
                                                switch (choose) {

                                                    case 1: {

                                                        Read_Log_cus9 = new Scanner( new File("Cus_info2.txt"));
                                                        Read_Log_cus0 = new Scanner( new File("Cus_info2.txt"));
                                                        custm.viewCusReserv(Read_Log_cus9, Read_Log_cus0);

                                                        break;
                                                    }

                                                    case 2: {
                                                        System.out.print("Enter the reservation number that do you want to delete it: ");
                                                        planID = sc.next();
                                                        Delete("Cus_info2.txt", planID, 9, ",");
                                                        System.out.println("The deletion is done !");
                                                        break;
                                                    }
                                                    case 3: {
                                                        System.exit(0);
                                                        break;
                                                    }
                                                    default: {
                                                        System.out.println("\n\n please choose again !");
                                                        System.out.println("1. Redisplay.");
                                                        System.out.println("2. Delete reservation.");
                                                        System.out.println("3. Exit.\n\n");
                                                        System.out.println("Please choose from 1 to 3: ");
                                                        choose = sc.nextInt();
                                                        //break;
                                                    }

                                                }

                                            } else {
                                                System.out.println(" There are no reservations for that customer");
                                                break;
                                            }
                                         }
                                        
                                    }
                                    case 9: {
                                        System.out.print(" *********** THANK YOU FOR VISITINY OUR APPLICATION *********** \n\n");
                                        System.exit(0);
                                        break;
                                    }

                                }

                            }

                        } else if (userType == 2) {
                            Scanner Read_Log_emp1 = new Scanner(Log_emp);
                            Scanner Read_Log_emp2 = new Scanner(Log_emp);
                            employ.Login(UserName, Pword, Read_Log_emp1, Read_Log_emp2);
                            break;

                        } else {

                            System.out.print("no obj");
                            break;
                        }

                    }

                }
                case 9: {
                    System.out.print(" *********** THANK YOU FOR VISITINY OUR APPLICATION *********** \n\n");
                    System.exit(0);
                    break;

                }

            }

            break;
        }

        //boolean s = true;
        Writer_cus_info.flush();
        Writer_cus_info.close();
        Writer_emp_info.flush();
        Writer_emp_info.close();

    }

    public static void initialMenu() {

        System.out.println("--------------- Welcome to TRAVGUIER System ---------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("1. SignUp Create A New Account.");
        System.out.println("2. Login To Your Account.");
        System.out.println("9. Exit.");
        System.out.println("------------------------------------------------------------");
        System.out.print("Write The Number Of Process : ");

    }

    public static void processMenu() {

        System.out.println("\n\n--------------- Welcome to TRAVGUIER System ---------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("3. Add reservation info.");
        System.out.println("4. View reservation info.");
        System.out.println("5. Edit reservation info.");
        System.out.println("6. Delete reservation info.");
        System.out.println("9. Exit.");
        System.out.println("------------------------------------------------------------");
        System.out.print("Write The Number Of Process : ");

    }

  public static void Delete(String filePath, String planID, int positionOfTerm, String delimiter) {
       int position = positionOfTerm - 1;
       File inputFile = new File(filePath);
        File NewFile = new File("myTempFile.txt");
        
        String currenline;
        String Data[];
        
        try {
            
        BufferedWriter writer = new BufferedWriter(new FileWriter(NewFile,true));
        PrintWriter pWriter = new PrintWriter(writer);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        
        while((currenline = reader.readLine()) != null) {
        Data =currenline.split(",");
        if (!(Data[position].equalsIgnoreCase(planID))){
               pWriter.println(currenline);
        }
        
               }
       pWriter.close();
        pWriter.flush();
        writer.close();
        reader.close();
        
        
        inputFile.delete();
        File trem= new File (filePath);
        NewFile.renameTo(trem);
        
        
        } catch (IOException e) {}
        

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

    public static void Add_plan(Scanner sc, BufferedWriter wr, Customer cu2) throws IOException {

        System.out.print("Please enter the destination: ");
        String place = sc.next();

        System.out.print("Please enter your budget: ");
        int budget = sc.nextInt();

        System.out.print("Please enter the desired airline: ");
        String airline = sc.next();

        System.out.print("Approximately how many times can you make a reservations per month?: ");
        int r_perMonth = sc.nextInt();

        int plan_id = generatRamdomNum();

        Reservation plan = new Reservation(plan_id, place, budget, airline, r_perMonth);

        cu2 = new Customer();

        cu2.addResrvation(plan);

        if (cu2.addResrvation(plan) == true) {
            while (true) {
                System.out.println("\n Your resrvation is complete!\n");
                wr.write(plan.toString());
                break;
            }
        } else {
            System.out.println("You did not enter the budget or how many reservation you want !,Please enter again: \n");
            Add_plan(sc, wr, cu2);
        }
        wr.close();
    }
}
