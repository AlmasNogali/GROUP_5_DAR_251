
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Customer {

    private int Cus_id;
    private String Username;
    private String Password;
    private String Fname;
    private String Lname;
    private String nationality;
    private char gender;
    private String phone;

    public Customer() {

    }

    public Customer(String Username, String Password, String Fname, String Lname, String nationality, char gender,
            String phone, int Cus_id, PrintWriter print_Writer) {

        this.Username = Username;
        this.Password = Password;
        this.Fname = Fname;
        this.Lname = Lname;
        this.nationality = nationality;
        this.gender = gender;
        this.phone = phone;
        this.Cus_id = Cus_id;

        print_Writer.append(Username + "," + Password
                + "," + Fname
                + "," + Lname
                + "," + nationality
                + "," + gender
                + "," + phone
                + "," + Cus_id);

    }

    public boolean addResrvation(Reservation plan) {

        Reservation[] p = new Reservation[plan.getR_permonth()];

        if (plan.getbudget() > 0 || plan.getR_permonth() > 0) { //must enter the budget
            for (int i = 0; i < p.length; i++) {
                p[i] = plan;
                return true;
            }
        }
        return false;

    }

    public int CusSeachExist(Scanner numLines, Scanner raedInfo, String UserName, String Password) {

        int lineNum = numOfLines(numLines);
        int there = 0;
        //int there2 = 0;
        String[][] info = new String[lineNum][];

        for (int i = 0; i < info.length; i++) {
            String read = raedInfo.nextLine();
            info[i] = read.split(",");
            if ((info[i][0]).equalsIgnoreCase(UserName)) {
                if (info[i][1].equalsIgnoreCase(Password)) {
                    there++;
                    break;
                } else {
                    System.out.println("Wrong Password ! ");
                    //there2++;
                    break;
                }

            }else if (raedInfo.hasNext()){
                continue;
            }else{
                System.out.println("There Are no account by : " + UserName + " username");
            }

        }
        
        
        return there;

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

    public int Login(String Username, String Password, Scanner numLines, Scanner raedInfo) throws FileNotFoundException {

        this.Username = Username;
        this.Password = Password;
        int exist = CusSeachExist(numLines, raedInfo, Username, Password);

        return exist;

    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public int getCus_id() {
        return Cus_id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int viewCusReserv(Scanner userFileLine, Scanner UsersInfo) {

        int numOfReserv = 0;
        
        int lineNum = numOfLines(userFileLine);

        String[][] info = new String[lineNum][];

        for (int i = 0; i < info.length; i++) {

            String read = UsersInfo.nextLine();

            info[i] = read.split(",");

            if (((info[i][0]).equals(this.Username)) && ((info[i][1]).equals(this.Password))) {

                System.out.println("******************************************************");
                System.out.printf("\n Username :%s  \n", this.Username);
                System.out.printf(" Password  :%s  \n", this.Password);
                System.out.printf(" First name   :%s  \n", info[i][2].toString());
                System.out.printf(" Last name   :%s  \n", info[i][3].toString());
                System.out.printf(" National number :%s\n", info[i][4].toString());
                System.out.printf(" Gender   :%s  \n", info[i][5].toString());
                System.out.printf(" Phone number   :%s  \n", info[i][6].toString());
                System.out.printf(" Customer ID   :%s  \n", info[i][7].toString());
                System.out.printf(" Plan ID   :%s  \n", info[i][8].toString());
                System.out.printf(" Destination   :%s  \n", info[i][9].toString());
                System.out.printf(" Budget   :%s  \n", info[i][10].toString());
                System.out.printf(" Airlane   :%s  \n\n", info[i][11].toString());
                System.out.println("******************************************************");

                numOfReserv++;
            }
        }

        return numOfReserv;
    }

    //(sc, Writer_cus_info, ran,u_name, Pword, Fname, Lname,nationality, gen, phone);
    public void SignUp(Scanner readUser, Scanner gg, Scanner sc, PrintWriter print_Writer, int ran,
            String u_name, String Pword, String Fname,
            String Lname, String nationality, char gender, String phone) {

        //this(u_name, Pword, Fname, Lname, nationality, gender, phone, ran, print_Writer);
        while (true) {

            boolean val = userNSearch(sc, gg, u_name);

            if (val == true) {

                break;

            } else {

                System.out.println("Please another username enter username :");

                u_name = sc.next();

                continue;
            }
        }

        print_Writer.append(u_name + "," + Pword
                + "," + Fname
                + "," + Lname
                + "," + nationality
                + "," + gender
                + "," + phone
                + "," + ran);

    }

    public static boolean userNSearch(Scanner rs, Scanner file, String UserAtribute) {

        int lineNum = numOfLines(rs);

        String[][] info = new String[lineNum][];

        for (int i = 0; i < info.length; i++) {
            String read = file.nextLine();
            info[i] = read.split(",");
            if (info[i][0].equalsIgnoreCase(UserAtribute)) {
                return false;
            }

        }

        return true;

    }

    @Override
    public String toString() {
        return "\nCutomer ID :" + Cus_id + "\nCustomer Name :" + " " + this.Fname + this.Lname + "\nCutomer nationality :" + this.nationality
                + "Customer gender :" + this.gender + "Customer phone :" + this.phone;
    }
}
