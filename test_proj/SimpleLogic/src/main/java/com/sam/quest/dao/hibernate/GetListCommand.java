package com.sam.quest.dao.hibernate;

import org.hibernate.Session;

public class GetListCommand <E, T> implements Command <E> {

    E list;
    T obj;

    public GetListCommand(E list, T obj) {
        this.obj = obj;
        this.list = list;
    }

    public E execute(Session session) throws Exception{
        list = (E)session.createCriteria(obj.getClass()).list();
        return list;
    }
}
