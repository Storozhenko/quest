package com.sam.quest.dao.jdbc;

import com.sam.quest.dao.MultiDAO;

public class JDBCFormDataDAO<E> implements MultiDAO<E> {

    public boolean insertRecord(Object obj){
        return true;
    }

    public boolean deleteRecord(Object obj){
        return true;
    }

    public E findRecord(long userId, E obj){
        return obj;
    }

    public boolean updateRecord(Object obj){
        return true;
    }
}
