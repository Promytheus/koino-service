package org.promytheus.koino.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import static org.springframework.data.mongodb.core.query.Query.*;

import java.util.Optional;

import org.promytheus.koino.model.ExpenseCategory;

import static org.springframework.data.mongodb.core.query.Criteria.*;

@Repository
@Profile("mongodb")
public class ExpenseCategoryRepositoryMongoDB implements ExpenseCategoryRepository {

	private final MongoOperations operations;

	/**
	 * Creates a new {@link ExpenseCategoryRepositoryMongoDB} using the given {@link MongoOperations}.
	 * 
	 * @param operations must not be {@literal null}.
	 */
	@Autowired
	public ExpenseCategoryRepositoryMongoDB(MongoOperations operations) {

		Assert.notNull(operations, "Mongo operations must not be null");
		this.operations = operations;
    }
    
    public Iterable<ExpenseCategory> findAll() {

        return operations.findAll(ExpenseCategory.class);
    }

	public ExpenseCategory findById(String uuid) {

		Query query = query(where("uuid").is(uuid));
		return operations.findOne(query, ExpenseCategory.class);
	}
	
	public ExpenseCategory save(ExpenseCategory expenseCategory) {

		operations.save(expenseCategory);
		return expenseCategory;
    }
    
    public ExpenseCategory update(ExpenseCategory expenseCategory) {

        Optional<ExpenseCategory> updatedExpenseCategory = operations.update(ExpenseCategory.class)
            .matching(query(where("uuid").is(expenseCategory.getUuid())))
            .replaceWith(expenseCategory).findAndReplace();

        if (!updatedExpenseCategory.isEmpty())
            return updatedExpenseCategory.get();
        else
            return null;
    }
    
    public void delete(String uuid) {

        operations.remove(ExpenseCategory.class)
            .matching(query(where("uuid").is(uuid)))
            .findAndRemove();
    }
}
