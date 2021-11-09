package Uebung4.control;

import Uebung4.control.exceptions.ContainerException;
import Uebung4.control.exceptions.PersistenceException;
import Uebung4.control.exceptions.WrongInputException;
import Uebung4.control.model.Employee;
import Uebung4.control.model.Expertise;
import Uebung4.view.EmployeeView;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

public class Eingabedialog {


    String[] stringsInput;

    public void starteEingabe(Scanner input) {
        //BufferedReader input = new BufferedReader( new InputStreamReader(System.in ));


        EmployeeView ausgabe = new EmployeeView();
        EingabeConsole console = new EingabeConsole();

        System.out.println("\uD83D\uDCC3SP-Tool\uD83D\uDCC3 ⚫V1.0");
        System.out.println("©️ Salah Khalosi\n");
        System.out.println("Guten Tag \uD83D\uDE4B \nUm die verfuegbaren Befehle zu sehen, geben Sie bitte das Wort 'help' ein.");



        while (true){



                System.out.print("\nGeben Sie ein Befehl ein\n> ");


                stringsInput = input.nextLine().split(" ");


                /*System.out.println("Ein Problem beim lesen ist Aufgetereten!\n");*/



            try {

             // help
             if (stringsInput[0].equals("help")){
                System.out.println("Folgende Befehle stehen zur Verfuegung:\n" +

                                    "       ⬛ enter: Eingabe eines Mitarbeiters.\n" +
                                    "               \uD83D\uDD38 Um einen neuen Mitarbeiter einzugeben, geben Sie bitte  'enter Mitarbeiter' ein.\n" +

                                    "       ⬛ store: Abspeichern aller Mitarbeitern in einem Ordner auf das Pc.\n" +
                                    "               \uD83D\uDD38 Um alle Mitarbeitern auf das Pc abzuspeischeren, geben Sie bitte das Wort 'store' ein.\n" +

                                    "       ⬛ load: lade aller abgespeicherten Mitarbeiter auf der Datenträger.\n" +
                                    "               \uD83D\uDD38 Um die vorhandene Mitarbeiter-Liste mit der abgespeicherte liste zu vereinegen, geben Sie bitte 'load merge' ein.\n" +
                                    "               \uD83D\uDD38 Um die vorhandene Mitarbeiter-Liste zu überschreiben, geben Sie bitte 'load force' ein.\n" +

                                    "       ⬛ dump: Liste ausdruecken.\n" +
                                    "               \uD83D\uDD38 Um die Liste auszudruecken, geben Sie bitte 'dump' ein.\n" +
                                    "               \uD83D\uDD38 Um die Liste mit bestimter Abteilung auszudruecken, geben Sie bitte 'dump Abteilung /X/\uD83D\uDCDD' ein.\n" +

                                    "       ⬛ search: mit dieser Befehl können Sie nach bestimmte Sachen suchen\n" +
                                    "               \uD83D\uDD38 Um bestimter Expertiseen zu finden, geben Sie bitte 'search  Expertise /X/\uD83D\uDCDD' ein.\n" +
                                    "               \uD83D\uDD38 Um bestimter Abteilungen zu finden, geben Sie bitte 'search  Abteilung /X/\uD83D\uDCDD' ein.\n" +


                                    "       ⬛ exit: Verlassen der Anwendung.\n"+
                                    "               \uD83D\uDD38 Um die Anwendung zu verlssen, geben Sie bitte 'exit' ein.\n" +

                                    "       ⬛ help: zeiget aller verfuegbaren Befehle.\n"+
                                    "               \uD83D\uDD38 Um die verfuegbaren Befehle zu sehen, geben Sie bitte 'help' ein.\n"
                                    );
            }//help Ende


             // enter
            else if (stringsInput[0].equalsIgnoreCase("enter") ){

                try {
                 if (stringsInput.length == 1) {

                    System.out.println("Geben sie die Grunddaten der Mitarbeiter ein.");

                    String nachname = console.readeStringLine("Bitte geben Sie der Nachname des Mitarbeiters ein: ");
                    String vorname = console.readeStringLine("Bitte geben Sie der Vorname des Mitarbeiters ein: ");
                    int id = console.readeIntLine("Bitte geben Sie die ID des Mitarbeiters ein: ");
                    String rolle = console.readeStringLine("Bitte geben Sie die Rolle des Mitarbeiters ein: ");

                    // abteilung gewünscht?
                    String abteilung = null;
                    String jaNein = console.readeJaNein("\nWenn Sie ein Abteilung eingeben wollen, gebebn Sie Bitte das Wort 'Ja'."
                            +" Falls Sie keine  Abteilung eingeben wollen, gebebn Sie Bitte das Wort 'Nein': ");

                    // abteilung einfügen
                    if (jaNein.equalsIgnoreCase("Ja")){
                        abteilung= console.readeStringLine("\nBitte geben Sie der Abteilung des Mitarbeiters ein: ");
                                                                            //" (falls der Mitarbeiter keiner Abteilung zugeordnet geben sie bitte 'Keine Abteiling': "
                    }

                    if(abteilung == null){
                        abteilung = "Ist Keine Abteilung zugerotnet";
                    }

                    Employee newEmployee = new Employee(id,vorname,nachname,  rolle, abteilung, new Expertise());// Mitrbeiter erzeugen

                    String expertise = null;
                    int expertiseLev = 0; // expertise Level

                    // Expertise gewünscht?
                    jaNein = console.readeJaNein("\nJeder Mitarbeiter kann über Maximal 3 Expertise verfuegen.\nBitte geben Sie 'Ja' falls Sie Expertisen" +
                            "eingeben wollen bzw. 'Nein' falls Sie keine Expertisen eingeben wollen: ");

                    // füge Expertise bei Wünsch ein
                    for (int i = 0; jaNein.equalsIgnoreCase("Ja") && i <3;i++){
                        expertise = console.readeStringLine("\nBitte geben Sie die " + Integer.toString(i+1) + ". Expertise der Mitarbeiter ein: ");
                        expertiseLev = console.readeIntLine("Bitte geben Sie für die " +Integer.toString(i+1) + ". Expertise ein Expertise-Level " +
                                "(1 für  Beginner, 2 für Experte oder 3 für Top-Performer): ");
                        try {
                             while (expertiseLev < 1 || expertiseLev > 3){// expertise Level soll 1,2 oder 3 sein
                                expertiseLev = console.readeIntLine("\nFalsche Eingabe!\nBitte geben Sie für die " + i+1. + " Expertise nochmal ein Expertise-Level" +
                                        " (1 für  Beginner, 2 für Expertise oder 3 für Top-Performer): ");
                            }
                            newEmployee.getExpertisen().setNewExpertise(expertise,expertiseLev);

                            // Expertise noch gewünscht ?
                            jaNein = console.readeJaNein("\nFalls Sie noch weiter Expertisen eingeben wollen, gebebn Sie Bitte das Wort 'Ja' ein."
                                    +"\nFalls Sie keine Expertisen mehr eingeben wollen, gebebn Sie Bitte das Wort 'Nein': ");

                        } catch (WrongInputException e) {
                            System.out.println(e.getMessage());
                        }
                    }//Expertise_Add Ende

                    try {// füge Mitrbeiter in der Liste ein
                        Container.getInstance().addEmployee(newEmployee );
                        System.out.println("\nMitarbeiter worde erfolgreich hinzugefuegt ✅.");
                    }
                    catch (ContainerException e) {
                     System.out.println("\nFehler beim Abspeichern der Mitarbeiter!");
                    }
                }
                 else {
                     console.flacheEingabe();
                 }
                }catch (ArrayIndexOutOfBoundsException e){
                    console.flacheEingabe();
                    continue;
                }

            }// enter Ende

            //store
            else if (stringsInput[0].equalsIgnoreCase("store")){
                Container.getInstance().setPersistenceStrategie(new PersistenceStrategyStream<Employee>());

                try {
                    Container.getInstance().store();
                    System.out.println("\nListe worde auf dem PC erfolgreich gespeichert ✅.");
                } catch (PersistenceException e) {
                    System.out.println("\nListe konnte nich gespeischer werden. Versuchen Sie bitte nochmal!");
                } catch (FileNotFoundException e) {
                    System.out.println("\nFile nicht gefonden!");
                }
            }// store Ende

            //load
            else if (stringsInput[0].equalsIgnoreCase("load")){
                Container.getInstance().setPersistenceStrategie(new PersistenceStrategyStream<Employee>());

                 if (stringsInput[1].equalsIgnoreCase("force")){
                    try {
                        Container.getInstance().loadForce();
                        System.out.println("Liste wurde erflogreich von PC geladen und die vorhandene Liste wurde überschrieben ✅.");
                    } catch (PersistenceException e) {
                        System.out.println("\nFehler beim Laden bei der Überschreibung der Liste!");
                    }
                }
                else if (stringsInput[1].equalsIgnoreCase("merge")){
                    try {
                        /*System.out.println("ACHTUNG‼️ Mitarbeiter mit dem sleben ID werden nicht hinzugefuegt! ");
                        String jaNein = console.readeJaNein("wollen Sie fortsetzen (JA/Nein)? ");
                        if (jaNein.equalsIgnoreCase("ja")){


                        }*/

                        Container.getInstance().loadMerge();
                        System.out.println("\nListe wurde erflogreich von PC geladen und mit der alte Liste vereinigt ✅.");

                        /*else {
                            System.out.println("\nListe wurde von PC nicht geladen.");
                        }*/

                    } catch (PersistenceException e) {
                        System.out.println("\nFehler beim Laden bei der Vereinigung der Listen!");
                    }
                }
                else {
                    console.flacheEingabe();
                }
            }// load Ende

            // dump
            else if (stringsInput[0].equalsIgnoreCase("dump")){
                try {
                    if (Container.getInstance().size() < 1) {
                        System.out.println("Es wurden bisher keine Mitarbeiter eingetragen!");
                    }
                    else if (stringsInput.length == 1){// einfache eingabe
                    System.out.println(ausgabe.damp());
                    }
                    else if (stringsInput[1].equalsIgnoreCase("abteilung")){
                        System.out.println(ausgabe.dampAbteilungX(stringsInput[2]));
                    }
                    else {
                        console.flacheEingabe();
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    console.flacheEingabe();
                }
            }// dump Ende

           //search
            else if (stringsInput[0].equalsIgnoreCase("search")){ //Expertise als Suchwort möchte ich eine einfache Übersicht

                try {

                if (Container.getInstance().size() == 0) {
                    System.out.println("Es wurden bisher keine Mitarbeiter eingetragen!");
                }
                else if (stringsInput[1].equalsIgnoreCase("Expertise")){//(Suche nach Expertisen; Suchwort wird dabei als Parameter
                    System.out.println(ausgabe.dampExpertiseX(stringsInput[2])); //übergeben; Ausgabe der Mitarbeiter erfolgt in einer einfachen Übersicht)
                }
                else if (stringsInput[1].equalsIgnoreCase("abteilung")){
                    System.out.println(ausgabe.dampAbteilungX(stringsInput[2]));
                }
                else {
                    console.flacheEingabe();
                }
                }catch (ArrayIndexOutOfBoundsException e){
                    console.flacheEingabe();
                }

            }//search Ende


            else if (stringsInput[0].equalsIgnoreCase("exit")){
                 System.out.println("Goodbye \uD83D\uDC4B☺.");
                break;
             }

            else {
              console.flacheEingabe();
            }
            }catch (ArrayIndexOutOfBoundsException e){
                console.flacheEingabe();
            }
        }
    }

    public void starteEingabe(){
        this.starteEingabe(new Scanner(System.in));
    }
}
