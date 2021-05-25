package com.XiaoFeng.controller;

import com.XiaoFeng.Dao.ProductDao;
import com.XiaoFeng.model.Category;
import com.XiaoFeng.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {

    Connection con=null;

    @Override
    public void init() throws ServletException {
        super.init();
        con= (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(con==null){
            System.out.println("Shop中con未连接");
            try {
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=userdb","sa","123456");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //Category category=new Category();
        try {
            List<Category> categoryList= Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        ProductDao productDao=new ProductDao();
        try {
            if(request.getParameter("categoryId")==null) {
                List<Product> productList=productDao.findAll(con);
                request.setAttribute("productList",productList);
            }else {
                int catId= Integer.parseInt(request.getParameter("categoryId"));
                List<Product> productList=productDao.findByCategoryId(catId,con);
                request.setAttribute("productList",productList);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String path="/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}