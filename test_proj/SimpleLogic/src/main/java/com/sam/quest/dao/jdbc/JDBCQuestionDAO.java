package com.sam.quest.dao.jdbc;


import com.sam.quest.dao.MultiDAO;
import com.sam.quest.dao.factory.JDBCDAOUserFactory;
import com.sam.quest.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCQuestionDAO<E> implements MultiDAO<E> {

    private boolean res;
    private Statement stmt;
    private ResultSet rs;
    private Connection con;
    private PreparedStatement prepStmt = null;

    public boolean insertRecord(Object obj){
        try {
            res = true;
            Users user = (Users)obj;
            con = JDBCDAOUserFactory.createConnection();
            prepStmt = con.prepareStatement("insert into forms_db.users values (default, ?, ?, ?, ?);");
            prepStmt.setString(1, user.getUsername());
            prepStmt.setString(2, user.getPassword());
            prepStmt.setString(3, user.getUserType());
            prepStmt.setString(4, user.getUserLang());
            prepStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JDBCDAOUserFactory.closeConnection();
        }
        return res;
    }

    public boolean deleteRecord(Object obj){
        try {
            res = true;
            Users user = (Users)obj;
            con = JDBCDAOUserFactory.createConnection();
            prepStmt = con.prepareStatement("delete from forms_db.users where username=? ;");
            prepStmt.setString(1, user.getUsername());
            prepStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JDBCDAOUserFactory.closeConnection();
        }
        return res;
    }

    public E findRecord(long userId, E obj){
        Users user = (Users)obj;
        try {
            res = true;
            con = JDBCDAOUserFactory.createConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from forms_db.users where user_id=" + String.valueOf(userId) + ";");
            while (rs.next()) {
                user.setUserId(rs.getLong("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setUserType(rs.getString("user_type"));
                user.setUserLang(rs.getString("user_lang"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JDBCDAOUserFactory.closeConnection();
        }
        return (E)user;
    }

    public boolean updateRecord(Object obj){
        try {
            res = true;
            Users user = (Users)obj;
            con = JDBCDAOUserFactory.createConnection();
            prepStmt = con.prepareStatement("update forms_db.users set username=?, password=?, user_type=?, user_lang=? " +
                    "where user_id=?;");
            prepStmt.setString(1, user.getUsername());
            prepStmt.setString(2, user.getPassword());
            prepStmt.setString(3, user.getUserType());
            prepStmt.setString(4, user.getUserLang());
            prepStmt.setString(5, String.valueOf(user.getUserId()));
            prepStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JDBCDAOUserFactory.closeConnection();
        }
        return res;
    }
}
