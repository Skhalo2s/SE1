package uebung1.view;

import uebung1.control.Translator;
import uebung1.control.factory.TranslatorFactory;

/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

public class Client {

	private Translator  translator = null;

	public Client(){

	}

	/*
	 * Methode zur Ausgabe einer Zahl auf der Console.
	 */
	public void display(int aNumber ){
		// In dieser Methode soll die Methode translateNumber 
		// mit dem übergegebenen Wert der Variable aNumber 
		// aufgerufen werden.
		//
		// Strenge Implementierung gegen das Interface Translator gewuenscht!

		translator = TranslatorFactory.createGermanTranslator();  // erstelle neues GermanTranslator
		String result = translator.translateNumber(aNumber);// Uebersetze Zahl  (1 <= x <=10)
		System.out.println("Das Ergebnis der Berechnung: " + result  ); // zeige Ergebnis auf dem Bildschirm

		//return "";
	}

	// z.B EnglishTranslator
	public void setNewTranslator(Translator translator){
		this.translator = translator;
	}
}




