package com.dao;

import com.entity.ProductEntity;

import java.util.List;

/**
 * Created by feng on 2019/3/15.
 */
public interface IProductDao {

    //添加  修改  删除  findAll findById findByName
    void addPro(ProductEntity pro);
    void updatePro(ProductEntity pro);
    void deletePro(int id);

    ProductEntity findById(int id);
    List<ProductEntity> findByName(String name);
    List<ProductEntity> findAll();

}
