package com.entity;

/**
 * Created by feng on 2019/3/15.
 */
public class ProductEntity {

    private int id;
    private String name;
    private double price;
    private ProductTypeEntity productType;


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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductTypeEntity getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeEntity productType) {
        this.productType = productType;
    }


    public ProductEntity(int id, String name, double price, ProductTypeEntity productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public ProductEntity(String name, double price, ProductTypeEntity productType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public ProductEntity() {
    }
}
