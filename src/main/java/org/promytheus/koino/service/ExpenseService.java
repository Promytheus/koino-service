package org.promytheus.koino.service;

import org.promytheus.koino.model.Expense;
import org.promytheus.koino.model.ExpenseCategory;
import org.promytheus.koino.repository.ExpenseCategoryRepository;
import org.promytheus.koino.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseCategoryRepository expenseCategoryRepository;
    
    @Autowired
	private ExpenseRepository expenseRepository;
	
	public Iterable<ExpenseCategory> getAllExpenseCategories() {
		
		return expenseCategoryRepository.findAll();
    }

    public ExpenseCategory getExpenseCategory(String uuid) {
		
		return expenseCategoryRepository.findById(uuid);
    }
    
    public ExpenseCategory saveExpenseCategory(ExpenseCategory expenseCategory) {
		
		return expenseCategoryRepository.save(expenseCategory);
    }

    public ExpenseCategory updateExpenseCategory(ExpenseCategory expenseCategory) {
		
		return expenseCategoryRepository.update(expenseCategory);
    }

    public void deleteExpenseCategory(String uuid) {
		
		expenseCategoryRepository.delete(uuid);
    }

    public Iterable<Expense> getAllExpenses() {
		
		return expenseRepository.findAll();
    }

    public Expense getExpense(String uuid) {
		
		return expenseRepository.findById(uuid);
    }
    
    public Expense saveExpense(Expense expense) {
		
		return expenseRepository.save(expense);
    }
    
    public Expense updateExpense(Expense expense) {
		
		return expenseRepository.update(expense);
    }
    
    public void deleteExpense(String uuid) {
		
		expenseRepository.delete(uuid);
    }
}