package org.promytheus.koino.model;

import java.io.Serializable;
import java.util.UUID;

public class ExpenseCategory implements Serializable {

    static final long serialVersionUID = 1L;

    private String uuid;

    private String name;
    private String desc;

    public ExpenseCategory() {
        uuid = UUID.randomUUID().toString();
    }

    public ExpenseCategory(String name, String desc) {
        uuid = UUID.randomUUID().toString();
        this.name = name;
        this.desc = desc;
    }

    public String getUuid() {
        return uuid;
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
