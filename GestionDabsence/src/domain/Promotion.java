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
public class Promotion {
    private int idpromotion;
    private String nompromotion;
    private String annéepromotion;
    private int formateur;

    public Promotion(int idpromotion, String nompromotion, String annéepromotion, int formateur) {
        this.idpromotion = idpromotion;
        this.nompromotion = nompromotion;
        this.annéepromotion = annéepromotion;
        this.formateur = formateur;
    }
    public Promotion(){
        super();
    }

    public int getIdpromotion() {
        return idpromotion;
    }

    public String getNompromotion() {
        return nompromotion;
    }

    public String getAnnéepromotion() {
        return annéepromotion;
    }

    public int getFormateur() {
        return formateur;
    }

    public void setIdpromotion(int idpromotion) {
        this.idpromotion = idpromotion;
    }

    public void setNompromotion(String nompromotion) {
        this.nompromotion = nompromotion;
    }

    public void setAnnéepromotion(String annéepromotion) {
        this.annéepromotion = annéepromotion;
    }

    public void setFormateur(int formateur) {
        this.formateur = formateur;
    }
    
    
}
