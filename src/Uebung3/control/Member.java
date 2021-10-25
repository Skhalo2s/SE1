package Uebung3.control;

import java.io.Serializable;

public interface Member extends Serializable{
    // ID ist über einen Konstruktor einer abgeleiteten Klasse
    // explizit außerhalb der Container-Klasse zu belegen
    // --> Primärschlüssel zur Unterscheidung aller Uebung2.control.Member-Objekte
    Integer getID();

    public String toString();

}
