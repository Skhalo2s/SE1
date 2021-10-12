package uebung1.Tests;

import uebung1.view.Client;

/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

// testen mit main
public class BlackBoxTest {

    private Client client = null;

    public BlackBoxTest() {
        client = new Client();
    }

    public void test() {

        // Positivtests
        // Äquivalenzklasse AK (1 <= x <=10).
        client.display(1);
        client.display(2);
        client.display(3);
        client.display(4);
        client.display(5);
        client.display(6);
        client.display(7);
        client.display(8);
        client.display(9);
        client.display(10);

        // Negativtests

        // Äquivalenzklasse  (x > 10)
        //client.display(11);

        // Spezial-Testfall
        //client.display(0);

        // Äquivalenzklasse  (x < 0)
        //client.display(-1);

    }

    public static void main(String[] args) {
        BlackBoxTest bBT = new BlackBoxTest();
        bBT.test();
    }
}
