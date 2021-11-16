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
public class Staf {
    private int iduser;
    private String nomuser;
    private String emailuser;
    private String passuser;
    private String typeuser;

    public Staf(int iduser, String nomuser, String emailuser, String passuser, String typeuser) {
        this.iduser = iduser;
        this.nomuser = nomuser;
        this.emailuser = emailuser;
        this.passuser = passuser;
        this.typeuser = typeuser;
    }

    public Staf(){
        super();
    }

    public Staf(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIduser() {
        return iduser;
    }

    public void setTypeuser(String typeuser) {
        this.typeuser = typeuser;
    }

    public String getTypeuser() {
        return typeuser;
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
    
    
}
