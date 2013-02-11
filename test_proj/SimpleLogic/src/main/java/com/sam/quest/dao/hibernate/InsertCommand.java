package com.sam.quest.dao.hibernate;

import org.hibernate.Session;

public class InsertCommand<E> implements Command {
    E obj;
    public InsertCommand(E obj) {
        this.obj = obj;
    }
    public void execute(Session session) throws Exception{
        session.save(obj);
    }
}
