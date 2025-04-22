
package com.gcu.carstoreapplication.model;

import java.util.List;

/**
 * Generic interface for data access operations.
 * This interface defines common CRUD operations for any type of entity.
 *
 * @param <T> the type of the entity that the implementing class will handle
 */
public interface DataAccessInterface<T> {

    /**
     * Retrieves all entities of type T.
     *
     * @return a list of all entities
     */
    public List<T> findAll();

    /**
     * Retrieves an entity of type T by its ID.
     *
     * @param id the ID of the entity
     * @return the entity with the specified ID, or null if not found
     */
    public T findById(int id);

    /**
     * Creates a new entity of type T.
     *
     * @param t the entity to be created
     * @return true if the entity was successfully created, false otherwise
     */
    public boolean create(T t);

    /**
     * Updates an existing entity of type T.
     *
     * @param t the entity to be updated
     * @return true if the entity was successfully updated, false otherwise
     */
    public boolean update(T t);

    /**
     * Deletes an entity of type T.
     *
     * @param t the entity to be deleted
     * @return true if the entity was successfully deleted, false otherwise
     */
    public boolean delete(T t);
}
