package Uebung2.Tests;

import Uebung2.control.Container;
import Uebung2.control.CreatMember;
import Uebung2.control.Member;
import Uebung2.control.exceptions.ContainerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container container = null;

    Member member1 = new CreatMember(96);
    Member member2 = new CreatMember(105);
    Member member3 = new CreatMember(73);
    Member member4 = new CreatMember(96);

    @BeforeEach
    void setUp() {
        container = new Container();
    }

    @Test
    void addMember() throws ContainerException {

        container.addMember(member1);

        assertThrows(ContainerException.class, () -> container.addMember(member4));
        assertThrows(NullPointerException.class, () -> container.addMember(null));
    }

    @Test
    void size() {
        assertEquals(0, container.size());
        try {
            container.addMember(member1);
            assertEquals(1, container.size());

            container.addMember(member2);
            assertEquals(2, container.size());
            container.addMember(member3);
            assertEquals(3, container.size());


            assertEquals(3, container.size());

            container.addMember(member4);
            assertEquals(3, container.size());
        } catch (ContainerException e) {
            assertEquals("Das Member-Objekt mit der ID 96 ist bereits vorhanden!", e.getMessage());
        }

        container.deleteMember(96);
        assertEquals(2, container.size());
        container.deleteMember(96);
        assertEquals(2, container.size());
        container.deleteMember(105);
        assertEquals(1, container.size());
        container.deleteMember(73);
        assertEquals(0, container.size());

    }

    @Test
    void deleteMember() throws ContainerException {
        assertEquals("Das Member-Objekt mit der ID 33 ist nicht vorhanden!", container.deleteMember(33));
        container.addMember(member1);
        container.addMember(member2);
        container.addMember(member3);

        assertEquals("Das Member-Objekt mit der ID " + member1.getID() + " wurde erfogreich geloescht!", container.deleteMember(96));
        assertEquals("Das Member-Objekt mit der ID " + member2.getID() + " wurde erfogreich geloescht!", container.deleteMember(105));
        assertEquals("Das Member-Objekt mit der ID " + member3.getID() + " wurde erfogreich geloescht!", container.deleteMember(73));
        assertEquals("Das Member-Objekt mit der ID " + member1.getID() + " ist nicht vorhanden!", container.deleteMember(96));
    }

    @Test
    void dump()throws ContainerException{

        try {
            container.addMember(member1);
            container.addMember(member2);
            container.addMember(member3);
            container.addMember(member4);
        } catch (ContainerException e) {
            container.addMember(new CreatMember(1));
        }

        container.dump();
    }

}