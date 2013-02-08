package com.sam.quest.dao.factory;

import com.sam.quest.dao.*;
import com.sam.quest.dao.jdbc.*;

import java.sql.*;
import javax.naming.*;

public class JDBCDAOUserFactory implements DAOFactory{

    static Connection con;
    static Statement stmt;
    static ResultSet rs;

    public static Connection createConnection() throws NamingException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://sc0181:3306/forms_db", "test", "123321");
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

    public MultiDAO getDAO() {
        return new JDBCUserDAO();
    }

}
