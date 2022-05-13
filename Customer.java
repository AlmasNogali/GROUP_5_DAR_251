/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.PrintWriter;

public class Customer   {

    private int Cus_id;
    private String Username;
    private String Password;
    private String Fname;
    private String Lname;
    private String nationality;
    private char gender;
    private int phone;

    public Customer() {

    }

    public Customer(String Username, String Password, String Fname, String Lname, String nationality, char gender,
            int phone, int Cus_id, PrintWriter print_Writer) {

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

    public void addResrvation() {
     

//       
        
        
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

// @Override
//    public String toString() {
//        return "\nCutomer ID :" + Cus_id + "\nCustomer Name :" +" "+ this.Fname+this.Lname  + "\nCutomer nationality :" + this.nationality +
//                "Customer gender :" + this.gender + "Customer phone :" + this.phone;
//    }
}


