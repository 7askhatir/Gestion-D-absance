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
public class Apprenant {
    private int iduser;
    private String nomuser;
    private String emailuser;
    private String passuser;
    private int promotion;

    public Apprenant(int iduser, String nomuser, String emailuser, String passuser, int promotion) {
        this.iduser = iduser;
        this.nomuser = nomuser;
        this.emailuser = emailuser;
        this.passuser = passuser;
        this.promotion = promotion;
    }
    public Apprenant(){
        super();
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }

    public void setEmailuser(String emailuser) {
        this.emailuser = emailuser;
    }

    public void setPassuser(String passuser) {
        this.passuser = passuser;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public int getIduser() {
        return iduser;
    }

    public String getNomuser() {
        return nomuser;
    }

    public String getEmailuser() {
        return emailuser;
    }

    public String getPassuser() {
        return passuser;
    }

    public int getPromotion() {
        return promotion;
    }
    
}
