package Uebung3.control.Tests;

import Uebung3.control.*;
import Uebung3.control.exceptions.ContainerException;
import Uebung3.control.exceptions.PersistenceException;
import org.junit.jupiter.api.*;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.1
 *
 */

class ContainerTest {

    Container container = Container.getInstanc();
    MemberView memberView = new MemberView();

    @Test
    void PersistenceStrategieNotSetTest(){
            PersistenceException e = assertThrows(PersistenceException.class, () ->  container.load());
            assertEquals(PersistenceException.ExceptionType.NoStrategyIsSet,e.getExceptionType());
            assertEquals("Strategy not initialized",e.getMessage());

            PersistenceException e1 = assertThrows(PersistenceException.class, () ->  container.store());
            assertEquals(PersistenceException.ExceptionType.NoStrategyIsSet,e1.getExceptionType());
            assertEquals("Strategy not initialized",e1.getMessage());
    }
    @Test
    void PersistenceStrategyMongoDBTest(){
        container.setPersistenceStrategie(new PersistenceStrategyMongoDB());
        PersistenceException e = assertThrows(PersistenceException.class, () ->  container.load());
        assertEquals(PersistenceException.ExceptionType.ImplementationNotAvailable,e.getExceptionType());
        assertEquals("Not implemented",e.getMessage());

        PersistenceException e1 = assertThrows(PersistenceException.class, () ->  container.store());
        assertEquals(PersistenceException.ExceptionType.ImplementationNotAvailable,e1.getExceptionType());
        assertEquals("Not implemented",e1.getMessage());
    }

    @Test
    void wrongLocationTest(){

        // teste auf nicht vorhandene location
        PersistenceStrategyStream<Member> newStrategy = new PersistenceStrategyStream<>();
        newStrategy.setLocation("NE.ser" );
        container.setPersistenceStrategie(newStrategy);
        PersistenceException e = assertThrows(PersistenceException.class, () ->  container.load());
        assertEquals(PersistenceException.ExceptionType.ConnectionNotAvailable,e.getExceptionType());
        assertEquals("No Connection",e.getMessage());

        // teste auf null
        newStrategy.setLocation(null);
        e = assertThrows(PersistenceException.class, () ->  container.load());
        assertEquals(PersistenceException.ExceptionType.ConnectionNotAvailable,e.getExceptionType());
        assertEquals("No Connection",e.getMessage());
    }



    @Test

    void StoreLoadeTest(){

        container = Container.getInstanc();
        container.setPersistenceStrategie(new PersistenceStrategyStream());

        // sicher stellen, dass noch liste leer ist
        assertEquals(0,container.size());

        try {
            // daten ersmal in der liste speiseisciern
            container.addMember(new ActualMember(33));
            container.addMember(new ActualMember(11));
            container.addMember(new ActualMember(66));
            container.addMember(new ActualMember(77));
            container.addMember(new ActualMember(99));

            // sicher stellen, dass daten in der liste sind
            assertEquals(5,container.size());

            // daten auf HDD speischern
            container.store();

            // daten von liste löschen
            container.deleteMember(33);
            container.deleteMember(11);
            container.deleteMember(66);
            container.deleteMember(77);
            container.deleteMember(99);

            // sicher stellen, dass die daten von liste geloescht wurden
            assertEquals(0,container.size());

            //Daten in der liste von HDD in der liste loaden
            container.load();

            // sicher stellen, dass die daten nur in der liste geloadet
            assertEquals(5,container.size());

            // Daten auf Bildschirm zeigen
            System.out.println("Diese Liste ist nach dem speischern:");
            memberView.dump(container.getCurrentList());

            // die geloadetede daten von der liste löschen
            container.deleteMember(33);
            container.deleteMember(11);
            container.deleteMember(66);
            container.deleteMember(77);
            container.deleteMember(99);

            // sicher stellen, dass die daten von der liste geloescht wurden
            assertEquals(0,container.size());

            //fuege neu Daten in der liste hin
            container.addMember(new ActualMember(3));
            container.addMember(new ActualMember(1));
            container.addMember(new ActualMember(6));
            container.addMember(new ActualMember(7));
            container.addMember(new ActualMember(9));

            // sicher stellen, dass die daten in der liste sind
            assertEquals(5,container.size());

            // Daten auf HDD speischern
            container.store();

            // loesch daten von der liste
            container.deleteMember(3);
            container.deleteMember(1);
            container.deleteMember(6);
            container.deleteMember(7);
            container.deleteMember(9);

            // sicher stellen, dass die daten von der liste geloescht wurden
            assertEquals(0,container.size());

            // lade die daten von HDD in der liste
            container.load();

            // sicher stellen, dass die daten in der liste sind
            assertEquals(5,container.size());

            // Daten auf Bildschirm zeigen
            System.out.println();
            System.out.println("Diese Liste ist nach dem Ueberschreiben:");
            memberView.dump(container.getCurrentList());


            // loesch daten von der liste
            container.deleteMember(3);
            container.deleteMember(1);
            container.deleteMember(6);
            container.deleteMember(7);
            container.deleteMember(9);

            // sicher stellen, dass die daten von der liste geloescht wurden
            assertEquals(0,container.size());

            // lade die daten von HDD in der liste zum zweiten mal
            container.load();

            // sicher stellen, dass die daten in der liste sind
            assertEquals(5,container.size());

            // Daten auf Bildschirm zeigen
            System.out.println();
            System.out.println("Diese Liste ist nach dem Ueberschreiben zum zweiten Mal:");
            memberView.dump(container.getCurrentList());

            // Test Ende
            System.out.println();
            System.out.println("Test erfolgreich bendet ;-)");

        } catch (ContainerException | PersistenceException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}