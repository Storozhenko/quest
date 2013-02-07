package com.sam.quest.dao.factory;

import com.sam.quest.dao.*;

public class HiberDAOFactory extends DAOFactory{

    public UserDAO getUserDAO() {
        return new HiberUserDAO();
    }

    public FormDAO getFormDAO() {
        return new HiberFormDAO();
    }

    public QuestionDAO getQuestionDAO() {
        return new HiberQuestionDAO();
    }
}
