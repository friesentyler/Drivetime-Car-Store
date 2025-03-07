package com.gcu.carstoreapplication.data;

import com.gcu.carstoreapplication.model.DataAccessInterface;
import com.gcu.carstoreapplication.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDataService implements DataAccessInterface<ProductModel> {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public ProductDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<ProductModel> findAll() {
        String sql = "SELECT * FROM products";
        List<ProductModel> orders = new ArrayList<ProductModel>();
        try {
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
            while (srs.next()) {
                orders.add(new ProductModel(srs.getInt("id"), srs.getString("make"),
                        srs.getString("model"), srs.getFloat("price")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public ProductModel findById(int id) {
        return null;
    }

    public boolean create(ProductModel product) {
        String sql = "INSERT INTO products(make, model, price) VALUES(?, ?, ?)";
        try {
            int rows = jdbcTemplateObject.update(sql,
                    product.getMake(),
                    product.getModel(),
                    product.getPrice());
            return rows == 1 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(ProductModel product) {
        return true;
    }

    public boolean delete(ProductModel product) {
        return true;
    }
}

