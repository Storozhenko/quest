package com.sam.quest.dao.hibernate;

import org.hibernate.Session;

public class FindCommand<E> implements Command <E> {
    E obj;
    long id;

    public FindCommand(long id, E obj) {
        this.obj = obj;
        this.id = id;
    }

    public E execute(Session session) throws Exception{
        session.update(obj);
        obj = (E)session.get(obj.getClass(), id);
        return obj;
    }
}
