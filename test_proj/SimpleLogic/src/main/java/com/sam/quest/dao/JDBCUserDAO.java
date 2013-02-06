package com.sam.quest.dao;


import com.sam.quest.dao.factory.JDBCDAOFactory;
import com.sam.quest.entity.Users;

import java.sql.*;

public class JDBCUserDAO implements UserDAO {

    private boolean res;
    private Statement stmt;
    private ResultSet rs;
    private Connection con;
    private PreparedStatement prepStmt = null;

    public boolean insertUser(Users user){
        try {
            res = true;
            con = JDBCDAOFactory.createConnection();
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
            JDBCDAOFactory.closeConnection();
        }
        return res;
    }

    public boolean deleteUser(Users user){
        try {
            res = true;
            con = JDBCDAOFactory.createConnection();
            prepStmt = con.prepareStatement("delete from forms_db.users where username=? ;");
            prepStmt.setString(1, user.getUsername());
            prepStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JDBCDAOFactory.closeConnection();
        }
        return res;
    }

    public Users findUser(int userId){
        return new Users();
    }

    public boolean updateUser(Users user){
        try {
            res = true;
            con = JDBCDAOFactory.createConnection();
            prepStmt = con.prepareStatement("update forms_db.users set password=?, user_type=?, user_lang=? " +
                    "where username=?;");
            prepStmt.setString(4, user.getUsername());
            prepStmt.setString(1, user.getPassword());
            prepStmt.setString(2, user.getUserType());
            prepStmt.setString(3, user.getUserLang());
            prepStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JDBCDAOFactory.closeConnection();
        }
        return res;
    }
}
