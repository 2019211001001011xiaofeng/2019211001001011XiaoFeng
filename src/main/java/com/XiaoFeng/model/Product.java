package com.XiaoFeng.model;

import java.io.InputStream;

public class Product {
    private int ProductId;
    private String ProductName;
    private String ProductDescription;
    private InputStream picture;
    private double price;
    private int CategoryId;

    public Product(){

    }

    public Product(int productId, String productName, String productDescription, InputStream picture, double price, int categoryId) {
        this.ProductId = productId;
        this.ProductName = productName;
        this.ProductDescription = productDescription;
        this.picture = picture;
        this.price = price;
        this.CategoryId = categoryId;
    }

    public int getProductId() {
        return ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public InputStream getPicture() {
        return picture;
    }

    public double getPrice() {
        return price;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public void setPicture(InputStream picture) {
        this.picture = picture;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + ProductId +
                ", ProductName='" + ProductName + '\'' +
                ", ProductDescription='" + ProductDescription + '\'' +
                ", picture=" + picture +
                ", price=" + price +
                ", CategoryId=" + CategoryId +
                '}';
    }
}
