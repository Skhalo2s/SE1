package Uebung2.control;

public interface Member {
    // ID ist über einen Konstruktor einer abgeleiteten Klasse
    // explizit außerhalb der Container-Klasse zu belegen
    // --> Primärschlüssel zur Unterscheidung aller Uebung2.control.Member-Objekte
    Integer getID();

    public String toString();
}
