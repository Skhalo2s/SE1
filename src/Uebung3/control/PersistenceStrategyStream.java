package Uebung3.control;

import Uebung3.control.PersistenceStrategy;
import Uebung3.control.exceptions.PersistenceException;

import java.io.*;

import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {

    // URL of file, in which the objects are stored
    private String location = "objects.ser";
    private ObjectInputStream ois = null;
    private List<Member> newListe =  null;
    private ObjectOutputStream objOut = null;
    private  Object obj = null;

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save
     */
    public void openConnection() throws PersistenceException {

        throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable,"Implementation Not Available");

    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {

        throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable,"Implementation Not Available");

    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException {

        try {
            objOut = new ObjectOutputStream(new FileOutputStream(location));
            objOut.writeObject(member);
            objOut.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<Member> load() throws PersistenceException  {
        // Some Coding hints ;-)
        // ObjectInputStream ois = null;
        // FileInputStream fis = null;
        // List<...> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch ommitted here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams (guess where this could be...?)
        if (location == null)
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,"No Connection");

            try {
                ois = new ObjectInputStream(new FileInputStream(location));
                newListe = (List<Member>) ois.readObject();
                ois.close();
            }
            catch (FileNotFoundException  e) {
                throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,"No Connection");
            }
            catch (ClassNotFoundException  e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                 e.printStackTrace();
            }

        return newListe;
    }
}
