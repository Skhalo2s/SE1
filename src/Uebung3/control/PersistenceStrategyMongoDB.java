package Uebung3.control;

/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

import Uebung3.control.exceptions.PersistenceException;

import java.util.List;

public class PersistenceStrategyMongoDB<Member> implements PersistenceStrategy<Member> {

    @Override
    public void openConnection() throws PersistenceException {
        throw new java.lang.UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void closeConnection() throws PersistenceException {
        throw new java.lang.UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void save(List<Member> member) {
        throw new java.lang.UnsupportedOperationException("Not implemented!");

    }

    @Override
    public List<Member> load() {
        throw new java.lang.UnsupportedOperationException("Not implemented!");
    }
}
