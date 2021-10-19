package Uebung2.control;

import Uebung2.control.exceptions.ContainerException;

import java.util.ArrayList;

public class Container {

    private ArrayList<Member> container ;


    public Container(){
        container = new ArrayList<>();
    }

    public int size(){
        return container.size();
    }

    public String deleteMember(Integer id){

        for (Member m: container){
            if (m.getID() == id) {
                container.remove(m);
                return "Das Member-Objekt mit der ID " + id + " wurde erfogreich geloescht!";
            }
        }

        return "Das Member-Objekt mit der ID " + id + " ist nicht vorhanden!";
    }

    public void addMember(Member member) throws ContainerException{

        //member vorhanden? abbrechen.
        if (contain(member.getID())){
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
        }
        else {
            // member nicht vorhanden? hinzufügen
            container.add(member);
        }

    }

    private boolean contain(Integer id){

        boolean ret = false ;

        for (Member m: container){
            if(m.getID() == id)
            ret = true;
        }

        return  ret;
    }

    public void dump( ){
        for (Member member : container){
            System.out.println(member.toString());
        }
    }


}
