package com.sam.quest.dao.hibernate;

import org.hibernate.Session;

public class UpdateCommand<E> implements Command {
    E obj;
    public UpdateCommand(E obj) {
        this.obj = obj;
    }
    public void execute(Session session) throws Exception{
        session.update(obj);
    }
}
