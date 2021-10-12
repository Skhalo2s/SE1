package uebung1.Tests;

import org.junit.jupiter.api.*;
import uebung1.control.GermanTranslator;
import uebung1.control.Translator;
import uebung1.view.Client;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */


// automatisierter Test der  klasse GermanTranslator
class GermanTranslatorTest {

    private Translator translator = null;

    @BeforeEach
    void setUp() {
        this.translator = new GermanTranslator(); // erstelle neues GermanTranslator
    }


    @Test
    void translateNumber() {

        String[] gNumbers_Test = {"Eins","Zwei","Drei","Vier","Fünf","Sechs","Sieben", "Acht", "Neuen", "Zehn"};

        // Positivtests
        // Äquivalenzklasse ÄK (1 <= x <=10)

        //Möglichkeit 1
        assertEquals("Eins",translator.translateNumber(1));
        assertEquals("Zwei",translator.translateNumber(2));
        assertEquals("Drei",translator.translateNumber(3));
        assertEquals("Vier",translator.translateNumber(4));
        assertEquals("Fünf",translator.translateNumber(5));
        assertEquals("Sechs",translator.translateNumber(6));
        assertEquals("Sieben",translator.translateNumber(7));
        assertEquals("Acht",translator.translateNumber(8));
        assertEquals("Neuen",translator.translateNumber(9));
        assertEquals("Zehn",translator.translateNumber(10));

        //Möglichkeit 2
        for (int i = 1 ; i<10 ; i++)
            assertEquals(gNumbers_Test[i-1],translator.translateNumber(i));


        // Negativtests

        //Möglichkeit 1
        // Spezial-Testfall
        //assertEquals("Übersetzung der Zahl " + 0 + " nicht möglich! (V " + Translator.version + ")",translator.translateNumber(0));
        // Äquivalenzklasse  (x > 10)
        //assertEquals("Übersetzung der Zahl " + 11 + " nicht möglich! (V " + Translator.version + ")",translator.translateNumber(11));
        // Äquivalenzklasse  (x < 0)
        //assertEquals("Übersetzung der Zahl " + -1 + " nicht möglich! (V " + Translator.version + ")",translator.translateNumber(-1));

        //Möglichkeit 2
        // Spezial-Testfall
        assertThrows(IllegalArgumentException.class,() -> translator.translateNumber(0),"Übersetzung der Zahl " + 0 + " nicht möglich! (V " + Translator.version + ")");
        // Äquivalenzklasse ÄK (x > 10)
        assertThrows(IllegalArgumentException.class,() -> translator.translateNumber(11),"Übersetzung der Zahl " + 11 + " nicht möglich! (V " + Translator.version + ")");
        // Äquivalenzklasse ÄK (x < 0)
        assertThrows(IllegalArgumentException.class,() -> translator.translateNumber(-1),"Übersetzung der Zahl " + -1 + " nicht möglich! (V " + Translator.version + ")");

        //Client c = new Client();

        //assertEquals("", c.display(5));


    }
}