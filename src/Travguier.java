
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Travguier {

    public static void main(String[] args) throws FileNotFoundException {

        File Cus_file = new File("output.txt");
        PrintWriter print_Writer = new PrintWriter(Cus_file);

        System.out.println("--------------- Welcome to TRAVGUIER System ---------------");
        System.out.println("Do you have an account?"
                + "\n Yes or No ?");

        Scanner sc = new Scanner(System.in);
        String user_choise = sc.nextLine();
        String user = "yes";
        String user2 = "no";

        while(true){
            
        if (user_choise.equalsIgnoreCase(user) || user_choise == "y") {
              Login(sc);
              break;
        } else if (user_choise.equalsIgnoreCase(user2) || user_choise == "n") {
            SignUp( sc , print_Writer );
            break;
        } else {
            System.out.println("Please Try Againe : ");
            user_choise = sc.nextLine();
            continue;
        }
        
        }

        print_Writer.flush();
        print_Writer.close();
    }
    
    public static void Login(Scanner sc){
                System.out.println("Please enter your username :");
                String u_name = sc.nextLine();
                
                System.out.println("Please enter your Password :");
                String Pword = sc.nextLine();

    }
    
    public static void SignUp (Scanner sc , PrintWriter print_Writer ){
        
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
                
                System.out.println("Please enter your Gender (W for women, M for man):");
                char gen = sc.nextLine().charAt(0);
                
                System.out.println("Please enter your Phone number :");
                int phone = sc.nextInt();
                
               print_Writer.println(u_name +" "+Pword +" "+Fname+" "+Lname+" "+nationality + " "+ gen + " "+ phone);
               
               
                
    }
    
}
