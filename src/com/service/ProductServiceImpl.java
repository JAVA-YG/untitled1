package com.service;

import com.dao.ProductDaoImpl;
import com.entity.ProductEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by feng on 2019/3/15.
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    ProductDaoImpl dao;

    @Override
    public void addPro(ProductEntity pro) {
        dao.addPro(pro);
    }

    @Override
    public void updatePro(ProductEntity pro) {
       dao.updatePro(pro);
    }

    @Override
    public void deletePro(int id) {
       dao.deletePro(id);
    }

    @Override
    public ProductEntity findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<ProductEntity> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public List<ProductEntity> findAll() {
        return dao.findAll();
    }
}
