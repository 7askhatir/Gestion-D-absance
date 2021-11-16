/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Admin
 */
public class Absences {
    private int idabsence;
    private int idformateur;
    private int idapprenant;
    private String typeabs;
    private String dateabs;

    public Absences(int idabsence, int idformateur, int idapprenant, String typeabs, String dateabs) {
        this.idabsence = idabsence;
        this.idformateur = idformateur;
        this.idapprenant = idapprenant;
        this.typeabs = typeabs;
        this.dateabs = dateabs;
    }
    public Absences(){
        super();
    }

    public void setIdabsence(int idabsence) {
        this.idabsence = idabsence;
    }

    public void setIdformateur(int idformateur) {
        this.idformateur = idformateur;
    }

    public void setIdapprenant(int idapprenant) {
        this.idapprenant = idapprenant;
    }

    public void setTypeabs(String typeabs) {
        this.typeabs = typeabs;
    }

    public void setDateabs(String dateabs) {
        this.dateabs = dateabs;
    }

    public int getIdabsence() {
        return idabsence;
    }

    public int getIdformateur() {
        return idformateur;
    }

    public int getIdapprenant() {
        return idapprenant;
    }

    public String getTypeabs() {
        return typeabs;
    }

    public String getDateabs() {
        return dateabs;
    }
    
}
