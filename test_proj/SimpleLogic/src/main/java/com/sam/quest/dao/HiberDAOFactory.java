package com.sam.quest.dao;

public class HiberDAOFactory extends DAOFactory{
    public UserDAO getUserDAO() {
        return userDAO;
    }
}
