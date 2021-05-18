package com.XiaoFeng.Dao;

import com.XiaoFeng.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert
        String sql = "insert into usertable(username,password,email,gender,birthdate) values(?,?,?,?,?);";
        PreparedStatement st=con.prepareStatement(sql);
        //st.setString(1,String.valueOf(user.getId()));
        st.setString(1,user.getUsername());
        st.setString(2,user.getPassword());
        st.setString(3,user.getEmail());
        st.setString(4,user.getGender());
        st.setDate(5,(java.sql.Date)user.getBirthdate());
        int rs=st.executeUpdate();
        if (rs>0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete
        String sql = "delete from usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,user.getId());
        int rs=st.executeUpdate();
        return rs;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update
        String sql = "update usertable set email=?,username=?,password=?,birthdate=?,gender=?  where id =? ";
        System.out.println(user);
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,user.getEmail());
        st.setString(2,user.getUsername());
        st.setString(3,user.getPassword());
        st.setDate(4,(java.sql.Date)user.getBirthdate());
        st.setString(5,user.getGender());
        st.setInt(6,user.getId());
        int rs=st.executeUpdate();
        System.out.println(rs);
        return rs;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "select * from usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,id);
        ResultSet rs=st.executeQuery();
        User user=null;
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }


    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        // select by Password and username
        String sql="select id,username,password,email,gender,birthdate from usertable where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        System.out.println("无误11");
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        //select by username
        String sql = "select * from usertable where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs=st.executeQuery();
        User user=null;
        List<User> userList = new ArrayList<>();
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        //select by password
        String sql = "select * from usertable where password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        List<User> userList = new ArrayList<>();
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        //select by email
        String sql = "select * from usertable where email=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs=st.executeQuery();
        User user=null;
        List<User> userList = new ArrayList<>();
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        //select by gender
        String sql = "select * from usertable where gender=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs=st.executeQuery();
        User user=null;
        List<User> userList = new ArrayList<>();
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        //select by birthdate
        String sql = "select * from usertable where birthDate=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setDate(1,(java.sql.Date)birthDate);
        ResultSet rs=st.executeQuery();
        User user=null;
        List<User> userList = new ArrayList<>();
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        //select * from usertable
        String sql = "select * from usertable ";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        List<User> userList = new ArrayList<>();
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }
    public static Connection getcon(){
        Connection con=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con= DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=userdb","sa", "123456");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
