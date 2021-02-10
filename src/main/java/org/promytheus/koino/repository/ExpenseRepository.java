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
	public Expense findById(Long id);
	
	/**
	 * Saves the given {@link Expense}.
	 * 
	 * @param expense
	 * @return
	 */
	public Expense save(Expense expense);
}
