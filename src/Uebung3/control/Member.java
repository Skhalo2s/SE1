package Uebung3.control;

import java.io.Serializable;
/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

public interface Member extends Serializable{
    // ID ist über einen Konstruktor einer abgeleiteten Klasse
    // explizit außerhalb der Container-Klasse zu belegen
    // --> Primärschlüssel zur Unterscheidung aller Uebung2.control.Member-Objekte
    Integer getID();

    public String toString();

}
