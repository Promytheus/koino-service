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
	public ExpenseCategory findById(Long id);
	
	/**
	 * Saves the given {@link ExpenseCategory}.
	 * 
	 * @param expenseCategory
	 * @return
	 */
	public ExpenseCategory save(ExpenseCategory expenseCategory);
}
