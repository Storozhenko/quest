package com.sam.quest.dao.factory;

import com.sam.quest.dao.*;

public abstract class DAOFactory {
    public static final int HIBERNATE = 1;
    public static final int JDBC = 2;

    public abstract UserDAO getUserDAO();
    public abstract FormDAO getFormDAO();
    public abstract QuestionDAO getQuestionDAO();
    public abstract AnswFormDAO getAnswFormDAO();
    public abstract AnswQuestionDAO getAnswQuestionDAO();
    public abstract FormDataDAO getFormDataDAO();

    public static DAOFactory getFactory(int factoryType) {

        switch (factoryType) {
            case HIBERNATE:
                return new HiberDAOFactory();
            case JDBC:
                return new JDBCDAOFactory();
            default:
                return null;
        }
    }
}
