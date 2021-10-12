package uebung1.Tests;

import org.junit.jupiter.api.*;
import uebung1.control.*;
import uebung1.control.EnglishTranslator;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */
// automatisierter Test der  klasse EnglishTranslator
class EnglishTranslatorTest {

    private Translator translator = null;

    @BeforeEach
    void setUp() {
        this.translator = new EnglishTranslator(); // erstelle neues EnglishTranslator
    }

    @Test
    void translateNumber() {

        String[] eNumbers_Test = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        // Positivtests
        // Äquivalenzklasse AK (1 <= x <=10)
        for (int i = 1; i < 10; i++)
            assertEquals(eNumbers_Test[i - 1], translator.translateNumber(i));
        assertEquals("one", translator.translateNumber(1));


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
        assertThrows(IllegalArgumentException.class, () -> translator.translateNumber(0), "Übersetzung der Zahl " + 0 + " nicht möglich! (V " + Translator.version + ")");
        // Äquivalenzklasse AK (x > 10)
        assertThrows(IllegalArgumentException.class, () -> translator.translateNumber(11), "Übersetzung der Zahl " + 11 + " nicht möglich! (V " + Translator.version + ")");
        // Äquivalenzklasse AK (x < 0)
        assertThrows(IllegalArgumentException.class, () -> translator.translateNumber(-1), "Übersetzung der Zahl " + -1 + " nicht möglich! (V " + Translator.version + ")");
    }
 }
