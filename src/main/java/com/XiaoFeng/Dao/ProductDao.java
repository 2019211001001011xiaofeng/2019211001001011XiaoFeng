package com.XiaoFeng.Dao;

import com.XiaoFeng.model.Product;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        String sql = "delete from Product where ProductId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, String.valueOf(productId));
        return pt.executeUpdate();
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql = "update Product set ProductName=?,ProductDescription=?,picture=?,price=? where CategoryId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, instance.getProductName());
        pt.setString(2, instance.getProductDescription());
        if(instance.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, instance.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, instance.getPrice());
        pt.setInt(5, instance.getProductId());
        return pt.executeUpdate();
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        Product product=null;
        String sql = "select * from Product where ProductId=? ";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, productId);
        ResultSet rs=pt.executeQuery();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));

        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        Product product=null;
        String sql = "select * from Product where CategoryId=? ";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, categoryId);
        ResultSet rs=pt.executeQuery();
        List<Product> List=new ArrayList<>();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            List.add(product);
        }
        return List;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        Product product=null;
        String sql = "select * from Product where price between ? and ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setDouble(1, minPrice);
        pt.setDouble(2, maxPrice);
        ResultSet rs=pt.executeQuery();
        List<Product> List=new ArrayList<>();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            List.add(product);
        }
        return List;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        Product product=null;
        String sql = "select * FROM Product";
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs=pt.executeQuery();
        List<Product> List=new ArrayList<>();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            List.add(product);
        }
        return List;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        Product product=null;
        String sql = "select * FROM Product WHERE  ProductName = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, productName);
        ResultSet rs=pt.executeQuery();
        List<Product> List=new ArrayList<>();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            List.add(product);
        }
        return List;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        Product product=null;
        String sql = "select * from Product where ProductId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, productId);
        ResultSet rs=pt.executeQuery();
        List<Product> List=new ArrayList<>();
        if(rs.next()){
            product=new Product();
            product.setPicture(rs.getBinaryStream("picture"));
            List.add(product);
        }
        return List;
    }
}
