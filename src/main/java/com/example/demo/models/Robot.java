package com.example.demo.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Robot {

    @Id
    private long id;
    private String model;
    private Date manufacturingDate;
    private Category category;

    public Robot() {
    }

    public Robot(long id, String model, Date manufacturingDate, Category category) {
        this.id = id;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.category = category;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufacturingDate() {
        return this.manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Robot id(long id) {
        setId(id);
        return this;
    }

    public Robot model(String model) {
        setModel(model);
        return this;
    }

    public Robot manufacturingDate(Date manufacturingDate) {
        setManufacturingDate(manufacturingDate);
        return this;
    }

    public Robot category(Category category) {
        setCategory(category);
        return this;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", model='" + getModel() + "'" + ", manufacturingDate='"
                + getManufacturingDate() + "'" + ", category='" + getCategory() + "'" + "}";
    }

}
