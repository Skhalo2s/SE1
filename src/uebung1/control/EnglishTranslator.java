package uebung1.control;

/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

public class EnglishTranslator implements Translator {
    public String date = "Okt/2021"; // Default-Wert

    /**
     * Methode zur Übersetzung einer Zahl in eine String-Repraesentation.
     */
    public String translateNumber( int number ) {

        String[] eNumbers= {"one","two","three","four","five","six","seven", "eight", "nine", "ten"};

        try {
            return eNumbers[number-1];
        }
        catch (Exception e){
            //Möglichkeit 1
            //return "Übersetzung der Zahl " + number + " nicht möglich! (V " + Translator.version + ")";

            //Möglichkeit 2
            throw new IllegalArgumentException("Übersetzung der Zahl " + number + " nicht möglich! (V " + Translator.version + ")");
        }
    }

    /**
     * Objektmethode der Klasse EnglishTranslator zur Ausgabe einer Info.
     */
    public void printInfo(){
        System.out.println( "EnglishTranslator v1.9, erzeugt am " + this.date );
    }

    /**
     * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: Okt/2021))
     * Das Datum sollte system-intern gesetzt werden und nicht von externen View-Klassen
     */
    public void setDate( String date ) {
        this.date = date;
    }

}
