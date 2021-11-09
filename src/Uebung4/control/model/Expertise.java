package Uebung4.control.model;

import Uebung4.control.exceptions.WrongInputException;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

public class Expertise implements Serializable{


    private HashMap<String,Integer> expertisenListe = null;
    private int expertisenMax = 3;

    public Expertise() {
        expertisenListe = new HashMap<>();
    }

    public void setNewExpertise(String expertiseBezeichnung, int expertiseLevel) throws WrongInputException {
        if (expertiseLevel >3 || expertiseLevel <1)
            throw new WrongInputException("Expertise-Level soll 1, 2 oder 3 sein");

        if (expertisenListe.size()+1 > expertisenMax)
            throw new WrongInputException("Sie haben das Expertisen-Max erreicht.");

        expertisenListe.put(expertiseBezeichnung,expertiseLevel);
    }

    public int getExpertisenMax() {
        return expertisenMax;
    }

    public void setExpertisenMax(int expertisenMax) {
        this.expertisenMax = expertisenMax;
    }
    public int getExpertisenSize() {
        return expertisenListe.size();
    }

    public Integer getExpertiseBezeichnung(String expertiseBezeichnung ) {
        return expertisenListe.get(expertiseBezeichnung);
    }


    public void expertiseIfo(){
        System.out.println("Jede Expertise hat ein Expertise-Level, das zwichen 1und 3 liegt.\n1: Beginner\n2: Experte\n3: Top-Performer");
    }

    public void updateExpertiseLev(String expertiseBezeichnung, int expertiseLev) throws WrongInputException{
    if (expertiseLev < 1 || expertiseLev >3)
            throw new WrongInputException("Expertise-Level soll 1, 2 oder 3 sein");

    }

    public boolean containsBezeichnung(String expertiseBezeichnung ) {
        return  expertisenListe.containsKey(expertiseBezeichnung);
    }
    public  HashMap<String,Integer> getExpertisenListe(){
        return  expertisenListe;
    }

    // ToDo format
    public String getExpertisen() {
        StringBuilder myString = new StringBuilder("Expertise\tLevel\n───────────────┬─────────────\n");

        expertisenListe.forEach((expertise ,expertiseLeve)->  myString.append( expertise+ "\t│"+expertiseLeve+"\n"));

        return myString.toString();
    }




}
