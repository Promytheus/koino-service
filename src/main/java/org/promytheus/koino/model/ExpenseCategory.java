package org.promytheus.koino.model;

import java.io.Serializable;

public class ExpenseCategory implements Serializable {

    static final long serialVersionUID = 1L;

    private long id;

    private String name;
    private String desc;

    public ExpenseCategory() {
    }

    public ExpenseCategory(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
