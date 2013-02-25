package com.sam.quest.command;

import org.hibernate.Session;

public class FindCommand<E> implements Command <E> {
    E obj;
    long id;

    public FindCommand(long id, E obj) {
        this.obj = obj;
        this.id = id;
    }

    public E execute(Session session) throws Exception{
        obj = (E)session.get(obj.getClass(), id);
        return obj;
    }
}
