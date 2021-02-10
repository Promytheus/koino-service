package org.promytheus.koino.repository;

import org.promytheus.koino.model.Expense;
import org.springframework.data.repository.Repository;

public interface ExpenseRepository extends Repository<Expense, Long> {

    /**
	 * Returns all instances of the type.
	 *
	 * @return all entities
	 */
    Iterable<Expense> findAll();
    
	/**
	 * Returns the {@link Expense} with the given identifier.
	 * 
	 * @param id
	 * @return
	 */
	public Expense findById(String uuid);
	
	/**
	 * Saves the given {@link Expense}.
	 * 
	 * @param expense
	 * @return
	 */
    public Expense save(Expense expense);
    
    /**
	 * Updates the given {@link Expense}.
	 * 
	 * @param expense
	 * @return
	 */
    public Expense update(Expense expense);
    
    /**
	 * Deletes the given {@link Expense}.
	 * 
	 * @param uuid
	 * @return
	 */
	public void delete(String uuid);
}
