package Uebung4.control;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

public class EingabeConsole {
    private BufferedReader inpot = null;


    public EingabeConsole(){
        inpot = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readeStringLine(String ausgabeText){
        String sInput = null;

        System.out.print(ausgabeText);

        try {
            sInput = inpot.readLine();

            for (int i = 0; i < 10; i++) {// keine Zahlen im String vorhanden
               if( sInput.contains(i+"")){
                   System.out.println("Bitte geben Sie keine Zahlen ein");
                   sInput = this.readeStringLine(ausgabeText);
               }
            }

        }
        catch (IOException e) {
            System.out.println("Bei der eingabe von Daten ist ein Problem Aufgetreten");
            e.printStackTrace();
        }

        return sInput;
    }
    public String readeJaNein(String ausgabeText){

        String sInput = this.readeStringLine(ausgabeText);

      if (!(sInput.equalsIgnoreCase("Ja") || sInput.equalsIgnoreCase("Nein"))){
          sInput = this.readeJaNein("Fehler bei der eingabe!\nBitte geben Sie nur 'Ja' oder 'Nein' ein: ");
      }
      return sInput;
    }

    public int readeIntLine(String ausgabeText){
        String sInput = null;
        int id = 0;

        System.out.print(ausgabeText);

        try {
            sInput = inpot.readLine();
            try {
                id = Integer.valueOf(sInput);
            }
            catch (java.lang.NumberFormatException e){
                System.out.println("\nDas ist leider keine Zahl!");
                return this.readeIntLine(ausgabeText);
            }

            while (id < 0){
                System.out.println("\nBitte nur positive Zhalen eingeben!");
                id = readeIntLine(ausgabeText);
            }
            if(Container.getInstance().contain(id) && ausgabeText.equalsIgnoreCase("Bitte geben Sie die ID des Mitarbeiters ein: ")){
                System.out.println("\nDie ID "+ id +" ist bereits enthalten versuchen Sie nochmal!");
                id = readeIntLine(ausgabeText);
            }/*else {
                while (id>3||id<1){
                    System.out.println("\nLevel soll 1,2 oder 3 sein!");
                    id = readeIntLine(ausgabeText);
                }
            }*/
        }
        catch (IOException e) {
            System.out.println("Bei der eingabe von ID ist ein Problem aufgetreten");
            e.printStackTrace();
        }



        return id;
    }

    void flacheEingabe(){
        System.out.println("Falsche Eingabe! " +
                "\nDieses Befehl existiert leider nicht :(\n" +
                "Versuchen Sie es erneut!\n");
    }



}
