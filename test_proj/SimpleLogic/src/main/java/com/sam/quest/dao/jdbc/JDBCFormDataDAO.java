package com.sam.quest.dao.jdbc;

import com.sam.quest.dao.MultiDAO;

@Deprecated
public class JDBCFormDataDAO<E> implements MultiDAO<E> {

    public boolean insertRecord(E obj){
        return true;
    }

    public boolean deleteRecord(E obj){
        return true;
    }

    public E findRecord(long userId, E obj){
        return obj;
    }

    public boolean updateRecord(E obj){
        return true;
    }
}
