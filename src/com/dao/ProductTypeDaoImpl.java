package com.dao;

import com.entity.ProductTypeEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by feng on 2019/3/15.
 */
@Repository
public class ProductTypeDaoImpl implements IProductTypeDao {

    @Resource
    JdbcTemplate template;

    @Override
    public void addPro(ProductTypeEntity pro) {
        //sql
        String sql="INSERT into t_productType(name) value(?)";
        Object[] args={pro.getName()};
        //执行
        int update = template.update(sql, args);
        System.out.println("addPro return :"+ update);
    }

    @Override
    public void updatePro(ProductTypeEntity pro) {
        //sql
        String sql="update t_productType set name=?  where id=? ";
        Object[] args={pro.getName(),pro.getId()};
        //执行
        int update = template.update(sql, args);
        System.out.println("updatePro return :"+ update);
    }

    @Override
    public void deletePro(int id) {
        //sql
        String sql="delete from t_productType where id = ? ";
        Object[] args={id};
        //执行
        int update = template.update(sql, args);
        System.out.println("deletePro return :"+ update);
    }

    @Override
    public ProductTypeEntity findById(int id) {
        //sql
        String sql="select * from t_productType where id =? ";
        Object[] args={id};
        //rowMapper
        RowMapper<ProductTypeEntity> rowMapper=new RowMapper<ProductTypeEntity>() {
            @Override
            public ProductTypeEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                ProductTypeEntity pro=new ProductTypeEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                return pro;
            }
        };
        //执行
        ProductTypeEntity productTypeEntity = template.queryForObject(sql, args, rowMapper);
        return productTypeEntity;
    }

    @Override
    public List<ProductTypeEntity> findAll() {
        //sql
        String sql="select * from t_productType ";
        //rowMapper
        RowMapper<ProductTypeEntity> rowMapper=new RowMapper<ProductTypeEntity>() {
            @Override
            public ProductTypeEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                ProductTypeEntity pro=new ProductTypeEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                return pro;
            }
        };
        //执行
        List<ProductTypeEntity> list = template.query(sql, rowMapper);
        return list;
    }



}
