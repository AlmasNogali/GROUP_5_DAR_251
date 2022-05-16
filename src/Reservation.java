
import static java.awt.SystemColor.info;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Reservation {

    private int plan_id;
    private String place;
    private int budget;
    private String airline;
    ArrayList< String> ranMum = new ArrayList< String>();

    
    public Reservation(){
        
    }
    public Reservation(int id, String place, int budget, String airline, PrintWriter PrinWrite) {

        this.plan_id = id;
        this.place = place;
        this.budget = budget;
        this.airline = airline;
        
        PrinWrite.append(id + "," + place
                + "," + budget
                + "," + airline );

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

    public void PrintReservations(String resrvInfo) {

        Scanner Lines = new Scanner(resrvInfo);
        
        int lineNum = numOfLines(Lines);

        Scanner readFromFile = new Scanner(resrvInfo);

        String[][] info = new String[lineNum][];

        for (int i = 0; i < info.length; i++) {

            String read = readFromFile.nextLine();

            info[i] = read.split(",");

            System.out.println("" + info[i][0]);
            System.out.println("" + info[i][1]);
            System.out.println("" + info[i][2]);
            System.out.println("" + info[i][3]);

        }
    }

    public String searchReservations(String resrvInfo, String planID) {

        Scanner Lines = new Scanner(resrvInfo);
        
        int lineNum = numOfLines(Lines);

        Scanner readFromFile = new Scanner(resrvInfo);

        String[][] info = new String[lineNum][];

        String desirPlan = "";
        
        for (int i = 0; i < info.length; i++) {

            String read = readFromFile.nextLine();

            info[i] = read.split(",");
            
            if (info[i][0].equals(planID)){
                
                desirPlan = info[i][0] + ","+ info[i][1] + ","+info[i][2] + ","+info[i][3] ;
            }

        }
        return desirPlan;
    }


    public int getplan_id() {

        return plan_id;
    }

    public String getplace() {

        return place;
    }

    public int getbudget() {

        return budget;
    }

    public String getbairline() {

        return airline;
    }

    public void setplan_id(int plan_id) {
        this.plan_id = plan_id;

    }

    public void setplace(String place) {
        this.place = place;

    }

    public void setbudget(int budget) {
        this.budget = budget;

    }

    public void setairline(String airline) {
        this.airline = airline;

    }

    @Override
        public String toString() {
        return "\n---------------------------\nPlan ID :" + plan_id + "\nPlan place :" + place + "\nPlan budget :" + budget
                + "\nPlane airline:" + airline;
    }

}
