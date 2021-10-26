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
 * @vision 1.0
 *
 */

class ContainerTest {

    Container container = Container.getInstanc();

    Member member1 = new ActualMember(96);
    Member member2 = new ActualMember(105);
    Member member3 = new ActualMember(73);
    MemberView memberView = new MemberView();


    @BeforeEach
    void setUp() {

    }

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
    void PersistenceStrategyMongoDBTest() {
        container.setPersistenceStrategie(new PersistenceStrategyMongoDB());
        PersistenceException e = assertThrows(PersistenceException.class, () ->  container.load());
        assertEquals(PersistenceException.ExceptionType.ImplementationNotAvailable,e.getExceptionType());
        assertEquals("Not implemented",e.getMessage());

        PersistenceException e1 = assertThrows(PersistenceException.class, () ->  container.store());
        assertEquals(PersistenceException.ExceptionType.ImplementationNotAvailable,e1.getExceptionType());
        assertEquals("Not implemented",e1.getMessage());
    }



    @Test

    void StoreLoadeTest(){

        container = Container.getInstanc();
        container.setPersistenceStrategie(new PersistenceStrategyStream());
        assertEquals(0,container.size());
        try {
            container.addMember(new ActualMember(33));
            container.addMember(new ActualMember(11));
            container.addMember(new ActualMember(66));
            container.addMember(new ActualMember(77));
            container.addMember(new ActualMember(99));

            assertEquals(5,container.size());

            container.store();

            container.deleteMember(33);
            container.deleteMember(11);
            container.deleteMember(66);
            container.deleteMember(77);
            container.deleteMember(99);

            assertEquals(0,container.size());

            container.load();

            assertEquals(5,container.size());
            System.out.println("Diese Liste ist nach dem speischern:");
            memberView.dump(container.getCurrentList());

            container.deleteMember(33);
            container.deleteMember(11);
            container.deleteMember(66);
            container.deleteMember(77);
            container.deleteMember(99);


            container.addMember(new ActualMember(3));
            container.addMember(new ActualMember(1));
            container.addMember(new ActualMember(6));
            container.addMember(new ActualMember(7));
            container.addMember(new ActualMember(9));

            assertEquals(5,container.size());

            container.store();
            container.deleteMember(3);
            container.deleteMember(1);
            container.deleteMember(6);
            container.deleteMember(7);
            container.deleteMember(9);

            container.load();
            assertEquals(5,container.size());

            System.out.println("Diese Liste ist nach dem Ueberschreiben:");
            memberView.dump(container.getCurrentList());

        } catch (ContainerException | PersistenceException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /*@Test
    void Lode(){
        container.setPersistenceStrategie(new PersistenceStrategyStream());
        try {
            container.addMember(new ActualMember(33));
            container.addMember(new ActualMember(11));
            container.addMember(new ActualMember(66));
            container.addMember(new ActualMember(77));
            container.addMember(new ActualMember(99));
            container.store();
            container.load();
        } catch (PersistenceException | ContainerException | FileNotFoundException e) {
            e.printStackTrace();
        }
        memberView.dump(container.getCurrentList());
    } */

    @Test
    void wrongLocationTest(){
        PersistenceStrategyStream<Member> newStrategy = new PersistenceStrategyStream<>();
        newStrategy.setLocation("NE.ser" );
        container.setPersistenceStrategie(newStrategy);
        PersistenceException e = assertThrows(PersistenceException.class, () ->  container.load());
        assertEquals(PersistenceException.ExceptionType.ConnectionNotAvailable,e.getExceptionType());
        assertEquals("No Connection",e.getMessage());

        newStrategy.setLocation(null);
        e = assertThrows(PersistenceException.class, () ->  container.load());
        assertEquals(PersistenceException.ExceptionType.ConnectionNotAvailable,e.getExceptionType());
        assertEquals("No Connection",e.getMessage());
    }
}