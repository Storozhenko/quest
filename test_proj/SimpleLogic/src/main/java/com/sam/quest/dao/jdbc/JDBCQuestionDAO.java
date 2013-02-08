package com.sam.quest.dao.jdbc;


import com.sam.quest.dao.MultiDAO;
import com.sam.quest.dao.factory.JDBCDAOUserFactory;
import com.sam.quest.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCQuestionDAO<E> implements MultiDAO<E> {

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
