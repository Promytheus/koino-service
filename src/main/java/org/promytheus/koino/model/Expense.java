package org.promytheus.koino.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Expense implements Serializable {

    static final long serialVersionUID = 1L;

    private String uuid;

    private ExpenseCategory category;
    private String desc;
    private Date dueDate;
    private Date paymentDate;

    public Expense() {
        uuid = UUID.randomUUID().toString();
    }

    public Expense(ExpenseCategory category, String desc, Date dueDate, Date paymentDate) {
        uuid = UUID.randomUUID().toString();
        this.category = category;
        this.desc = desc;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public String getUuid() {
        return uuid;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
