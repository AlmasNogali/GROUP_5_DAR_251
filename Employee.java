/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.PrintWriter;
import java.util.ArrayList;

public class Employee {

    private int Emp_id;
    private String Emp_Username;
    private String Emp_Password;
    private String Emp_Fname;
    private String Emp_Lname;
    private String Emp_nationality;
    private char Emp_gender;
    private long Emp_phone;

    public Employee() {
    }

    public Employee(String Emp_Username, String Emp_Password, String Emp_Fname, String Emp_Lname, String Emp_nationality,
             char Emp_gender, long Emp_phone, int Emp_id, PrintWriter print_Writer) {

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

    public long getEmp_phone() {
        return Emp_phone;
    }

    public void setEmp_phone(long Emp_phone) {
        this.Emp_phone = Emp_phone;
    }

}


