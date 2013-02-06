package com.sam.quest.dao;


import com.sam.quest.entity.Users;

import javax.naming.NamingException;
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
            prepStmt.setString(3, user.getUser_type());
            prepStmt.setString(4, user.getUser_lang());
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
            prepStmt = con.prepareStatement("delete from forms_db.users where username = ? ;");
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

    public Users findUser(int user_id){
        return new Users();
    }

    public boolean updateUser(Users user){
        try {
            res = true;
            con = JDBCDAOFactory.createConnection();
            prepStmt = con.prepareStatement("insert into forms_db.users values (default, ?, ?, ?, ?)");
            prepStmt.setString(1, user.getUsername());
            prepStmt.setString(2, user.getPassword());
            prepStmt.setString(3, user.getUser_type());
            prepStmt.setString(4, user.getUser_lang());
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
