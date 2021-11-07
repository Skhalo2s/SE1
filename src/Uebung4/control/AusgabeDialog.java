package Uebung4.control;

import java.util.List;
/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

public class AusgabeDialog {
    List<Employee> myListe = null;

    public AusgabeDialog( ){
        this.myListe = Container.getInstance().getCurrentList();


    }



    public String damp(){
        StringBuilder myBuilder = new StringBuilder(
                "┌──────────────────────────────────────────────────────────────────────Employees-List──────────────────────────────────────────────────────────────────────┐\n"+

                "├──────────────────────────────┬──────────────────────────────┬──────────────────────────────┬──────────────────────────────┬──────────────────────────────┤\n"+

                String.format("│%-30s│%-30s│%-30s│%-30s│%-30s│%n%s%n","ID", "Vorname", "Nachname", "Rolle", "Abteilung",
                "├──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┤"));


        myListe.stream().sorted((employee1,employee2)-> Integer.compare(employee1.getID(),employee2.getID()))
                .forEach( employee -> myBuilder.append(String.format("│%-30s│%-30s│%-30s│%-30s│%-30s│%n%s%n",employee.getID(),employee.getVorname(),employee.getNachname(),employee.getRolle(), employee.getAbteilung(),
                        "├──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┤") ));
        myBuilder.append("└──────────────────────────────┴──────────────────────────────┴──────────────────────────────┴──────────────────────────────┴──────────────────────────────┘");
        return myBuilder.toString();
    }

    // damp Abteilung X
    public String dampAbteilungX(String abteilungX){
        if (!containsX("Abteilung",abteilungX)){
            return"Die Abteilung "+abteilungX+" ist nicht vorhanden!\nVersuchen Sie es nochmal.";
        }
        StringBuilder myBuilder = new StringBuilder(
                "┌──────────────────────────────────────────────────────────────────────Employees-List──────────────────────────────────────────────────────────────────────┐\n"+

                "├──────────────────────────────┬──────────────────────────────┬──────────────────────────────┬──────────────────────────────┬──────────────────────────────┤\n"+

                String.format("|%-30s|%-30s|%-30s|%-30s|%-30s|%n%s%n","ID", "Vorname", "Nachname", "Rolle", "Abteilung",
                        "├──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┤"));


        myListe.stream()
                .sorted((employee1,employee2)-> Integer.compare(employee1.getID(),employee2.getID()))
                .filter(employee -> employee.getAbteilung().equalsIgnoreCase(abteilungX))
                .forEach( employee -> myBuilder.append(String.format("│%-30s│%-30s│%-30s│%-30s│%-30s│%n%s%n",employee.getID(),employee.getVorname(),employee.getNachname(),employee.getRolle(), employee.getAbteilung(),
                        "├──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┤") ));
        myBuilder.append("└──────────────────────────────┴──────────────────────────────┴──────────────────────────────┴──────────────────────────────┴──────────────────────────────┘");
        return myBuilder.toString();
    }


    // damp Expertise X
    public String dampExpertiseX(String expertiseX){
        if (!containsX("Expertise",expertiseX)){
            return"Die  Expertise "+expertiseX+" ist nicht vorhanden!\nVersuchen Sie es nochmal.";
        }

        StringBuilder myBuilder = new StringBuilder(String.format("%S%n%S%n│%-30S│%-30S│%-30S│%-30S│%-30S│%-30S│%-30S│%n%s%n",
                "┌─────────────────────────────────────────────────────────────────────────────────────────────────────Employees-List─────────────────────────────────────────────────────────────────────────────────────────────────────┐",

                "├──────────────────────────────┬──────────────────────────────┬──────────────────────────────┬──────────────────────────────┬──────────────────────────────┬──────────────────────────────┬──────────────────────────────┤",

                "ID", "Vorname", "Nachname", "Rolle", "Abteilung","Expertise","Expertise-Level",
                "├──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┤"));


        myListe.stream().filter(employee -> employee.getExpertisen().containsBezeichnung(expertiseX))
                .sorted((employee1,employee2)-> Integer.compare(employee1.getID(),employee2.getID()))
                .forEach( employee -> myBuilder.append(String.format("│%-30s│%-30s│%-30s│%-30s│%-30s│%-30s│%-30s│%n%s%n",employee.getID(),employee.getVorname(),employee.getNachname(),employee.getRolle(), employee.getAbteilung(),
                        expertiseX.toLowerCase().replace(expertiseX.charAt(0),Character.toUpperCase(expertiseX.charAt(0))),employee.getExpertisen().getExpertiseBezeichnung(expertiseX),
                        "├──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┤") ));
        myBuilder.append("└──────────────────────────────┴──────────────────────────────┴──────────────────────────────┴──────────────────────────────┴──────────────────────────────┴──────────────────────────────┴──────────────────────────────┘");

        return myBuilder.toString();
    }




    private boolean containsX(String suchBereich, String SuchBeg){
        boolean ret = false;
        if ("Abteilung".equalsIgnoreCase(suchBereich)){
            for (Employee employee: myListe) {
                if (employee.getAbteilung().equalsIgnoreCase(SuchBeg))
                    ret = true;
            }
        }
        if ("Vorname".equalsIgnoreCase(suchBereich)){
            for (Employee employee: myListe) {
                if (employee.getVorname().equalsIgnoreCase(SuchBeg))
                    ret = true;
            }
        }
        if ("Nachname".equalsIgnoreCase(suchBereich)){
            for (Employee employee: myListe) {
                if (employee.getNachname().equalsIgnoreCase(SuchBeg))
                    ret = true;
            }
        }

        if ("Rolle".equalsIgnoreCase(suchBereich)){
            for (Employee employee: myListe) {
                if (employee.getRolle().equalsIgnoreCase(SuchBeg))
                    ret = true;
            }
        }

        if ("ID".equalsIgnoreCase(suchBereich)){
            for (Employee employee: myListe) {
                if (employee.getID().equals(SuchBeg))
                    ret = true;
            }
        }

        if ("Expertise".equalsIgnoreCase(suchBereich)){
            for (Employee employee: myListe) {
                    ret = employee.getExpertisen().containsBezeichnung(SuchBeg);
                    if (ret) break;
            }
        }
        return ret;
    }


}
