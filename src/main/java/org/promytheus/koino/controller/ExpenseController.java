package org.promytheus.koino.controller;

import org.promytheus.koino.model.ExpenseCategory;
import org.promytheus.koino.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {

    @Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/category")
	public Iterable<ExpenseCategory> getCategories() {

        return expenseService.getAllExpenseCategories();
    }

    @PostMapping("/category")
	public ExpenseCategory saveCategory(@RequestBody ExpenseCategory expenseCategory) {

        return expenseService.saveExpenseCategory(expenseCategory);
    }
}
