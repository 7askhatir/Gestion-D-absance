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
public class Retar {
    private int idretar;
    private int duréretar;
    private int idformateur;
    private int idapprenant;
    private String jusif;

    public Retar(int idretar, int duréretar, int idformateur, int idapprenant, String jusif) {
        this.idretar = idretar;
        this.duréretar = duréretar;
        this.idformateur = idformateur;
        this.idapprenant = idapprenant;
        this.jusif = jusif;
    }

    public String getJusif() {
        return jusif;
    }

    public void setJusif(String jusif) {
        this.jusif = jusif;
    }

    
    public Retar(){
        super();
    }

    public int getIdretar() {
        return idretar;
    }

    public int getDuréretar() {
        return duréretar;
    }

    public int getIdformateur() {
        return idformateur;
    }

    public int getIdapprenant() {
        return idapprenant;
    }

    public void setIdretar(int idretar) {
        this.idretar = idretar;
    }

    public void setDuréretar(int duréretar) {
        this.duréretar = duréretar;
    }

    public void setIdformateur(int idformateur) {
        this.idformateur = idformateur;
    }

    public void setIdapprenant(int idapprenant) {
        this.idapprenant = idapprenant;
    }
    
    
    
}
