package com.entity;

/**
 * Created by feng on 2019/3/15.
 */
public class ProductTypeEntity {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductTypeEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductTypeEntity(String name) {
        this.name = name;
    }

    public ProductTypeEntity() {
    }
}
