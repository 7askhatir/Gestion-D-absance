/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javafx.scene.control.Button;

/**
 *
 * @author Admin
 */
public class TableAbsent {
    private int id;
    private String NS,NA,date;
    private Button yes ,non;

    public TableAbsent(int id, String NS, String NA, String date, Button yes, Button non) {
        this.id = id;
        this.NS = NS;
        this.NA = NA;
        this.date = date;
        this.yes = yes;
        this.non = non;
    }
    public void onclick(int id){
        id=this.id;
     
    }

    public TableAbsent() {
        super();
    }

    public int getId() {
        return id;
    }

    public String getNS() {
        return NS;
    }

    public String getNA() {
        return NA;
    }

    public String getDate() {
        return date;
    }

    public Button getYes() {
        return yes;
    }

    public Button getNon() {
        return non;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNS(String NS) {
        this.NS = NS;
    }

    public void setNA(String NA) {
        this.NA = NA;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setYes(Button yes) {
        this.yes = yes;
    }

    public void setNon(Button non) {
        this.non = non;
    }
    public void click(int id ,Button b1){
        if(b1==this.getYes()){
            
        }
    }
    

   
    
}
