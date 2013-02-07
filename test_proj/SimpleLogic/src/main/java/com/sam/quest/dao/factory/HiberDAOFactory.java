package com.sam.quest.dao.factory;

import com.sam.quest.dao.*;
import com.sam.quest.dao.hibernate.*;

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

    public AnswFormDAO getAnswFormDAO() {
        return new HiberAnswFormDAO();
    }

    public AnswQuestionDAO getAnswQuestionDAO() {
        return new HiberAnswQuestionDAO();
    }

    public FormDataDAO getFormDataDAO() {
        return new HiberFormDataDAO();
    }
}
