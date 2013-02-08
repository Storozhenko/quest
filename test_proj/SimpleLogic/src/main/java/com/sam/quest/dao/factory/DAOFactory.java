package com.sam.quest.dao.factory;

import com.sam.quest.dao.*;

public interface DAOFactory {
   /* public static final int HIBERNATE = 1;
    public static final int JDBC = 2;

    public abstract MultiDAO getMultiDAO();
    public abstract MultiDAO getFormDAO();
    public abstract MultiDAO getUserDAO();  */

    public MultiDAO getFactory(/*int factoryType*/);/* {

        switch (factoryType) {
            case HIBERNATE:
                return new HiberDAOFactory();
            case JDBC:
                return new JDBCDAOUserFactory();
            default:
                return null;
        }
    }  */
}
