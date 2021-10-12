package uebung1.control.factory;

import uebung1.control.*;
/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */


//Factory-Klasse zur zentralen und konsistenten Erstellung von Translator-Objekten (Design Pattern Factory Method)
public class TranslatorFactory {


    public static Translator createGermanTranslator(){
        return new GermanTranslator();
    }
    public static Translator createEnglishTranslator(){ return new EnglishTranslator(); }

}
