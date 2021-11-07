package Uebung4.control;

import Uebung4.control.exceptions.PersistenceException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SpToolTest {
    /**
     *Bitte geben Sie die ID des Mitarbeiters ein: x
     *
     * Das ist leider keine Zahl!
     * Bitte geben Sie die ID des Mitarbeiters ein: -1
     * Bitte nur positive Zhalen eingeben!
     * Bitte geben Sie die ID des Mitarbeiters ein: 0
     *
     * Die ID 0 ist bereits enthalten versuchen Sie nochmal!
     * Bitte geben Sie die ID des Mitarbeiters ein: 100
     *
     *
     *
     *
     */

    @Test
    void test(){
        try {
            Container.getInstance().setPersistenceStrategie( new PersistenceStrategyStream());
            Container.getInstance().store();

        } catch (PersistenceException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Container.getInstance().loadMerge();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

}