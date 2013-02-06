package com.sam.quest.dao.factory;

import com.sam.quest.dao.HiberUserDAO;
import com.sam.quest.dao.UserDAO;

public class HiberDAOFactory extends DAOFactory{

    public UserDAO getUserDAO() {
        return new HiberUserDAO();
    }
}
