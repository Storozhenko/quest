package com.sam.quest.dao;


public class JDBCDAOFactory extends DAOFactory{

    public UserDAO getUserDAO() {
        return new JDBCUserDAO();
    }
}
