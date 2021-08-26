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
		
		return expenseCategoryRepository.findByUuid(uuid);
    }
    
    public ExpenseCategory saveExpenseCategory(ExpenseCategory expenseCategory) {
		
		return expenseCategoryRepository.save(expenseCategory);
    }

    public ExpenseCategory updateExpenseCategory(ExpenseCategory expenseCategory) {
		
    	ExpenseCategory merged = expenseCategoryRepository.findByUuid(expenseCategory.getUuid());
    	
    	merged.setName(expenseCategory.getName());
    	merged.setDesc(expenseCategory.getDesc());
    	
		return expenseCategoryRepository.save(merged);
    }

    public void deleteExpenseCategory(String uuid) {
		
		expenseCategoryRepository.deleteByUuid(uuid);
    }

    public Iterable<Expense> getAllExpenses() {
		
		return expenseRepository.findAll();
    }

    public Expense getExpense(String uuid) {
		
		return expenseRepository.findByUuid(uuid);
    }
    
    public Expense saveExpense(Expense expense) {
		
		return expenseRepository.save(expense);
    }
    
    public Expense updateExpense(Expense expense) {
		
    	Expense merged = expenseRepository.findByUuid(expense.getUuid());
    	
    	merged.setDesc(expense.getDesc());
    	merged.setDueDate(expense.getDueDate());
    	merged.setPaymentDate(expense.getPaymentDate());
    	    	
		return expenseRepository.save(merged);
    }
    
    public void deleteExpense(String uuid) {
		
		expenseRepository.deleteByUuid(uuid);
    }
}