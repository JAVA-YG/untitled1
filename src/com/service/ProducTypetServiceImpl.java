package com.service;

import com.dao.ProductTypeDaoImpl;
import com.entity.ProductTypeEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by feng on 2019/3/15.
 */
@Service
public class ProducTypetServiceImpl implements IProducTypetService{

    @Resource
    ProductTypeDaoImpl typeDao;

    @Override
    public void addPro(ProductTypeEntity pro) {
        typeDao.addPro(pro);
    }

    @Override
    public void updatePro(ProductTypeEntity pro) {
typeDao.updatePro(pro);
    }

    @Override
    public void deletePro(int id) {
typeDao.deletePro(id);
    }

    @Override
    public ProductTypeEntity findById(int id) {
        return typeDao.findById(id);
    }

    @Override
    public List<ProductTypeEntity> findAll() {
        return typeDao.findAll();
    }
}
