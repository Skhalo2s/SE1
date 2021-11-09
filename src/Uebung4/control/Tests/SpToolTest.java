package Uebung4.control.Tests;


import Uebung4.control.Container;
import Uebung4.control.Eingabedialog;

import Uebung4.control.model.Employee;
import Uebung4.control.model.Expertise;
import Uebung4.control.exceptions.ContainerException;
import Uebung4.control.exceptions.WrongInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;


class SpToolTest {
    Eingabedialog eingabedialog ;

    @BeforeEach
    void sP(){
        eingabedialog = new Eingabedialog();
    }


    @Test
    public void exitTest() {
        System.out.println("exitTest");
        eingabedialog.starteEingabe(new Scanner("exit"));


    }

    @Test
    public void helpTest() {
        System.out.println("helpTest");

        eingabedialog.starteEingabe(new Scanner("help\nexit\n"));
    }

    @Test
    public void dumpStoreTest() {
        System.out.println("\ndumpStoreTest");

        eingabedialog.starteEingabe(new Scanner("dump\nexit\n"));

        Expertise newExpertise = new  Expertise();
        int rand = new  Random().nextInt(4-1)+1;

        try {
            newExpertise.setNewExpertise("Prog", rand);
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            rand = new Random().nextInt(4-1)+1;
            newExpertise = new Expertise();
            try {
                newExpertise.setNewExpertise("Prog", rand);
            } catch (WrongInputException e) {
                e.printStackTrace();
            }
            try {
                Container.getInstance().addEmployee(new Employee(i,"Name"+i,"Nachname"+i,"RolleX","AbteilungX",newExpertise));
            } catch (ContainerException e) {
                e.printStackTrace();
            }

        }


        for (int i = 50 ;i < 60; i++) {
            rand = new  Random().nextInt(4-1)+1;
            newExpertise = new  Expertise();

            try {
                newExpertise.setNewExpertise("Big-Data", rand);
                rand = new  Random().nextInt(4-1)+1;
                newExpertise.setNewExpertise("BWL", rand);

            } catch (WrongInputException e) {
                e.printStackTrace();
            }

            try {
                Container.getInstance().addEmployee(new Employee(i,"Name"+i,"Nachname"+i,"RolleX","AbteilungZ",newExpertise));
            } catch (ContainerException e) {
                e.printStackTrace();
            }
        }



        for (int i = 10 ;i < 20; i++) {
            newExpertise = new  Expertise();
            rand = new  Random().nextInt(4-1)+1;
            try {
                newExpertise.setNewExpertise("BWL", rand);
                rand = new  Random().nextInt(4-1)+1;
                newExpertise.setNewExpertise("Prog", rand);
            } catch (WrongInputException e) {
                e.printStackTrace();
            }

            try {
                Container.getInstance().addEmployee(new Employee(i,"Name"+i,"Nachname"+i,"RolleX","AbteilungY",newExpertise));
            } catch (ContainerException e) {
                e.printStackTrace();
            }
        }


        eingabedialog.starteEingabe(new Scanner("dump\nexit"));

        eingabedialog.starteEingabe(new Scanner("store\nexit"));

        for (int i = 0; i < 50; i++) {
            Container.getInstance().deleteMember(i);
        }


    }


