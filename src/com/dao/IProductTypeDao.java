package com.dao;

import com.entity.ProductTypeEntity;

import java.util.List;

/**
 * Created by feng on 2019/3/15.
 */
public interface IProductTypeDao {

    void addPro(ProductTypeEntity pro);
    void updatePro(ProductTypeEntity pro);
    void deletePro(int id);

    ProductTypeEntity findById(int id);
    List<ProductTypeEntity> findAll();


}
