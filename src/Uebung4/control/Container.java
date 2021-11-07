package Uebung4.control;

import Uebung4.control.exceptions.ContainerException;
import Uebung4.control.exceptions.PersistenceException;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

public class Container{

    private List<Employee> container ;
    private static Container instance = null;
    private PersistenceStrategy myStrategy = null;


    private Container(){
        container = new ArrayList<>();
    }

    public static Container getInstance(){
        if (instance == null){
            instance =  new Container();
        }
        return instance;
    }

    public List<Employee> getCurrentList() {
        return this.container;
    }


    public int size(){
        return container.size();
    }

    public String deleteMember(Integer id){

        for (Employee m: container){
            if (m.getID().equals(id)) {
                container.remove(m);
                return "Das Member-Objekt mit der ID " + id + " wurde erfogreich geloescht!";
            }
        }

        return "Das Member-Objekt mit der ID " + id + " ist nicht vorhanden!";
    }

    public void addEmployee(Employee member) throws ContainerException {

        //member vorhanden? abbrechen.
        if (contain(member.getID())){
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
        }
        else {
            // member nicht vorhanden? hinzufügen
            container.add(member);
        }

    }

    public boolean contain(Integer id){

        boolean ret = false ;

        for (Employee m: container){
            if(m.getID().equals(id))
            ret = true;
        }

        return  ret;
    }






    public void setPersistenceStrategie(PersistenceStrategy persistenceStrategy) {
        this.myStrategy = persistenceStrategy;
    }

    public void store() throws PersistenceException, FileNotFoundException {
        if(myStrategy== null)
            throw new PersistenceException( PersistenceException.ExceptionType.NoStrategyIsSet,"Strategy not initialized");

        try {

            myStrategy.save(container);

        }catch (UnsupportedOperationException e){
                throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Not implemented");
        }

    }

    public void loadForce()throws PersistenceException {
        if(myStrategy== null)
            throw new PersistenceException( PersistenceException.ExceptionType.NoStrategyIsSet,"Strategy not initialized");
        try {

            this.container = myStrategy.load();

        }
        catch (UnsupportedOperationException e){
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Not implemented");
        }

    }

    public void loadMerge()throws PersistenceException {
        if(myStrategy== null)
            throw new PersistenceException( PersistenceException.ExceptionType.NoStrategyIsSet,"Strategy not initialized");
        try {

            List<Employee> tempList = myStrategy.load();
            for (Employee employee: tempList) {
                try {
                    if (!contain(employee.getID())){
                        this.addEmployee(employee);
                    }

                } catch (ContainerException e) {

                }
            }

        }
        catch (UnsupportedOperationException e){
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Not implemented");
        }

    }

}
