package com.sam.quest.dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

public class JDBCDAOFactory extends DAOFactory{

    //static String str;
    static Connection con;
    static Statement stmt;
    static ResultSet rs;

    public static Connection createConnection() throws NamingException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/forms_db", "root", "123321");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection() {
        try {
            if(rs != null)
                rs.close();
            if(stmt != null)
                stmt.close();
            if(con != null)
                con.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public UserDAO getUserDAO() {
        return new JDBCUserDAO();
    }
}