    @Test
    void loadForceTest(){
        System.out.println("loadForceTest");
        Expertise newExpertise = new  Expertise();
        int rand = new  Random().nextInt(4-1)+1;

        try {
            newExpertise.setNewExpertise("Prog", rand);
        } catch (WrongInputException e) {
            e.printStackTrace();
        }

        for (int i = 70; i < 80; i++) {
            rand = new Random().nextInt(4-1)+1;
            newExpertise = new Expertise();
            try {
                newExpertise.setNewExpertise("DB", rand);
            } catch (WrongInputException e) {
                e.printStackTrace();
            }
            try {
                Container.getInstance().addEmployee(new Employee(i,"Name"+i,"Nachname"+i,"RolleA","AbteilungA",newExpertise));
            } catch (ContainerException e) {
                e.printStackTrace();
            }

        }
        eingabedialog.starteEingabe(new Scanner("dump\nstore\nexit\n")); // alte Liste

        // neue Liste
        for (int i = 80; i < 90; i++) {
            rand = new Random().nextInt(4-1)+1;
            newExpertise = new Expertise();
            try {
                newExpertise.setNewExpertise("no idea", rand);
            } catch (WrongInputException e) {
                e.printStackTrace();
            }
            try {
                Container.getInstance().addEmployee(new Employee(i,"Name"+i,"Nachname"+i,"RolleA","AbteilungA",newExpertise));
            } catch (ContainerException e) {
                e.printStackTrace();
            }

        }

        eingabedialog.starteEingabe(new Scanner("dump\nload force\ndump\nexit\n")); // alte Liste

        for (int i = 70; i < 90; i++) {
            Container.getInstance().deleteMember(i);
        }
    }


    @Test
    void loadMergeTest(){
        System.out.println("loadMergeTest");


        Expertise newExpertise = new  Expertise();
        int rand = new  Random().nextInt(4-1)+1;

        try {
            newExpertise.setNewExpertise("Prog", rand);
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            rand = new Random().nextInt(4-1)+1;
            newExpertise = new Expertise();
            try {
                newExpertise.setNewExpertise("Prog", rand);
            } catch (WrongInputException e) {
                e.printStackTrace();
            }
            try {
                Container.getInstance().addEmployee(new Employee(i,"Name"+i,"Nachname"+i,"RolleX","AbteilungX",newExpertise));
            } catch (ContainerException e) {
                e.printStackTrace();
            }

        }


        for (int i = 50 ;i < 60; i++) {
            rand = new  Random().nextInt(4-1)+1;
            newExpertise = new  Expertise();

            try {
                newExpertise.setNewExpertise("Big-Data", rand);
                rand = new  Random().nextInt(4-1)+1;
                newExpertise.setNewExpertise("BWL", rand);

            } catch (WrongInputException e) {
                e.printStackTrace();
            }

            try {
                Container.getInstance().addEmployee(new Employee(i,"Name"+i,"Nachname"+i,"RolleX","AbteilungZ",newExpertise));
            } catch (ContainerException e) {
                e.printStackTrace();
            }
        }



        for (int i = 10 ;i < 20; i++) {
            newExpertise = new  Expertise();
            rand = new  Random().nextInt(4-1)+1;
            try {
                newExpertise.setNewExpertise("BWL", rand);
                rand = new  Random().nextInt(4-1)+1;
                newExpertise.setNewExpertise("Prog", rand);
            } catch (WrongInputException e) {
                e.printStackTrace();
            }

            try {
                Container.getInstance().addEmployee(new Employee(i,"Name"+i,"Nachname"+i,"RolleX","AbteilungY",newExpertise));
            } catch (ContainerException e) {
                e.printStackTrace();
            }
        }
        eingabedialog.starteEingabe(new Scanner("dump\nstore\nexit\n")); // alte Liste

        for (int i = 0; i < 50; i++) {
            Container.getInstance().deleteMember(i);
        }

        try {
            newExpertise.setNewExpertise("Prog", rand);
        } catch (WrongInputException e) {
            e.printStackTrace();
        }

        // neu liste
        for (int i = 100; i < 110; i++) {
            rand = new Random().nextInt(4-1)+1;
            newExpertise = new Expertise();
            try {
                newExpertise.setNewExpertise("No idea", rand);
            } catch (WrongInputException e) {
                e.printStackTrace();
            }
            try {
                Container.getInstance().addEmployee(new Employee(i,"Name"+i,"Nachname"+i,"RolleA","AbteilungA",newExpertise));
            } catch (ContainerException e) {
            }

        }



        eingabedialog.starteEingabe(new Scanner("dump\nload merge\ndump\nexit\n")); // alte Liste

        for (int i = 0; i < 110; i++) {
            Container.getInstance().deleteMember(i);
        }
    }

}