package com.sam.quest.dao.hibernate;

import org.hibernate.Session;

import java.util.List;

public class GetListCommand <E> implements Command <E> {

    private E list;
    private Object obj;

    public GetListCommand(Object obj) {
        this.obj = obj;
    }

    public E execute(Session session) throws Exception{
        list = (E)session.createCriteria(obj.getClass()).list();
        return list;
    }
}
