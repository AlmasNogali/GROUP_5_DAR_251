
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee {

    private int Emp_id;
    private String Emp_Username;
    private String Emp_Password;
    private String Emp_Fname;
    private String Emp_Lname;
    private String Emp_nationality;
    private char Emp_gender;
    private String Emp_phone;

    public Employee() {
    }

    public Employee(String Emp_Username, String Emp_Password, String Emp_Fname, String Emp_Lname, String Emp_nationality,
             char Emp_gender, String Emp_phone, int Emp_id, PrintWriter print_Writer) {

        this.Emp_Username = Emp_Username;
        this.Emp_Password = Emp_Password;
        this.Emp_Fname = Emp_Fname;
        this.Emp_Lname = Emp_Lname;
        this.Emp_nationality = Emp_nationality;
        this.Emp_gender = Emp_gender;
        this.Emp_phone = Emp_phone;
        this.Emp_id = Emp_id;

        print_Writer.append(Emp_Username + "," + Emp_Password
                + "," + Emp_Fname
                + "," + Emp_Lname
                + "," + Emp_nationality
                + "," + Emp_gender
                + "," + Emp_phone
                + "," + Emp_id);

    }
    
    public static void EmpSeachExist(Scanner rs, Scanner file, String UserName, String Password) {

        int lineNum = numOfLines(rs);
        
        String[][] info = new String[lineNum][];

        for (int i = 0; i < info.length; i++) {
            String read = file.nextLine();
            info[i] = read.split(",");
            if (info[i][0].equalsIgnoreCase(UserName)) {
                if (info[i][1].equalsIgnoreCase(Password)) {
                    break;
                } else {
                    System.out.println("Wrong Password ! ");
                }

            }
        }
    }
    
    
    public static int numOfLines(Scanner Sc_read_lines) {
        //_____________________________________________________________________________
        //     Initialize INt variable inceases by the number of lines.
        int lenth = 0;
        //_____________________________________________________________________________
        //                While loop to go through the input file
        while (true) {
            //_____________________________________________________________________________
            //         If statment to chick if the file has next line.
            if (Sc_read_lines.hasNext()) {

                //_____________________________________________________________________________
                //                       Move to the next line.
                String s = Sc_read_lines.nextLine();
                //_____________________________________________________________________________
                //                       Increase the number of lines
                lenth++;
                //_____________________________________________________________________________
                //     Else if the file does not have other line.
            } else {

                //_____________________________________________________________________________
                //    Breake if there are no other lines.
                break;
            }
        }
        //_____________________________________________________________________________
        //                     Return the Number of lines.
        return lenth;
    }
    
    
    public void Login(String Emp_Username, String Emp_Password, Scanner numLines, Scanner raedInfo) throws FileNotFoundException {

        this.Emp_Username = Emp_Username;
        this.Emp_Password = Emp_Password;
        
        EmpSeachExist(numLines, raedInfo, Emp_Username, Emp_Password);

    }

    public int getEmp_id() {
        return Emp_id;
    }

    public void setEmp_id(int Emp_id) {
        this.Emp_id = Emp_id;
    }

    public String getEmp_Username() {
        return Emp_Username;
    }

    public void setEmp_Username(String Emp_Username) {
        this.Emp_Username = Emp_Username;
    }

    public String getEmp_Password() {
        return Emp_Password;
    }

    public void setEmp_Password(String Emp_Password) {
        this.Emp_Password = Emp_Password;
    }

    public String getEmp_Fname() {
        return Emp_Fname;
    }

    public void setEmp_Fname(String Emp_Fname) {
        this.Emp_Fname = Emp_Fname;
    }

    public String getEmp_Lname() {
        return Emp_Lname;
    }

    public void setEmp_Lname(String Emp_Lname) {
        this.Emp_Lname = Emp_Lname;
    }

    public String getEmp_nationality() {
        return Emp_nationality;
    }

    public void setEmp_nationality(String Emp_nationality) {
        this.Emp_nationality = Emp_nationality;
    }

    public char getEmp_gender() {
        return Emp_gender;
    }

    public void setEmp_gender(char Emp_gender) {
        this.Emp_gender = Emp_gender;
    }

    public String getEmp_phone() {
        return Emp_phone;
    }

    public void setEmp_phone(String Emp_phone) {
        this.Emp_phone = Emp_phone;
    }

    @Override
    public String toString() {
        return "Employee Information \n" + "Employee id : " + Emp_id + ", Employee Username : " + Emp_Username + ", Password : " + Emp_Password + ", First name : " + Emp_Fname + ", Last name : " + Emp_Lname + ", Nationality : " + Emp_nationality + ", Gender : " + Emp_gender + ", Phone : " + Emp_phone ;
    }
    
    

}
