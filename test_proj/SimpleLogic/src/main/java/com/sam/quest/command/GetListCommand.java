package com.sam.quest.command;

import org.hibernate.Session;

public class GetListCommand <E> implements Command <E> {

    E list;
    Object obj;

    public GetListCommand(Object obj) {
        this.obj = obj;
        this.list = list;
    }

    public E execute(Session session) throws Exception{
        list = (E)session.createCriteria(obj.getClass()).list();
        return list;
    }
}
