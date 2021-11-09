package Uebung4.view;


import Uebung4.control.*;
import Uebung4.control.exceptions.ContainerException;
import Uebung4.control.exceptions.WrongInputException;
import Uebung4.control.model.Employee;
import Uebung4.control.model.Expertise;

import java.util.Random;

/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

public class Main {

    public static void main(String[] args) {

        /*


         */


        Eingabedialog eingabedialog = new Eingabedialog();
        addRandomList();
        eingabedialog.starteEingabe();

        //1 Test
       /*
       enter

       dump

       dump abteilung AbteilungX
       search abteilung AbteilungX
       search abteilung Abteilungy

       search Expertise BWL
       search Expertise Big-Data
       search Expertise Prog

       store
       exit
        */

        //2 Test
        //addRandomNewList();
        //eingabedialog.starteEingabe();

        /*
       dump
       load merge
       dump
       exit
        */

    }

    public static void addRandomList(){
        Expertise newExpertise = new  Expertise();

        int rand = new  Random().nextInt(4-1)+1;

        try {
            newExpertise.setNewExpertise("Prog", rand);
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            rand = new  Random().nextInt(4-1)+1;
            newExpertise = new  Expertise();
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
    }


    public static void addRandomNewList(){
        Expertise newExpertise = new  Expertise();
        int rand = new  Random().nextInt(4-1)+1;

        try {
            newExpertise.setNewExpertise("Prog", rand);
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        for (int i = 100; i < 110; i++) {
            rand = new Random().nextInt(4-1)+1;
            newExpertise = new Expertise();
            try {
                newExpertise.setNewExpertise("Prog", rand);
            } catch (WrongInputException e) {
                e.printStackTrace();
            }
            try {
                Container.getInstance().addEmployee(new Employee(i,"Name"+i,"Nachname"+i,"RolleA","AbteilungA",newExpertise));
            } catch (ContainerException e) {
                e.printStackTrace();
            }

        }

    }

}
