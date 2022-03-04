package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "Survivor_id")
    Survivor survivor;

    public Resource() {
    }

    public Resource(long id, Inventory inventory, Survivor survivor) {
        this.id = id;
        this.inventory = inventory;
        this.survivor = survivor;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Survivor getSurvivor() {
        return this.survivor;
    }

    public void setSurvivor(Survivor survivor) {
        this.survivor = survivor;
    }

    public Resource id(long id) {
        setId(id);
        return this;
    }

    public Resource inventory(Inventory inventory) {
        setInventory(inventory);
        return this;
    }

    public Resource survivor(Survivor survivor) {
        setSurvivor(survivor);
        return this;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", inventory='" + getInventory() + "'" + ", survivor='" + getSurvivor()
                + "'" + "}";
    }

}
