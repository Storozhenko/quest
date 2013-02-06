package com.sam.quest.dao;

public abstract class DAOFactory {
    public static final int HIBERNATE = 1;
    public static final int JDBC = 2;

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
