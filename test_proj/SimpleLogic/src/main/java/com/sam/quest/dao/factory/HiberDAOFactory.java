package com.sam.quest.dao.factory;

import com.sam.quest.dao.*;
import com.sam.quest.dao.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HiberDAOFactory extends DAOFactory{

    private static SessionFactory sessionFactory;

    static {
        try {
            //creates the session factory from hibernate.cfg.xml
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed: " + ex);
            //throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

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
