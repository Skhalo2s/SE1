package Uebung3.control;

import Uebung3.control.exceptions.PersistenceException;
import Uebung3.control.exceptions.ContainerException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

public class Container {

    private List<Member> container ;
    private static Container instsnc = null;
    private PersistenceStrategy myStrategy = null;


    private Container(){
        container = new ArrayList<>();
    }

    public static Container getInstanc(){
        if (instsnc == null){
            instsnc =  new Container();
        }
        return instsnc;
    }

    public List<Member> getCurrentList() {
        return this.container;
    }


    public int size(){
        return container.size();
    }

    public String deleteMember(Integer id){

        for (Member m: container){
            if (m.getID().equals(id)) {
                container.remove(m);
                return "Das Member-Objekt mit der ID " + id + " wurde erfogreich geloescht!";
            }
        }

        return "Das Member-Objekt mit der ID " + id + " ist nicht vorhanden!";
    }

    public void addMember(Member member) throws ContainerException {

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




    public boolean equals(Container o) {
        return (this.size() == o.size() ) ;
    }

    public void setPersistenceStrategie(PersistenceStrategy persistenceStrategy) {
        this.myStrategy = persistenceStrategy;
    }

    public void store() throws PersistenceException, FileNotFoundException {
        if(myStrategy== null)
            throw new PersistenceException( PersistenceException.ExceptionType.NoStrategyIsSet,"Strategy not initialized");

        try {

            myStrategy.save(container);

        }catch (java.lang.UnsupportedOperationException e){
                throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Not implemented");
        }

    }

    public void load()throws PersistenceException{
        if(myStrategy== null)
            throw new PersistenceException( PersistenceException.ExceptionType.NoStrategyIsSet,"Strategy not initialized");
        try {

            this.container = myStrategy.load();

        }
        catch (java.lang.UnsupportedOperationException e){
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Not implemented");
        }

    }






}
