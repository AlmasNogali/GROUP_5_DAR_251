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

   
    public Reservation(int id, String place, int budget, String airline) {

        this.plan_id = id;
        this.place = place;
        this.budget = budget;
        this.airline = airline;

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
        return "\nPlan ID :" + plan_id + "\nPlan place :" + place + "\nPlan budget :" + budget
                + "\nPlane airline:" + airline;
    }

}

