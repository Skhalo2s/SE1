package Uebung4.control;

import Uebung4.control.exceptions.PersistenceException;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Interface for defining basic methods for a persistence mechanism
 * Each concrete algorithm (i.e. strategy) must implement this method
 * This interface corresponds to the abstract strategy w.r.t. to the
 * Strategy Design Pattern (GoF).
 *
 * The following protocol applies:
 * 1. openConnection
 * 2. { load | save }  (many times)
 * 3. closeConnection.
 *
 * @param <E>
 */
public interface PersistenceStrategy<E> {
    public void openConnection() throws PersistenceException;
    public void closeConnection() throws PersistenceException;
    public void save(List<E> member) throws PersistenceException, FileNotFoundException;
    public List<E> load() throws PersistenceException;
}
