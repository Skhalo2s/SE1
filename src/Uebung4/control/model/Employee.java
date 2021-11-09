package Uebung4.control.model;

import java.io.Serializable;

/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

public class Employee implements Serializable {

    private String nachname = null;
    private String vorname= null;
    private String rolle= null;
    private String abteilung= null;
    private Expertise myExpertisen =  null;
    private Integer id;





    public Employee(int id,String vorname, String nachname,   String rolle, String abteilung,Expertise newExpertisen) {
        this.id = id;
        this.nachname = nachname;
        this.vorname = vorname;
        this.rolle = rolle;
        this.abteilung = abteilung;
        this.myExpertisen = newExpertisen;
    }

    public Employee(int id,  String vorname,String nachname,  String rolle, String abteilung ) {
        this(id,vorname,nachname,   rolle, abteilung,null);
    }

    public Employee(int id, String vorname,String nachname,  String rolle) {
        this(id, vorname,nachname,  rolle, null,null);
    }

    public Expertise getExpertisen() {
            return myExpertisen;
    }

    public void Expertisen(Expertise expertise){
        myExpertisen = expertise;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    //ToDo
    @Override
    public String toString() {
        return "Employee{" +
                "nachname='" + nachname + '\'' +
                ", vorname='" + vorname + '\'' +
                ", rolle='" + rolle + '\'' +
                ", abteilung='" + abteilung + '\'' +
                ", expertisen=" + // ToDo
                ", id=" + id +
                '}';
    }
}
