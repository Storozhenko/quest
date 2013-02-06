package com.sam.quest.dao;


import com.sam.quest.entity.Users;

import javax.naming.NamingException;
import java.sql.*;

public class JDBCUserDAO implements UserDAO {

    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement prepStmt = null;

    public boolean insertUser(Users user){
        try {
            stmt = JDBCDAOFactory.createConnection();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCDAOFactory.closeConnection();
        }

        return true;
    }
    public boolean deleteUser(Users user){
        return true;
    }
    public Users findUser(int user_id){
        return new Users();
    }
    public boolean updateUser(Users user){
        return true;
    }
}
