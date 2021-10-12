package uebung1.control;

/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */


public class GermanTranslator implements Translator {

	public String date = "Okt/2021"; // Default-Wert

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation.
	 */
	public String translateNumber( int number ) {

		String[] gNumbers= {"Eins","Zwei","Drei","Vier","Fünf","Sechs","Sieben", "Acht", "Neuen", "Zehn"};

		try {
			return gNumbers[number-1];
		}
		catch (Exception e){
			//Möglichkeit 1
			//return "Übersetzung der Zahl " + number + " nicht möglich! (V " + Translator.version + ")";

			//Möglichkeit 2
			throw new IllegalArgumentException("Übersetzung der Zahl " + number + " nicht möglich! (V " + Translator.version + ")");
		}
	}
		
	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: Okt/2021))
	 * Das Datum sollte system-intern gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
