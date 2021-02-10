package org.promytheus.koino.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.promytheus.koino.model.Expense;
import org.promytheus.koino.model.ExpenseCategory;
import org.promytheus.koino.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {

    private Logger logger = LogManager.getLogger(ExpenseController.class);

    @Autowired
	private ExpenseService expenseService;
	
    @GetMapping("/category")
    public Iterable<ExpenseCategory> getCategories() {

        logger.info("[GET] /api/v1/expense/category");

        return expenseService.getAllExpenseCategories();
    }

    @GetMapping("/category/{uuid}")
    public ExpenseCategory getCategory(@PathVariable String uuid) {

        logger.info("[GET] /api/v1/expense/category/{uuid}");

        return expenseService.getExpenseCategory(uuid);
    }

    @PostMapping("/category")
	public ExpenseCategory saveCategory(@RequestBody ExpenseCategory expenseCategory) {

        logger.info("[POST] /api/v1/expense/category");

        return expenseService.saveExpenseCategory(expenseCategory);
    }

    @PutMapping("/category")
	public ExpenseCategory updateCategory(@RequestBody ExpenseCategory expenseCategory) {

        logger.info("[PUT] /api/v1/expense/category");

        return expenseService.updateExpenseCategory(expenseCategory);
    }

    @DeleteMapping("/category/{uuid}")
	public void deleteCategory(@PathVariable String uuid) {

        logger.info("[DELETE] /api/v1/expense/category/{uuid}");

        expenseService.deleteExpenseCategory(uuid);
    }

    @GetMapping
    public Iterable<Expense> getExpenses() {

        logger.info("[GET] /api/v1/expense");

        return expenseService.getAllExpenses();
    }

    @GetMapping("/{uuid}")
    public Expense getExpenses(@PathVariable String uuid) {

        logger.info("[GET] /api/v1/expense/{uuid}");

        return expenseService.getExpense(uuid);
    }

    @PostMapping
    public Expense saveExpense(@RequestBody Expense expense) {

        logger.info("[POST] /api/v1/expense");

        return expenseService.saveExpense(expense);
    }

    @PutMapping
    public Expense updateExpense(@RequestBody Expense expense) {

        logger.info("[PUT] /api/v1/expense");

        return expenseService.updateExpense(expense);
    }

    @DeleteMapping("/{uuid}")
    public void deleteExpense(@PathVariable String uuid) {

        logger.info("[DELETE] /api/v1/expense/{uuid}");

        expenseService.deleteExpense(uuid);
    }
}
