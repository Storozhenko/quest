package com.sam.quest.dao.hibernate;

import org.hibernate.Session;

public class InsertCommand <E> implements Command <Void>{
    E obj;

    public InsertCommand(E obj) {
        this.obj = obj;
    }
    public Void execute(Session session) throws Exception {
        session.save(obj);
        return null;
    }
}
