package org.promytheus.koino.service;

import org.promytheus.koino.model.ExpenseCategory;
import org.promytheus.koino.repository.ExpenseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
	private ExpenseCategoryRepository expenseCategoryRepository;
	
	public Iterable<ExpenseCategory> getAllExpenseCategories() {
		
		return expenseCategoryRepository.findAll();
    }
    
    public ExpenseCategory saveExpenseCategory(ExpenseCategory expenseCategory) {
		
		return expenseCategoryRepository.save(expenseCategory);
	}
}