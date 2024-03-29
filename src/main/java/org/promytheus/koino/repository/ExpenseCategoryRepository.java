package org.promytheus.koino.repository;

import org.promytheus.koino.model.ExpenseCategory;
import org.springframework.data.repository.Repository;

public interface ExpenseCategoryRepository extends Repository<ExpenseCategory, Long> {

    /**
	 * Returns all instances of the type.
	 *
	 * @return all entities
	 */
    public Iterable<ExpenseCategory> findAll();
    
	/**
	 * Returns the {@link ExpenseCategory} with the given identifier.
	 * 
	 * @param id
	 * @return
	 */
	public ExpenseCategory findByUuid(String uuid);
	
	/**
	 * Saves the given {@link ExpenseCategory}.
	 * 
	 * @param expenseCategory
	 * @return
	 */
    public ExpenseCategory save(ExpenseCategory expenseCategory);
    
    /**
	 * Deletes the given {@link ExpenseCategory}.
	 * 
	 * @param uuid
	 * @return
	 */
	public void deleteByUuid(String uuid);
}
