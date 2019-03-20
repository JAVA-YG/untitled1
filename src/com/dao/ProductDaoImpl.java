package com.dao;

import com.entity.ProductEntity;
import com.entity.ProductTypeEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
public class ProductDaoImpl implements IProductDao {

    @Resource
    JdbcTemplate template;

    @Resource
    ProductTypeDaoImpl typeDao;


    @Override
    public void addPro(ProductEntity pro) {
        //sql
        String sql="INSERT into t_product(name,price,pid) value(?,?,?)";
        Object[] args={pro.getName(),pro.getPrice(),pro.getProductType().getId()};
        //执行
        int update = template.update(sql, args);
        System.out.println("addPro return :"+ update);
    }

    @Override
    public void updatePro(ProductEntity pro) {
        //sql
        String sql="update t_product set name=?,price=?,pid=? where id=?";
        Object[] args={pro.getName(),pro.getPrice(),pro.getProductType().getId(),pro.getId()};
        //执行
        int update = template.update(sql, args);
        System.out.println("updatePro return :"+ update);
    }

    @Override
    public void deletePro(int id) {
        //sql
        String sql="delete from t_product where id = ?";
        Object[] args={id};
        //执行
        int update = template.update(sql, args);
        System.out.println("deletePro return :"+ update);
    }

    @Override
    public ProductEntity findById(int id) {
        //sql
        String sql="select * from t_product where id = ? ";
        Object[] args={id};
        //将查询数据封装到对象
        RowMapper<ProductEntity> rowMapper=new RowMapper<ProductEntity>() {
            @Override
            public ProductEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                ProductEntity pro=new ProductEntity();
                pro.setId(resultSet.getInt("id"));
                pro.setName(resultSet.getString("name"));
                pro.setPrice(resultSet.getDouble("price"));
                //获取类型Id
                int pid=resultSet.getInt("pid");
                //获取类型对象
                ProductTypeEntity byId = typeDao.findById(pid);
                pro.setProductType(byId);
                return pro;
            }
        };
        //执行查询
        ProductEntity productEntity = template.queryForObject(sql, args, rowMapper);
        return productEntity;
    }

    @Override
    public List<ProductEntity> findByName(String name) {
        //sql
        String sql="select * from t_product where name like ? ";
        Object[] args={"%"+name+"%"};
        //将查询数据封装到对象
        RowMapper<ProductEntity> rowMapper=new RowMapper<ProductEntity>() {
            @Override
            public ProductEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                ProductEntity pro=new ProductEntity();
                pro.setId(resultSet.getInt("id"));
                pro.setName(resultSet.getString("name"));
                pro.setPrice(resultSet.getDouble("price"));
                //获取类型Id
                int pid=resultSet.getInt("pid");
                //获取类型对象
                ProductTypeEntity byId = typeDao.findById(pid);
                pro.setProductType(byId);
                return pro;
            }
        };
        //执行查询
        List<ProductEntity>  list = template.query(sql, args, rowMapper);
        return list;
    }

    @Override
    public List<ProductEntity> findAll() {
        //sql
        String sql="select * from t_product ";
        //将查询数据封装到对象
        RowMapper<ProductEntity> rowMapper=new RowMapper<ProductEntity>() {
            @Override
            public ProductEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                ProductEntity pro=new ProductEntity();
                pro.setId(resultSet.getInt("id"));
                pro.setName(resultSet.getString("name"));
                pro.setPrice(resultSet.getDouble("price"));
                //获取类型Id
                int pid=resultSet.getInt("pid");
                //获取类型对象
                ProductTypeEntity byId = typeDao.findById(pid);
                pro.setProductType(byId);
                return pro;
            }
        };
        //执行查询
        List<ProductEntity>  list = template.query(sql, rowMapper);
        return list;
    }



}
