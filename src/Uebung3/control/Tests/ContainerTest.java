package Uebung3.control.Tests;

import Uebung3.control.*;
import Uebung3.control.exceptions.ContainerException;
import Uebung3.control.exceptions.PersistenceException;
import org.junit.jupiter.api.*;
import java.io.FileNotFoundException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void LoadeStoreTest(){
        container.setPersistenceStrategie(new PersistenceStrategyStream());
        try {
            container.addMember(member1);
            container.addMember(member2);
            container.addMember(member3);
            container.store();
            assertEquals(3,container.size());

        } catch (ContainerException | PersistenceException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    void s(){

        container = Container.getInstanc();
        container.setPersistenceStrategie(new PersistenceStrategyStream());
        assertEquals(3,container.size());
        try {
            container.addMember(new ActualMember(33));
            container.addMember(new ActualMember(11));
            container.addMember(new ActualMember(66));
            container.addMember(new ActualMember(77));
            container.addMember(new ActualMember(99));
            container.store();



            assertEquals(8,container.size());
        } catch (ContainerException | PersistenceException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
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
    }

    @Test
    void wrongLocationTest(){
        PersistenceStrategyStream<Member> newStrategy = new PersistenceStrategyStream<>();
        newStrategy.setLocation("out\\" + new Random().nextInt());
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